package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Una biblioteca")
@ExtendWith(LibroResuelveParametro.class)
class BibliotecaTest {

    Biblioteca biblioteca;
    Libro effectiveJava;
    Libro codeComplete;
    Libro mythicalManMonth;
    Libro cleanCode;

    @BeforeEach
    void setUp(Map<String, Libro> libros) {

        biblioteca = new Biblioteca();
        effectiveJava = libros.get("Effective Java");
        codeComplete = libros.get("Code Complete");
        mythicalManMonth = libros.get("The Mythical Man-Month");
        cleanCode = libros.get("Clean Code");
    }

    @Test
    void bibliotecaSinLibros() {
        List<Libro> librosDeLaBiblioteca = biblioteca.libros();
        assertTrue(librosDeLaBiblioteca.isEmpty());
    }

    @Test
    void seAgregaron2Libros() {
        biblioteca.agregarLibros(effectiveJava, cleanCode);
        List<Libro> libros = biblioteca.libros();
        assertEquals(libros.size(), 2);
    }

    @Test
    void seAgregaronSolo2Libros() {
        biblioteca.agregarLibros(effectiveJava, cleanCode);
        List<Libro> libros = biblioteca.libros();
        try {
            libros.add(codeComplete);
            fail("Deberia no sere posible agregar libros a la biblioteca.");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException,"Deberia lanzar la excepcion de operacion no soportada.");
        }
    }

    @DisplayName("Es ordenado de manera lexicografica.")
    @Test
    void ordenarConCriterio() {
        biblioteca.agregarLibros(effectiveJava,codeComplete,cleanCode,mythicalManMonth);
        Comparator<Libro> comparador =(Comparator<Libro>) Comparator.naturalOrder().reversed();
        List<Libro> libros = biblioteca.ordenarConCriterio(comparador);
        assertThat(libros).isSortedAccordingTo(comparador);
    }

    @Test
    void agrupaciones() {
        biblioteca.agregarLibros(effectiveJava,codeComplete,cleanCode,mythicalManMonth);
        Map<String, List<Libro>> mapa = biblioteca.agrupadoPor(Libro::getAutor);
        assertThat(mapa).containsKeys(effectiveJava.getAutor()).containsValues(singletonList(effectiveJava));
    }

    @Test
    void progresoDeLectura() {
        biblioteca.agregarLibros(effectiveJava,codeComplete,cleanCode,mythicalManMonth);
        Progreso progreso = biblioteca.progreso();
        assertThat(progreso.completo()).isEqualTo(0);
        assertThat(progreso.sinEmpezar()).isEqualTo(100);
    }

    @Test
    void progresoDeLecturaConLibrosLeidos() {
        biblioteca.agregarLibros(effectiveJava,codeComplete,cleanCode,mythicalManMonth);
        
    }
}