package com.clearminds.maquina;

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

	public void cargarProducto(Producto producto, String codigoCelda, int items) {
		int totalStock;
		Celda celdaRecuperada = buscarCelda(codigoCelda);
		totalStock = items + celdaRecuperada.getStock();
		celdaRecuperada.ingresarProducto(producto, totalStock);
	}

	public void mostrarProductos() {
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        
	        System.out.print("Celda: " + celda.getCodigo() + " Stock: " + celda.getStock() + " ");
	        
	        if (celda.getProducto() != null) {
	            System.out.println("Producto: " + celda.getProducto().getCodigo()
	                    + " Precio: " + celda.getProducto().getPrecio());
	        } else {
	            System.out.println("Sin producto asignado");
	        }
	    }
	}

}
