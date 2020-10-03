import javax.swing.*;

public class Lista {



        Nodito cab;


        public Lista(){ cab=null; }


        public int getLonglista(){
            int cont=0;
            Nodito p=cab;
            if(cab==null)
                return 0;
            else{
                while(p!=null){
                    cont++;
                    p=p.sig;
                }
                return cont;
            }
        }

        public Nodito getObtenerNombre(String nombreEstudiante){
        Nodito buscar=null;
        if(cab==null)
            return null;
        else{
            buscar=cab;
            while(buscar!=null){
                if( buscar.nombreEstudiante.equals(nombreEstudiante) )
                    return buscar;
                buscar = buscar.sig;
            }
            return null;
        }
    }

        public Nodito getObtenerId(int idEstudiante){
            Nodito buscar=null;
            if(cab==null)
                return null;
            else{
                buscar=cab;
                while(buscar!=null){
                    if( buscar.idEstudiante == idEstudiante )
                        return buscar;
                    buscar = buscar.sig;
                }
                return null;
            }
        }



        public Nodito getCrearNodo(){

            int idEstudiante;
            String nombreEstudiante;
            String sexoEstudiante;
            int edadestudiante;
            int gradoEstudiante;
            String nombredelAcudiente;
            int numeroTelefonico;
            int contadorNiñas = 0;

            Nodito ana =null;
            do{
                idEstudiante=Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre id estudiante: "));

                ana=getObtenerId(idEstudiante);

                edadestudiante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad el estudiante (mayor que 6)"));

                if(ana!=null && edadestudiante < 6)

                    JOptionPane.showMessageDialog(null,
                            "El código ya existe en la lista, intente nuevamente!");

                JOptionPane.showMessageDialog(null,
                        "Edad debe ser mayor que 6");



            }while(ana!=null && edadestudiante < 6);

            nombreEstudiante = JOptionPane.showInputDialog("Entre nombre del estudiante: ");

            sexoEstudiante = JOptionPane.showInputDialog("Entre sexo del estudiante (M o F): ");

            gradoEstudiante =Integer.parseInt(JOptionPane.showInputDialog("Entre grado a cursar estudiante: "));

            nombredelAcudiente = JOptionPane.showInputDialog("Entre nombre del acudiente estudiante: ");

            numeroTelefonico = Integer.parseInt(JOptionPane.showInputDialog("Entre numero de acuendite estudiante: "));

            if (gradoEstudiante == 5 && sexoEstudiante.equals("F")) {
                contadorNiñas++;
            }

            Nodito info = new Nodito( idEstudiante,  nombreEstudiante,
             edadestudiante,  sexoEstudiante,
             gradoEstudiante,  nombredelAcudiente,
             numeroTelefonico ,  contadorNiñas);
            return info;

        }

    public void setAñadirFinal(){

        Nodito info=getCrearNodo();

        Nodito p=null;
        if(cab==null){
            cab=info;
            JOptionPane.showMessageDialog(null,
                    "Estudiante agregado, la lista estaba vacía!");
        }else{
            p=cab;
            while(p.sig!=null)
                p=p.sig;
            p.sig=info;
            JOptionPane.showMessageDialog(null,
                    "Estudiante agregado al final de la lista!");
        }
    }

        public void setAñadirCabeza(){
            Nodito info = getCrearNodo();
            if(cab==null){
                cab=info;
                JOptionPane.showMessageDialog(null,
                        "Estudiante agregado, la lista estaba vacía!");
            }else{
                info.sig = cab;
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Estudiante agregado al incio de la lista!");
            }
        }



        public boolean getEsVacia(){
            return cab==null?true:false;
        }

        public void mostrar(){
            Nodito p=null;
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else{
                p=cab;
                while(p!=null){
                    p.verAcudiente();
                    p=p.sig;
                }
                JOptionPane.showMessageDialog(null,
                        "Se mostraron todos los elementos de la lista, "
                                + "la lista tiene: "+getLonglista()+" elementos.");
            }
        }

        public void obtenerId(int idEstudiante) {

            if (cab == null)
                JOptionPane.showMessageDialog(null,
                        "La lista esta vacía!!!");
            else {
                Nodito p = getObtenerId(idEstudiante);
                if (p == null)
                    JOptionPane.showMessageDialog(null,
                            "El elemento consultado no existe!!");
                else
                    p.verNodito();
            }
        }


            public void obtenerNom(String nombreEstudiante) {
                if (cab == null)
                    JOptionPane.showMessageDialog(null,
                            "La lista esta vacía!!!");
                else {
                    Nodito p = getObtenerNombre(nombreEstudiante);
                    if (p == null)
                        JOptionPane.showMessageDialog(null,
                                "El elemento consultado no existe!!");
                    else
                        p.verAcudiente();
                }
            }

        //Este método retonar un nodo apuntando detrás de p.
        public Nodito getBack(Nodito p){
            Nodito q=cab;
            while(q.sig!=p)
                q=q.sig;
            return q;
        }

        public void setEliminNodo(int idEstudiante){
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista esta vacía!");
            else{
                Nodito q=null;
                Nodito p=getObtenerId(idEstudiante);
                if(p==null)
                    JOptionPane.showMessageDialog(null,
                            "El elemento no existe!!");
                else{
                    if((p==cab)&&(cab.sig==null)){
                        cab=null;
                        JOptionPane.showMessageDialog(null,
                                "Se eliminó el único elemento de la lista,"
                                        + " la lista esta vacía!!");
                    }
                    else if((cab.sig!=null)&&(p==cab)){
                        cab=cab.sig;
                        p.sig=null;
                        p=null;
                        JOptionPane.showMessageDialog(null,
                                "Elemento eliminado al inicio de la lista!!");
                    }
                    else if(p.sig==null){
                        q=getBack(p);
                        q.sig=null;
                        p=null;
                        JOptionPane.showMessageDialog(null,
                                "Elemento eliminado al final de la lista!!");
                    }else{
                        q=getBack(p);
                        q.sig=p.sig;
                        p.sig=null;
                        p=null;
                        JOptionPane.showMessageDialog(null,
                                "Elemento eliminado entre dos nodos!!");
                    }
                }
            }
        }

        public float getSumaEdades5(){
            float sum;
            Nodito q;
            if(getEsVacia())
                return 0;
            else{
                sum=0;
                q=cab;
                while(q!=null){
                    if (q.gradoEstudiante == 5 && q.sexoEstudiante.equals("F")) {
                        sum += q.edadestudiante;
                    }
                    q=q.sig;
                }
                return sum;
            }
        }

        public float getPromedioEdades5(){
            if(cab==null)
                return 0;
            else{
                float tam=(float) getLonglista();
                return getSumaEdades5()/tam;
            }
        }

        public void setMPrimero( ){
            Nodito temp=null;
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "Lista vacía!!!");
            else{
                Nodito p,q;
                p=cab;
                while(p!=null){
                    q=cab;
                    while(q.sig!=null){
                        if(q.gradoEstudiante == 1 && q.edadestudiante < q.sig.edadestudiante){
                            temp=new Nodito(
                                    q.idEstudiante,
                                    q.nombreEstudiante,
                                    q.edadestudiante,
                                    q.sexoEstudiante,
                                    q.gradoEstudiante,
                                    q.nombredelacudiente,
                                    q.numeroTelefonico,
                                    q.contadorNiñas
                            );


                            q.idEstudiante = q.sig.idEstudiante;
                            q.nombreEstudiante = q.sig.nombreEstudiante;
                            q.edadestudiante = q.sig.edadestudiante;
                            q.sexoEstudiante = q.sig.sexoEstudiante;
                            q.gradoEstudiante = q.sig.gradoEstudiante;
                            q.nombredelacudiente = q.sig.nombredelacudiente;
                            q.numeroTelefonico = q.sig.numeroTelefonico;
                            q.contadorNiñas = q.sig.contadorNiñas;


                            q.sig.idEstudiante = temp.idEstudiante;
                            q.sig.nombreEstudiante = temp.nombreEstudiante;
                            q.sig.edadestudiante = temp.edadestudiante;
                            q.sig.sexoEstudiante = temp.sexoEstudiante;
                            q.sig.gradoEstudiante = temp.gradoEstudiante;
                            q.sig.nombredelacudiente = temp.nombredelacudiente;
                            q.sig.numeroTelefonico = temp.numeroTelefonico;
                            q.sig.contadorNiñas = temp.contadorNiñas;
                        }
                        q=q.sig;
                    }
                    p=p.sig;

                }
            }
        }



        public void setMquinto( ){
            Nodito temp=null;
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "Lista vacía!!!");
            else{
                Nodito p,q;
                p=cab;
                while(p!=null){
                    q=cab;
                    while(q.sig!=null){
                        if(q.gradoEstudiante == 5 && q.edadestudiante < q.sig.edadestudiante){
                            temp=new Nodito(
                                    q.idEstudiante,
                                    q.nombreEstudiante,
                                    q.edadestudiante,
                                    q.sexoEstudiante,
                                    q.gradoEstudiante,
                                    q.nombredelacudiente,
                                    q.numeroTelefonico,
                                    q.contadorNiñas
                            );



                            q.idEstudiante = q.sig.idEstudiante;
                            q.nombreEstudiante = q.sig.nombreEstudiante;
                            q.edadestudiante = q.sig.edadestudiante;
                            q.sexoEstudiante = q.sig.sexoEstudiante;
                            q.gradoEstudiante = q.sig.gradoEstudiante;
                            q.nombredelacudiente = q.sig.nombredelacudiente;
                            q.numeroTelefonico = q.sig.numeroTelefonico;
                            q.contadorNiñas = q.sig.contadorNiñas;


                            q.sig.idEstudiante = temp.idEstudiante;
                            q.sig.nombreEstudiante = temp.nombreEstudiante;
                            q.sig.edadestudiante = temp.edadestudiante;
                            q.sig.sexoEstudiante = temp.sexoEstudiante;
                            q.sig.gradoEstudiante = temp.gradoEstudiante;
                            q.sig.nombredelacudiente = temp.nombredelacudiente;
                            q.sig.numeroTelefonico = temp.numeroTelefonico;
                            q.sig.contadorNiñas = temp.contadorNiñas;
                        }
                        q=q.sig;
                    }
                    p=p.sig;

                }
            }
        }
        public void mostrarGrados() {

            Nodito p=null;
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else{
                p=cab;
                while(p!=null){
                    if (p.gradoEstudiante == 1)
                        p.verGrados();
                    p=p.sig;
                }

            }
        }

        public void mostrarGrado5(){
            Nodito p=null;
            if(getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else{
                p=cab;
                while(p!=null){
                    if (p.gradoEstudiante == 5)
                        p.verGrados();
                    p=p.sig;
                }

            }
        }

        public void niños1 () {

            Nodito p = null;
            if (getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else {
                p = cab;
                while (p != null) {
                    String info = "La información del Acudiente  es: \n";
                    if (p.sexoEstudiante.equals("M") && p.gradoEstudiante == 1)
                        info += "Id: " + p.idEstudiante + "\n";
                    info += "Nombre: " + p.nombreEstudiante + "\n";
                    info += "Edad: " + p.edadestudiante + "\n";
                    info += "sexo: " + p.sexoEstudiante + "\n";

                    JOptionPane.showMessageDialog(null, info);
                    p = p.sig;
                }

            }


        }
        public void niñas1 () {

            Nodito p = null;
            if (getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else {
                p = cab;
                while (p != null) {
                    String info = "La información del Acudiente  es: \n";
                    if (p.sexoEstudiante.equals("F") && p.gradoEstudiante == 1)
                        info += "Id: " + p.idEstudiante + "\n";
                    info += "Nombre: " + p.nombreEstudiante + "\n";
                    info += "Edad: " + p.edadestudiante + "\n";
                    info += "sexo: " + p.sexoEstudiante + "\n";

                    JOptionPane.showMessageDialog(null, info);
                    p = p.sig;
                }

            }


        }

        public void niñas5 () {

            Nodito p = null;
            if (getEsVacia())
                JOptionPane.showMessageDialog(null,
                        "La lista no tiene elementos!");
            else {
                p = cab;
                while (p != null) {
                    String info = "La información del Acudiente  es: \n";
                    if (p.sexoEstudiante.equals("F") && p.gradoEstudiante == 5)
                        info += "Id: " + p.idEstudiante + "\n";
                    info += "Nombre: " + p.nombreEstudiante + "\n";
                    info += "Edad: " + p.edadestudiante + "\n";
                    info += "sexo: " + p.sexoEstudiante + "\n";
                    info += "Cantidad: " + p.contadorNiñas + "\n";
                    info += "Promedio edad: " + getPromedioEdades5()+ "\n";

                    JOptionPane.showMessageDialog(null, info);
                    p = p.sig;
                }

            }


        }
}
