package biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {


    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public List<Libro> libros() {
        return Collections.unmodifiableList(libros);
    }

    public void agregarLibros(Libro ... librosParaAgregar) {
        libros.addAll(Arrays.asList(librosParaAgregar));
    }

    public List<Libro> ordenar() {
        return null;
    }

    public List<Libro> ordenarConCriterio(Comparator<Libro> criterio) {
        return libros.stream().sorted(criterio).collect(Collectors.toList());
    }
}
