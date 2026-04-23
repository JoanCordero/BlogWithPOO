package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {

    private static int contCodigo = 1;

    private int codigo;
    private String titulo;
    private String texto;
    private String creador;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String tit, String txt, String cre) {
        this.codigo = contCodigo++;
        this.titulo = tit;
        this.texto = txt;
        this.creador = cre;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getCreador() {
        return creador;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void agregarComentario(String email, String ip, String txt) {
        comentarios.add(new Comentario(email, ip, txt));
    }

    public void eliminarComentario(int posicion) {
        if (posicion >= 0 && posicion < comentarios.size()) {
            comentarios.remove(posicion);
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado += "Codigo: " + codigo + "\n";
        resultado += "Titulo: " + titulo + "\n";
        resultado += "Texto: " + texto + "\n";
        resultado += "Creador: " + creador + "\n";
        resultado += "Fecha de publicacion: " + fechaPublicacion + "\n";
        resultado += "Comentarios:\n";

        if (comentarios.isEmpty()) {
            resultado += "No hay comentarios.\n";
        } else {
            for (int i = 0; i < comentarios.size(); i++) {
                resultado += i + ". " + comentarios.get(i).toString() + "\n";
            }
        }

        return resultado;
    }
}