import javax.swing.*;
import java.net.Inet4Address;

public class Menu {

    public static void main(String args[]){
        int op, idEstudiante;
        String nombreEstudiante;
        Lista miListArticulos = new Lista();
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú principal \n"+
                            "1. Añadir al inicio. \n"+
                            "2. Añadir al final. \n"+
                            "3. Buscar por nombre. \n"+
                            "4. Buscar por código. \n"+
                            "5. Eliminar por código. \n"+
                            "6. Mayores en edad. \n"+
                            "7. Niñas de quinto.\n"+
                            "8. Reporte niños de primero y quinto.\n"+
                            "9. Salir. \n"+
                            "Entre su opción: ?"
            ));

            switch(op){
                case 1:
                    miListArticulos.setAñadirCabeza();
                    break;
                case 2:
                    miListArticulos.setAñadirFinal();
                    break;
                case 3:
                    nombreEstudiante =JOptionPane.showInputDialog(
                            "Entre el nombre a buscar: ");
                    miListArticulos.getObtenerNombre(nombreEstudiante);
                    break;
                case 4:
                    idEstudiante=Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el id a buscar: "));
                    miListArticulos.getObtenerId(idEstudiante);
                    break;
                case 5:
                    idEstudiante = Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el id a eliminar : "));
                    miListArticulos.setEliminNodo(idEstudiante);
                    break;
                case 6:
                    miListArticulos.setMPrimero();
                    miListArticulos.mostrarGrados();
                    miListArticulos.setMquinto();
                    miListArticulos.mostrarGrado5();
                    break;
                case 7:
                    miListArticulos.niñas5();
                    break;
                case 8:
                    miListArticulos.niñas1();
                    miListArticulos.niños1();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adios!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción invalida!!!");
            }
        }while(op!=9);
        System.exit(0);
    }
}
