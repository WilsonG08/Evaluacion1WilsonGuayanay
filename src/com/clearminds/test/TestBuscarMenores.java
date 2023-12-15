package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda(new Celda("A"));
		maquina.agregarCelda(new Celda("B"));
		maquina.agregarCelda(new Celda("C"));
		maquina.agregarCelda(new Celda("D"));
		maquina.agregarCelda(new Celda("E"));
		maquina.agregarCelda(new Celda("F"));
		
		
		Producto productoA = new Producto("K001", "Papitas", 0.85);
		maquina.cargarProducto(productoA, "A", 4);
		Producto productoB = new Producto("K002", "Doritos", 0.5);
		maquina.cargarProducto(productoB, "B", 6);
		Producto productoC = new Producto("K003", "Cheetos", 0.70);
		maquina.cargarProducto(productoC, "C", 8);
		Producto productoD = new Producto("K004", "Nachos", 1.5);
		maquina.cargarProducto(productoD, "D", 7);
		Producto productoE = new Producto("K005", "Tango", 1.20);
		maquina.cargarProducto(productoE, "E", 3);
		Producto productoF = new Producto("K006", "Golpe", 0.65);
		maquina.cargarProducto(productoF, "F", 2);
		
		double limitePrecio = 4.0; 

	    ArrayList<Producto> productosEncontrados = maquina.buscarMenores(1.0);

	    System.out.println("Productos con el precio menor o igual a " + limitePrecio + ":");
	    for (int i = 0; i < productosEncontrados.size(); i++) {
            Producto producto = productosEncontrados.get(i);
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
	        

	}

}
