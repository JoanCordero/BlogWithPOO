package control;

import logica.Blog;
import java.util.Map;

public class Controladora {

    public static void main(String[] args) {

        Blog blog = new Blog("Mi Blog", "Blog de prueba");

        blog.agregarPublicacion("Primer post", "Contenido del primer post", "Steven");
        blog.agregarPublicacion("Segundo post", "Contenido del segundo post", "Mary");

        System.out.println("=== LISTA DE TITULOS ===");
        Map<Integer, String> titulos = blog.listarTitulos();
        for (Integer codigo : titulos.keySet()) {
            System.out.println(codigo + " - " + titulos.get(codigo));
        }

        blog.agregarComentario(1, "steven22@gmail.com", "192.164.0.1", "Excelente");
        blog.agregarComentario(1, "mary23@gmail.com", "192.164.0.2", "Aburrido");

        System.out.println("\n--- PUBLICACION 1 ---");
        System.out.println(blog.getPublicacionString(1));

        blog.eliminarComentario(1, 0);

        System.out.println("\n---- PUBLICACION 1 DESPUES DE ELIMINAR COMENTARIO ----");
        System.out.println(blog.getPublicacionString(1));
    }
}