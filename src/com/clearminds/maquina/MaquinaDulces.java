package com.clearminds.maquina;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;

	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public void agregarCelda(Celda codigo) {
		this.celdas.add(codigo);
	}

	Celda elementoCelda;

	public void mostrarConfiguracion() {
		for (int i = 0; i < celdas.size(); i++) {
			Celda celda = celdas.get(i);
			System.out.println("CELDA: " + celda.getCodigo());
		}
	}

	public Celda buscarCelda(String codigoCelda) {
		for (int i = 0; i < celdas.size(); i++) {
			Celda celda = celdas.get(i);
			if (celda.getCodigo().equals(codigoCelda)) {
				return celda;
			}
		}
		return null;
	}

	public void cargarProducto(Producto producto, String codigoCelda, int cantidad) {
		Celda celdaRecuperada = buscarCelda(codigoCelda);

		if (celdaRecuperada != null) {
			celdaRecuperada.ingresarProducto(producto, cantidad);
		} else {
			System.out.println("Celda no encontrada...");
		}
	}

	public void mostrarProductos() {
		for (int i = 0; i < celdas.size(); i++) {
			Celda celda = celdas.get(i);

			System.out.print("Celda: " + celda.getCodigo() + " Stock: " + celda.getStock() + " ");
			if (celda.getProducto() != null) {
				System.out.println(
						"Producto: " + celda.getProducto().getNombre() + " Precio: " + celda.getProducto().getPrecio());
			} else {
				System.out.println("Sin producto asignado");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Saldo: " + saldo);
		System.out.println("");
	}

	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celda = buscarCelda(codigoCelda);

		if (celda != null && celda.getProducto() != null) {
			return celda.getProducto();
		} else {
			return null;
		}
	}

	public double consultarPrecio(String codigoCelda) {
		Celda celda = buscarCelda(codigoCelda);

		if (celda != null && celda.getProducto() != null) {
			return celda.getProducto().getPrecio();
		} else {
			return 0.0;
		}
	}

	public Celda buscarCeldaProducto(String codigoProducto) {
		for (int i = 0; i < celdas.size(); i++) {
			Celda celda = celdas.get(i);
			if (celda != null && celda.getProducto() != null
					&& codigoProducto.equals(celda.getProducto().getCodigo())) {
				return celda;
			}
		}
		return null;
	}

	public void incrementarProductos(String codigoProducto, int itemsIncrementar) {
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);

		if (celdaEncontrada != null) {
			int nuevoStock = celdaEncontrada.getStock() + itemsIncrementar;
			celdaEncontrada.setStock(nuevoStock);
		}
	}

	public void vender(String codigoCelda) {
		Celda celdaEncontrada = buscarCelda(codigoCelda);

		if (celdaEncontrada != null && celdaEncontrada.getStock() > 0) {
			Producto producto = celdaEncontrada.getProducto();
			double precioProducto = producto.getPrecio();

			celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
			saldo += precioProducto;

			mostrarProductos();
		}
	}

	public double venderConCambio(String codigoCelda, double valorIngresado) {
		Celda celdaEncontrada = buscarCelda(codigoCelda);

		if (celdaEncontrada != null && celdaEncontrada.getStock() > 0) {
			Producto producto = celdaEncontrada.getProducto();
			double precioProducto = producto.getPrecio();

			if (valorIngresado >= precioProducto) {
				celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
				saldo += precioProducto;

				double cambio = valorIngresado - precioProducto;
				return cambio;
			} else {
				System.out.println("El valor ingresado es insuficiente para comprar el producto.");
				return valorIngresado;
			}
		} else {
			System.out.println("La celda no existe o está vacía.");
			return valorIngresado;
		}
	}

	public ArrayList<Producto> buscarMenores(double limite) {
		ArrayList<Producto> productosEncontrados = new ArrayList<Producto>();

		for (int i = 0; i < celdas.size(); i++) {
			Celda celda = celdas.get(i);
			Producto producto = celda.getProducto();

			if (producto != null && producto.getPrecio() <= limite) {
				productosEncontrados.add(producto);
			}
		}
		return productosEncontrados;
	}

}
