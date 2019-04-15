package biblioteca;

public class Progreso {

    private final int completo;
    private final int sin_empezar;
    private final int en_progreso;

    public Progreso(int completo, int sin_empezar, int en_progreso) {
        this.completo = completo;
        this.sin_empezar = sin_empezar;
        this.en_progreso = en_progreso;
    }

    public int completo() {
        return completo;
    }

    public int sinEmpezar() {
        return sin_empezar;
    }

    public int enProgreso(){
        return this.en_progreso;
    }
}
