package com.clearminds.componentes;

public class Celda {
	// Atributos
	private Producto producto;
	private int stock;
	private String codigo;

	// Constructor que recibe un parametro
	public Celda(String codigo) {
		super();
		this.codigo = codigo;
	}

	// Metodo de ingreso

	public void ingresarProducto(Producto producto, int stockInicial) {
		this.producto = producto;
		this.stock = stockInicial;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
