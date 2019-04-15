package biblioteca;

import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        return ordenarConCriterio(Comparator.naturalOrder());
    }

    public List<Libro> ordenarConCriterio(Comparator<Libro> criterio) {
        return libros.stream().sorted(criterio).collect(Collectors.toList());
    }

    public Map<Year, List<Libro>> agrupadoPorAnio(){
        Function<Libro,Year> anio = libro -> Year.of(libro.getFechaDePublicacion().getYear());
        return agrupadoPor(anio);
    }

    public <K> Map<K,List<Libro>> agrupadoPor(Function<Libro,K> f){
        return libros.stream().collect(groupingBy(f));
    }

    public Progreso progreso() {
        return new Progreso(0,100,0);
    }
}
