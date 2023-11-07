package ejercicio2;

import javax.swing.JOptionPane;

public class Productos {

	private String nombre;
    private int cantidad;
    private double precio;

    public Productos(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void modificarProducto(String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        this.nombre = nuevoNombre;
        this.cantidad = nuevaCantidad;
        this.precio = nuevoPrecio;
    }

    public void venderProducto(int cantidadVendida) {
        if (cantidadVendida > 0 && cantidadVendida <= cantidad) {
            this.cantidad -= cantidadVendida;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede vender esa cantidad de productos.");
        }
    }
}
