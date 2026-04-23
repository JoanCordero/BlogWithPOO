package logica;

import java.time.LocalDateTime;

public class Comentario {

    private LocalDateTime fechaCreacion;
    private String emailAutor;
    private String ip;
    private String texto;

    public Comentario(String email, String ip, String txt) {
        this.fechaCreacion = LocalDateTime.now();
        this.emailAutor = email;
        this.ip = ip;
        this.texto = txt;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public void setEmailAutor(String emailAutor) {
        this.emailAutor = emailAutor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "fechaCreacion=" + fechaCreacion +
                ", emailAutor='" + emailAutor + '\'' +
                ", ip='" + ip + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}