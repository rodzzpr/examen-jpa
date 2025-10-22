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

        Autor r = new Autor();
        r.setNombre("Rubén Darío");
        r.setNacionalidad("Nicaragüense");
        dao.insert(r);
    }

    public static void listarAutores() {
        System.out.println("Registros almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(a -> System.out.println(a.getNombre()));
    }

    public static void editarAutor() {
        Autor a = dao.findById(1, Autor.class);
        if (a != null) {
            a.setNacionalidad("Colombiano");
            dao.update(a);
        }
    }

    public static void eliminarAutor() {
        Autor a = dao.findById(2, Autor.class);
        if (a != null) {
            dao.delete(a);
        }
    }

    public static void insertarCategoria() {
        Categoria c = new Categoria();
        c.setNombre("Novela");
        dao.insert(c);
    }

    public static void listarCategorias() {
        System.out.println("Registros almacenados:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(c -> System.out.println(c.getNombre()));
    }

    public static void editarCategoria() {
        Categoria c = dao.findById(1, Categoria.class);
        if (c != null) {
            c.setNombre("Ciencia Ficción");
            dao.update(c);
        }
    }

    public static void eliminarCategoria() {
        Categoria c = dao.findById(2, Categoria.class);
        if (c != null) {
            dao.delete(c);
        }
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
        libros.forEach(l -> System.out.println(l.getTitulo()));
    }

    public static void editarLibro() {
        Libro l = dao.findById(1, Libro.class);
        if (l != null) {
            l.setTitulo("El amor en los tiempos del cólera");
            dao.update(l);
        }
    }

    public static void eliminarLibro() {
        Libro l = dao.findById(2, Libro.class);
        if (l != null) {
            dao.delete(l);
        }
    }

    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();

        insertarCategoria();
        listarCategorias();
        editarCategoria();
        listarCategorias();
        eliminarCategoria();
        listarCategorias();

        insertarLibro();
        listarLibros();
        editarLibro();
        listarLibros();
        eliminarLibro();
        listarLibros();
    }
}
