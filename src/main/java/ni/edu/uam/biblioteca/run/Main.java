package ni.edu.uam.biblioteca.run;

import java.util.List;
import ni.edu.uam.biblioteca.entities.Autor;
import ni.edu.uam.biblioteca.entities.Categoria;
import ni.edu.uam.biblioteca.entities.Libro;
import ni.edu.uam.biblioteca.services.dao.MyDao;

public class Main {

    static MyDao dao = new MyDao();

    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel García Márquez");
        a.setNacionalidad("Colombiana");
        dao.insert(a);
    }

    public static void listarAutores() {
        System.out.println("Registros almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);
    }

    public static void eliminarAutor() {
        Autor a = dao.findById(2, Autor.class);
        dao.delete(a);
    }

    public static void insertarCategoria() {
        Categoria c = new Categoria();
        c.setNombre("Novela");
        dao.insert(c);
    }

    public static void listarCategorias() {
        System.out.println("Registros almacenados:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(categoria -> System.out.println(categoria.getNombre()));
    }

    public static void editarCategoria() {
        Categoria c = dao.findById(1, Categoria.class);
        c.setNombre("Ciencia Ficción");
        dao.update(c);
    }

    public static void eliminarCategoria() {
        Categoria c = dao.findById(2, Categoria.class);
        dao.delete(c);
    }

    public static void insertarLibro() {
        Libro l = new Libro();
        l.setTitulo("Cien años de soledad");
        l.setAñoPub(1967);

        Autor a = dao.findById(1, Autor.class);
        Categoria c = dao.findById(1, Categoria.class);

        l.setAutor(a);
        l.setCategoria(c);

        dao.insert(l);
    }

    public static void listarLibros() {
        System.out.println("Registros almacenados:");
        List<Libro> libros = dao.getAll("libros", Libro.class);
        libros.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    public static void editarLibro() {
        Libro l = dao.findById(1, Libro.class);
        l.setTitulo("El amor en los tiempos del cólera");
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = dao.findById(2, Libro.class);
        dao.delete(l);
    }

    // -----------------------------
    //             MAIN
    // -----------------------------

    public static void main(String[] args) {
        // AUTOR
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();

        // CATEGORIA
        insertarCategoria();
        listarCategorias();
        editarCategoria();
        listarCategorias();
        eliminarCategoria();
        listarCategorias();

        // LIBRO
        insertarLibro();
        listarLibros();
        editarLibro();
        listarLibros();
        eliminarLibro();
        listarLibros();
    }
}
