package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Progreso")
@ExtendWith(LibroResuelveParametro.class)
class ProgresoTest {

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
    void noSeAun() {

    }
}