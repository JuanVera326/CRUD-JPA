package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.co.juanvera.aplicacion.Program;
import com.co.juanvera.dao.ProductoDao;
import com.co.juanvera.entidades.PersonasProductos;
import com.co.juanvera.entidades.Producto;

public class GestionProductos {
	ProductoDao miProductoDao = new ProductoDao();
	
	public GestionProductos() {
		Program miprogram = new Program();
		String menu = "MENU OPCIONES - GESTION PRODUCTOS\n\n";
		menu += "1. Registrar Producto\n";
		menu += "2. Consultar Producto\n";
		menu += "3. Consultar Lista Producto\n";
		menu += "4. Comprar Producto\n";
		menu += "5. Actualizar Producto\n";
		menu += "6. Eliminar Producto\n";
		menu += "7. Salir\n\n";
		
		int opc = 0;
		
		while (opc!=6) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar();; break;
			case 2: consultar(); break;
			case 3: cosultarLista(); break;
			case 4: comprar(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miProductoDao.close(); miprogram.iniciar(); break;
			}
		}
	}
	private void eliminar() {
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del Producto a Eliminar: "));
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
		
		if (miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
			System.out.println(miProductoDao.eliminarProducto(miProducto));
		}else {
			System.out.println();
			System.out.println("No se encontro el Producto a Eliminar!!");
		}System.out.println();		
	}

	private void actualizar() {
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del Producto a Actualizar:"));
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
	
		if (miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el Nuevo nombre del Producto:"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Nuevo valor del Producto:")));
			System.out.println(miProductoDao.actualizarProducto(miProducto));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se Encontro el Producto para Actualizar!!");
		}
	}

	private void comprar() {
		
		Long personaid;
		Long productoid;
		int opc = Integer.parseInt(JOptionPane.showInputDialog("Desea Comprar un Producto?\n1: No\n2: Si"));
		while (opc == 2){
			PersonasProductos producto = new PersonasProductos();
			personaid = Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona"));
			productoid = Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
			producto.setPersonaId(personaid);
			producto.setProductoId(productoid);
			
			System.out.println(miProductoDao.registrarCompra(producto));
			System.out.println();
			opc = Integer.parseInt(JOptionPane.showInputDialog("Desea Comprar otro Producto?\n1: No\n2: Si"));
		}
		
	}

	private void cosultarLista() {
		System.out.println("Lista de Productos!!");
		List<Producto> listProductos = miProductoDao.consultarListaProductos();
		
		for (Producto producto : listProductos) {
			System.out.println(producto);
		}
	}

	private void consultar() {
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese ID del Producto a Consultar:"));
		
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
		
		if (miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se Encontro el Producto!!");
		}
		
	}

	private void registrar() {
		Producto miProducto = new Producto();
		
		miProducto.setIdProducto(null);
		miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el Nombre del Producto a registrar"));
		miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto")));
		
		System.out.println(miProductoDao.registrarProducto(miProducto));
		
	}
}


