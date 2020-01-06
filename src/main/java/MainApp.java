import models.ItemLista;
import models.Lista;
import models.Producto;
import models.Usuario;
import repositories.ListaRepository;
import repositories.ProductoRepository;
import repositories.UsuarioRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Inicio");

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("NewPersistenceUnit")
                .createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();

        /*CREACION DE BD*/
/*
        //Crear productos de antemano
        Producto p1 = new Producto("Leche", 10);
        Producto p2 = new Producto("Harina", 20);
        Producto p3 = new Producto("Pan", 30);
        Producto p4 = new Producto("Cereal", 25);
        Producto p5 = new Producto("Helado", 50);
        Producto p6 = new Producto("Vino", 60);
        Producto p7 = new Producto("Cerveza", 60);
        Producto p8 = new Producto("Vino", 60);
        Producto p9 = new Producto("Vino", 60);
        Producto p10 = new Producto("Vino", 60);

        //Creo usuario
        Usuario usuario1 = new Usuario("Joaquin", "A", "joaquin@gmail.com");
        Usuario usuario2 = new Usuario("Guillermo", "B", "guillermo@gmail.com");
        Usuario usuario3 = new Usuario("Nahuel", "C", "nahuel@gmail.com");

        //Transactions
        entityTransaction.begin();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(p4);
        entityManager.persist(p5);
        entityManager.persist(p6);
        entityManager.persist(p7);
        entityManager.persist(p8);
        entityManager.persist(p9);
        entityManager.persist(p10);
        entityManager.persist(usuario1);
        entityManager.persist(usuario2);
        entityManager.persist(usuario3);
        entityTransaction.commit();
*/

        /*UNA VEZ CREADP LA BD*/
/*
        //Crear lista
        Lista lista1 = new Lista(); //creo una nueva lista
        lista1.setNombreLista("Lista1"); //seteo nombre
        Usuario usuario1 = entityManager.find(Usuario.class, 11); //busco el usuario al que le creo la lista (hardcodeado en este caso)
        lista1.setUsuario(usuario1); //seteo el usuario a la lista
        usuario1.getListas().add(lista1); //le agrego la lista al usuario

        //Crear un item lista
        ItemLista itemLista1 = new ItemLista(); //creo un item lista
        itemLista1.setLista(lista1); //le seteo la lista al item
        Producto p1 = entityManager.find(Producto.class, 1); //busco el producto que voy a agregar
        itemLista1.setProducto(p1); //le seteo el producto
        itemLista1.setCantidad(2); //seteo la cantidad

        //Lo agrego a la lista
        lista1.getItems().add(itemLista1); //le agrego el item a la lista correspondiente

        //Transactions
        entityTransaction.begin();
        entityManager.persist(lista1); //persisto lista
        entityManager.persist(itemLista1); //persisto items
        entityTransaction.commit(); //commiteo
*/
        /*Test de Repositorios*/
        UsuarioRepository usuarioRepository = new UsuarioRepository(entityManager);
        ProductoRepository productoRepository = new ProductoRepository(entityManager);
        ListaRepository listaRepository = new ListaRepository(entityManager);

//        usuarioRepository.getAll().forEach(System.out::println);
//        productoRepository.getAll().forEach(System.out::println);

//        productoRepository.getByNombre("Leche").forEach(System.out::println);
//        productoRepository.getByPrecio(10).forEach(System.out::println);

        listaRepository.getAll().forEach(System.out::println);


        /*-----------------------------------------------*/
        /*EJEMPLOS*/
//        /* Persist a Producto entity */
//        entityTransaction.begin();
//        Producto producto = new Producto("Leche", 10);
//        entityManager.persist(producto);
//        entityTransaction.commit();
//        System.out.println("Se creo un producto");
//
//        /* Fetch a Producto entity */
//        Producto producto1 = entityManager.find(Producto.class, 1);
//        System.out.println("Se encontro un producto");
//
//        /* Update a Producto entity */
//        entityTransaction.begin();
//        Producto producto2 = entityManager.find(Producto.class, 1);
//        producto2.setNombreProducto("Harina");
//        producto2.setPrecioProducto(20);
//        entityManager.merge(producto2);
//        entityTransaction.commit();
//        System.out.println("Se modifico un producto");
//
//        /* Remove a Producto entity */
//        entityTransaction.begin();
//        Producto producto3 = entityManager.find(Producto.class, 1);
//        entityManager.remove(producto3);
//        entityTransaction.commit();
//        System.out.println("Se elimino un producto");

        entityManager.close();

        System.out.println("Fin");
    }
}
