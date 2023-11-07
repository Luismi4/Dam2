package ejercicio2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Act2 extends JFrame {

	public static void main(String[] args) {
		Map<String, Productos> inventario = new HashMap<>();
		Map<String, Integer> ventasCantidad = new HashMap<>();
	    Map<String, Double> ventasPrecio = new HashMap<>();
	    
		JFrame frame = new JFrame("Gestión de Tienda con Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem agregarProductoItem = new JMenuItem("Agregar Producto");
        JMenuItem verInventarioItem = new JMenuItem("Ver Inventario");
        JMenuItem modificarProductoItem = new JMenuItem("Modificar Producto");
        JMenuItem eliminarProductoItem = new JMenuItem("Eliminar Producto");
        JMenuItem venderProductoItem = new JMenuItem("Vender Producto");
        JMenuItem verVentasItem = new JMenuItem("Ver Ventas");
        JMenuItem salirItem = new JMenuItem("Salir");

        menu.add(agregarProductoItem);
        menu.add(verInventarioItem);
        menu.add(modificarProductoItem);
        menu.add(eliminarProductoItem);
        menu.add(venderProductoItem);
        menu.add(verVentasItem);
        menu.add(salirItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        agregarProductoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para agregar un producto
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto:");
                if (nombre != null && !nombre.isEmpty()) {
                    try {
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad de " + nombre + ":"));
                        double precio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingrese el precio de " + nombre + ":"));

                        Productos producto = new Productos(nombre, cantidad, precio);
                        inventario.put(nombre, producto);
                        JOptionPane.showMessageDialog(frame, "Producto agregado al inventario con éxito.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Los valores ingresados no son válidos.");
                    }
                }
            }
        });

        verInventarioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para ver el inventario
                StringBuilder inventarioStr = new StringBuilder("Inventario de Productos:\n");
                for (Productos producto : inventario.values()) {
                    inventarioStr.append("Nombre: ").append(producto.getNombre())
                            .append(", Cantidad: ").append(producto.getCantidad())
                            .append(", Precio: ").append(producto.getPrecio()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, inventarioStr.toString());
            }
        });

        modificarProductoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para modificar un producto
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a modificar:");
                if (inventario.containsKey(nombre)) {
                    try {
                    	Productos producto = inventario.get(nombre);
                        String nuevoNombre = JOptionPane.showInputDialog(frame, "Ingrese el nuevo nombre:");
                        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la nueva cantidad:"));
                        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingrese el nuevo precio:"));

                        producto.modificarProducto(nuevoNombre, nuevaCantidad, nuevoPrecio);
                        JOptionPane.showMessageDialog(frame, "Producto modificado con éxito.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Los valores ingresados no son válidos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El producto no existe en el inventario.");
                }
            }
        });

        eliminarProductoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para eliminar un producto
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a eliminar:");
                if (inventario.containsKey(nombre)) {
                    inventario.remove(nombre);
                    JOptionPane.showMessageDialog(frame, "Producto eliminado del inventario con éxito.");
                } else {
                    JOptionPane.showMessageDialog(frame, "El producto no existe en el inventario.");
                }
            }
        });

        venderProductoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para vender un producto
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a vender:");
                if (inventario.containsKey(nombre)) {
                    try {
                        Productos producto = inventario.get(nombre);
                        int cantidadVendida = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad a vender:"));
                        if (cantidadVendida > 0 && cantidadVendida <= producto.getCantidad()) {
                            producto.venderProducto(cantidadVendida);
                            int cantidad = ventasCantidad.containsKey(nombre) ? ventasCantidad.get(nombre) : 0;
                            ventasCantidad.put(nombre, cantidad + cantidadVendida);
                            double precioVenta = cantidadVendida * producto.getPrecio();
                            double precioTotal = ventasPrecio.containsKey(nombre) ? ventasPrecio.get(nombre) : 0.0;
                            ventasPrecio.put(nombre, precioTotal + precioVenta);
                            JOptionPane.showMessageDialog(frame, "Venta realizada con éxito. Precio Total: $" + precioVenta);
                        } else {
                            JOptionPane.showMessageDialog(frame, "No se puede vender esa cantidad de productos.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "La cantidad ingresada no es válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El producto no existe en el inventario.");
                }
            }
        });

        verVentasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para ver las ventas
                StringBuilder ventasStr = new StringBuilder("Registro de Ventas:\n");
                for (Map.Entry<String, Integer> entry : ventasCantidad.entrySet()) {
                    String nombre = entry.getKey();
                    int cantidad = entry.getValue();
                    double precioVenta = ventasPrecio.get(nombre);
                    ventasStr.append("Producto: ").append(nombre)
                            .append(", Cantidad Vendida: ").append(cantidad)
                            .append(", Precio Total: $").append(precioVenta).append("\n");
                }
                JOptionPane.showMessageDialog(frame, ventasStr.toString());
            }
        });

        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

}