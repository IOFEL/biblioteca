package biblioteca;

import java.time.LocalDate;

public class Libro implements Comparable<Libro>{

    private String titulo;
    private String autor;
    private LocalDate fechaDePublicacion;

    public Libro(String titulo, String autor, LocalDate fechaDePublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public Libro(String title) {
        this.titulo = title;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                '}';
    }

    @Override
    public int compareTo(Libro libro) {
        return this.titulo.compareTo(libro.titulo);
    }
}
