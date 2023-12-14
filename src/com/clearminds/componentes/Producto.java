package com.clearminds.componentes;

public class Producto {
	// Atributos
	private String codigo;
	private String nombre;
	private double precio;

	// Constructor
	public Producto(String codigo, String nombre, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public void incrementarPrecio(int porcentajeIncremento) {
		double incremento;
		incremento = (porcentajeIncremento / 100.0) * precio;
		precio += incremento;
	}

	public void disminuirPrecio(double valorDescuento) {
		precio -= valorDescuento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
