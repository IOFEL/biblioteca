package biblioteca;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.Parameter;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.LocalDate.of;

public class LibroResuelveParametro implements ParameterResolver {

    private final Map<String,Libro> libros;

    public LibroResuelveParametro() {
        libros = new HashMap<>();
        libros.put("Effective Java",new Libro("Effective Java", "Joshua Bloch",
                of(2008, Month.MAY, 8)));
        libros.put("Code Complete",new Libro("Code Complete", "Steve McConnel",
                of(2004, Month.JUNE, 9)));
        libros.put("The Mythical Man-Month",new Libro("The Mythical Man-Month", "Frederick Phillips Brooks",
                of(1975, Month.JANUARY, 1)));
        libros.put("Clean Code",new Libro("Clean Code", "Robert C. Martin",
                of(2008, Month.AUGUST, 1)));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Parameter parametro = parameterContext.getParameter();
        return Objects.equals(parametro.getParameterizedType().getTypeName(),"java.util.Map<java.lang.String, biblioteca.Libro>");
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return libros;
    }
}
