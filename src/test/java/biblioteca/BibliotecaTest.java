package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Biblioteca biblioteca;
    Libro libro1;
    Libro libro2;
    Libro libro3;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        libro1 = new Libro("C");
        libro2 = new Libro("B");
        libro3 = new Libro("A");
    }

    @Test
    void bibliotecaSinLibros() {
        List<Libro> librosDeLaBiblioteca = biblioteca.libros();
        assertTrue(librosDeLaBiblioteca.isEmpty());
    }

    @Test
    void seAgregaron2Libros() {
        biblioteca.agregarLibros(libro1, libro2);
        List<Libro> libros = biblioteca.libros();
        assertEquals(libros.size(), 2);
    }

    @Test
    void seAgregaronSolo2Libros() {
        biblioteca.agregarLibros(libro1,libro2);
        List<Libro> libros = biblioteca.libros();
        try {
            libros.add(libro3);
            fail("Deberia no sere posible agregar libros a la biblioteca.");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException,"Deberia lanzar la excepcion de operacion no soportada.");
        }
    }

    @Disabled
    @Test
    void ordenar() {
        biblioteca.ordenar();
    }

    @Disabled
    @Test
    void ordenarConCriterio() {
        biblioteca.ordenarConCriterio(new Criterio());
    }
}