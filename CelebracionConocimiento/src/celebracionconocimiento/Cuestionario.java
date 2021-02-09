package celebracionconocimiento;

public class Cuestionario {
    String pregunta;
    String respuesta1;
    String respuesta2;
    String respuesta3;
    String respuesta4;
    int correcta;
    public Cuestionario(String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int correcta)
    {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.correcta = correcta;
    }
}
