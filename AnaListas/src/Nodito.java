import javax.swing.*;

public class Nodito {

    public int idEstudiante;
    public String nombreEstudiante;
    public int edadestudiante;
    public String sexoEstudiante;
    public int gradoEstudiante;
    public String nombredelacudiente;
    public int numeroTelefonico;
    public int contadorNiñas;


    //Apuntador
    Nodito sig;

    public Nodito(int idEstudiante, String nombreEstudiante,
                  int edadestudiante, String sexoEstudiante,
                  int gradoEstudiante, String nombredelacudiente,
                  int numeroTelefonico , int contadorNiñas) {

        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.edadestudiante = edadestudiante;
        this.sexoEstudiante = sexoEstudiante;
        this.gradoEstudiante = gradoEstudiante;
        this.nombredelacudiente = nombredelacudiente;
        this.numeroTelefonico = numeroTelefonico;
        this.contadorNiñas = contadorNiñas;

    }

    public void verGrados(){
        String info="La información del Acudiente  es: \n";

        info += "Nombre del estudiante: "+nombreEstudiante+"\n";
        info += "sexo del estudiante: "+sexoEstudiante+"\n";

        JOptionPane.showMessageDialog(null, info);
    }
    public void verAcudiente(){
        String info="La información del Acudiente  es: \n";

        info += "Nombre del acudiente: "+nombredelacudiente+"\n";
        info += "Numero del acudiente: "+numeroTelefonico+"\n";

        JOptionPane.showMessageDialog(null, info);
    }
    public void verNodito(){
        String info="La informacion de los estudiantes es: \n";
        info += "Id estudiante: "+idEstudiante+"\n";
        info += "Nombre estudiante: "+nombreEstudiante+"\n";
        info += "Sexo estudiante: "+sexoEstudiante+"\n";
        info += "Edad del estudiante: "+edadestudiante+"\n";

        JOptionPane.showMessageDialog(null, info);
    }





}
