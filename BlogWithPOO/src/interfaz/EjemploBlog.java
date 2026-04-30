package interfaz;

import java.util.Map;
import java.util.Scanner;

import control.Controladora;

public class EjemploBlog {

    private static Controladora controladora;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        controladora = new Controladora();

        cargarDatos();

        menuPrincipal();
    }

    private static void cargarDatos() {
        try {
            controladora.crearBlog("TechXtreme", "Noticias y tendencias de tecnologia");
            controladora.crearBlog("FitTec", "Consejos de salud y bienestar");

            controladora.crearPublicacion(1, "La IA en 2026",
                    "La inteligencia artificial esta transformando la forma en que trabajamos.",
                    "Elon Mendez");

            controladora.crearPublicacion(1, "Top lenguajes de programacion",
                    "Java, Python y JavaScript siguen liderando el mercado.",
                    "Bill Ramirez");

            controladora.crearPublicacion(2, "Rutinas para principiantes",
                    "Comenzar con ejercicios basicos es clave para mejorar la condicion fisica.",
                    "Allan Solis");

            controladora.crearPublicacion(2, "Alimentacion saludable",
                    "Una dieta balanceada ayuda a mejorar la energia y la calidad de vida.",
                    "Charles Fernandez");

            controladora.agregarComentario(1, 1, "elonm@gmail.com", "192.168.0.1",
                    "Excelente articulo, me parecio muy claro y actualizado.");

            controladora.agregarComentario(1, 1, "turing.dev@gmail.com", "192.168.0.2",
                    "Me gusto mucho la parte donde explica el impacto de la IA en el trabajo.");

            controladora.agregarComentario(1, 2, "coder123@gmail.com", "192.168.0.3",
                    "Buen resumen, aunque tambien agregaria Rust a la lista.");

            controladora.agregarComentario(2, 1, "fitnesslife@gmail.com", "192.168.0.4",
                    "Muy util para alguien que esta empezando desde cero.");

            controladora.agregarComentario(2, 2, "nutri.salud@gmail.com", "192.168.0.5",
                    "Totalmente de acuerdo, la alimentacion es fundamental para tener energia.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuPrincipal() {
        int opcion = 0;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Ver blogs");
            System.out.println("2. Crear blog");
            System.out.println("3. Borrar blog");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menuBlogs();
                    break;

                case 2:
                    crearBlog();
                    break;

                case 3:
                    borrarBlog();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 4);
    }

    public static void menuBlogs() {
        try {
            Map<Integer, String> blogs = controladora.obtenerBlogs();

            System.out.println("\n===== LISTADO DE BLOGS =====");

            for (Integer codigo : blogs.keySet()) {
                System.out.println(codigo + ". " + blogs.get(codigo));
            }

            System.out.print("Seleccione el codigo del blog: ");
            int codigoBlog = sc.nextInt();
            sc.nextLine();

            menuPublicaciones(codigoBlog);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuPublicaciones(int codigoBlog) {
        int opcion = 0;

        do {
            try {
                Map<Integer, String> publicaciones = controladora.obtenerPublicaciones(codigoBlog);

                System.out.println("\n===== PUBLICACIONES DEL BLOG =====");

                for (Integer codigo : publicaciones.keySet()) {
                    System.out.println(codigo + ". " + publicaciones.get(codigo));
                }

                System.out.println("\n1. Crear publicacion");
                System.out.println("2. Ver publicacion y comentarios");
                System.out.println("3. Regresar");
                System.out.print("Seleccione una opcion: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        crearPublicacion(codigoBlog);
                        break;

                    case 2:
                        verPublicacion(codigoBlog);
                        break;

                    case 3:
                        System.out.println("Regresando...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                opcion = 3;
            }

        } while (opcion != 3);
    }

    public static void crearBlog() {
        System.out.print("Digite el nombre del blog: ");
        String nombre = sc.nextLine();

        System.out.print("Digite la descripcion del blog: ");
        String descripcion = sc.nextLine();

        controladora.crearBlog(nombre, descripcion);

        System.out.println("Blog creado correctamente.");
    }

    public static void borrarBlog() {
        try {
            System.out.print("Digite el codigo del blog a borrar: ");
            int codigoBlog = sc.nextInt();
            sc.nextLine();

            controladora.borrarBlog(codigoBlog);

            System.out.println("Blog borrado correctamente.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearPublicacion(int codigoBlog) {
        try {
            System.out.print("Digite el titulo: ");
            String titulo = sc.nextLine();

            System.out.print("Digite el texto: ");
            String texto = sc.nextLine();

            System.out.print("Digite el nombre del creador: ");
            String nombre = sc.nextLine();

            controladora.crearPublicacion(codigoBlog, titulo, texto, nombre);

            System.out.println("Publicacion creada correctamente.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void verPublicacion(int codigoBlog) {
        try {
            System.out.print("Digite el codigo de la publicacion: ");
            int codigoPublicacion = sc.nextInt();
            sc.nextLine();

            System.out.println("\n===== PUBLICACION =====");
            System.out.println(controladora.obtenerPublicacion(codigoBlog, codigoPublicacion));

            menuComentarios(codigoBlog, codigoPublicacion);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuComentarios(int codigoBlog, int codigoPublicacion) {
        int opcion = 0;

        do {
            System.out.println("\n===== MENU COMENTARIOS =====");
            System.out.println("1. Agregar comentario");
            System.out.println("2. Borrar comentario");
            System.out.println("3. Regresar");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarComentario(codigoBlog, codigoPublicacion);
                    break;

                case 2:
                    borrarComentario(codigoBlog, codigoPublicacion);
                    break;

                case 3:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 3);
    }

    public static void agregarComentario(int codigoBlog, int codigoPublicacion) {
        try {
            System.out.print("Digite el email: ");
            String email = sc.nextLine();

            System.out.print("Digite la IP: ");
            String ip = sc.nextLine();

            System.out.print("Digite el comentario: ");
            String texto = sc.nextLine();

            controladora.agregarComentario(codigoBlog, codigoPublicacion, email, ip, texto);

            System.out.println("Comentario agregado correctamente.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void borrarComentario(int codigoBlog, int codigoPublicacion) {
        try {
            System.out.print("Digite la posicion del comentario: ");
            int posicion = sc.nextInt();
            sc.nextLine();

            controladora.borrarComentario(codigoBlog, codigoPublicacion, posicion);

            System.out.println("Comentario borrado correctamente.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}