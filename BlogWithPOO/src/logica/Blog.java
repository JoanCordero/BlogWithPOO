package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Blog {

    private static int contCodigo = 1;

    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private List<Publicacion> publicaciones;

    public Blog(String nom, String desc) {
        this.codigo = contCodigo++;
        this.nombre = nom;
        this.descripcion = desc;
        this.fechaCreacion = LocalDateTime.now();
        this.publicaciones = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void agregarPublicacion(String titulo, String texto, String creador) {
        publicaciones.add(new Publicacion(titulo, texto, creador));
    }

    public void eliminarPublicacion(int codPub) {
        Publicacion pub = buscarPublicacion(codPub);
        if (pub != null) {
            publicaciones.remove(pub);
        } else {
            System.out.println("No existe una publicación con ese código.");
        }
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public Map<Integer, String> listarTitulos() {
        Map<Integer, String> titulos = new TreeMap<>();

        for (Publicacion pub : publicaciones) {
            titulos.put(pub.getCodigo(), pub.getTitulo());
        }

        return titulos;
    }

    public String getPublicacionString(int codPub) {
        Publicacion pub = buscarPublicacion(codPub);
        if (pub != null) {
            return pub.toString();
        }
        return "No existe una publicación con ese código.";
    }

    public void agregarComentario(int codPub, String email, String ip, String txt) {
        Publicacion pub = buscarPublicacion(codPub);
        if (pub != null) {
            pub.agregarComentario(email, ip, txt);
        } else {
            System.out.println("No existe una publicación con ese código.");
        }
    }

    public void eliminarComentario(int codPub, int posicion) {
        Publicacion pub = buscarPublicacion(codPub);
        if (pub != null) {
            pub.eliminarComentario(posicion);
        } else {
            System.out.println("No existe una publicación con ese código.");
        }
    }

    private Publicacion buscarPublicacion(int codPub) {
        for (Publicacion pub : publicaciones) {
            if (pub.getCodigo() == codPub) {
                return pub;
            }
        }
        return null;
    }
}