package control;

import logica.Blog;
import java.util.Map;

public class Controladora {
    private Map<Integer, Blog> Blogs;

    public Controladora() {
        blogs = new TreeMap<Integer, Blog>;
    }

    public void crearBlog(String nombre, string descripcion) {
        Blog b = new Blog(nombre, descripcion);
        blogs.put(b.getCodigo(), b);
    }

    public Map<Integer, string> obtenerBlogs() {
        Map<Integer, String> resultado = new TreeMap<Integer, String>();
        for (Blog b : blogs.values()) {
            resultado.put(b.getCodigo(), b.getNombre());
        }
        return resultado;
    }

    public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombre) throws Exception {
        if (!blogs.containsKey(codigoBlog))
            throw new Exception("El codigo de blog no es valido.");
        Blog b = blogs.get(codigoBlog);
        b.crearPublicacion(titulo, texto, nombre);
    }
