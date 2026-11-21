package principal;

import dao.ProductoDAO;
import java.util.List;
import modelo.Producto;

public class PruebaCrudProductos {

    public static void main(String[] args) {
        ProductoDAO productoDao = new ProductoDAO();

        // 1. INSERTAR un producto de prueba
        Producto nuevoProducto = new Producto(0, "Pan de Bono", "Panadería", 2000.0, 1000.0, "Unidad", 30);
        boolean inserto = productoDao.insertarProducto(nuevoProducto);
        System.out.println("1. Insertado: " + inserto);

        // 2. CONSULTAR todos los productos
        System.out.println("\n2. Lista de productos en panlogic_db:");
        List<Producto> lista = productoDao.consultarProductos();
        for (Producto p : lista) {
            System.out.println("ID: " + p.getIdProducto()
                    + " | Nombre: " + p.getNombre()
                    + " | Precio: $" + p.getPrecio()
                    + " | Stock: " + p.getStock());
        }

        // 3. ACTUALIZAR el último producto registrado (si hay alguno en la lista)
        if (!lista.isEmpty()) {
            Producto ultimo = lista.get(lista.size() - 1);
            ultimo.setPrecio(2200.0);
            ultimo.setStock(45);
            boolean actualizo = productoDao.actualizarProducto(ultimo);
            System.out.println("\n3. Actualizado (ID " + ultimo.getIdProducto() + "): " + actualizo);
        }

        // 4. ELIMINAR el último producto de prueba (si hay alguno en la lista)
        List<Producto> listaActualizada = productoDao.consultarProductos();
        if (!listaActualizada.isEmpty()) {
            Producto ultimoParaBorrar = listaActualizada.get(listaActualizada.size() - 1);
            boolean elimino = productoDao.eliminarProducto(ultimoParaBorrar.getIdProducto());
            System.out.println("4. Eliminado (ID " + ultimoParaBorrar.getIdProducto() + "): " + elimino);
        }
    }
}