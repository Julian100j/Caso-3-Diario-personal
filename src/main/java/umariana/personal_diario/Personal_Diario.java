/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.personal_diario;

import Mundo.Entrada;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Julian Ceballos y Santiago Luna
 */
public class Personal_Diario {

    
        
         private ArrayList<Entrada> misEntradas;
         private Scanner lector;

    public Personal_Diario() {
        
        //Se crea un ArrayList y un escaner
        misEntradas = new ArrayList<>();
        lector = new Scanner(System.in);
    }
    
    int nuevoIdEntrada;
     public void mostrarMenu() {
         //Muestra un menú de opciones al usuario y permite que éste seleccione una opción.
        //Dependiendo de la opción seleccionada, se llama a otro método para realizar la acción correspondiente.
        
        boolean activo = true;

            do {
                //Se muestra el menu de opciones
                
                System.out.println("========= INVENTARIO ===========");
                System.out.println("1. Agregar Entrada");
                System.out.println("2. Mostrar Entrada");
                System.out.println("3. eliminar Entrada");
                System.out.println("4. modificar Entrada");
                System.out.println("5. Salir");
                System.out.println("------------------------------------------------");

                int opcion = lector.nextInt();
                switch (opcion) {

                    case 1:
                        //se llama al metodo agregarEntrada()
                        
                        agregarEntrada();
                                                       
                        break;
                    case 2:
                        //se llama al metodo mostrarEntrada()
                        
                        mostrarEntrada();
                        break;
                    case 3:
                        //se llama al metodo eliminarEntrada()
                        
                        eliminarEntrada();
                        break;
                    case 4:
                        //se llama al metodo modificarEntrada()
                        
                       modificarEntrada();
                        break;
                    case 5:
                        //al elegir esta opcion se sale del programa
                        
                          activo = false;
                        System.out.println("Saliste del programa");
                        break;
                    default:
                        System.out.println("Opción no válida, inténtelo nuevamente");
                }
            } while (activo);
    }
    
    public void agregarEntrada(){
    //Permite añadir una nueva entrada
    
                        // capturar la fecha del sistema
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
                        String fecha = formato.format (new Date());
                        if(misEntradas.isEmpty())
                        {
                           nuevoIdEntrada=1;
                        } else {
                        // Obtener el ultimo IdEntrada ingresado y sumarle uno
                            int tamanoLista = misEntradas.size(); 
                            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
                            nuevoIdEntrada = ultimaEntrada.getIdEntrada()+ 1;
                        }
                        // solicitar la entrada de la descripción al usuario
                        System.out.println("Ingrese la descripcion de la entrada ");
                        lector.nextLine(); //evitar que se salte el ingreso de la descripción
                        
                        String descripcion = lector.nextLine();
                        // Crear el objeto para insertar los datos obtenidos
                        Entrada miEntrada = new Entrada(nuevoIdEntrada, fecha, descripcion);
                        // Agregar el objeto a la contenedora variable
                        misEntradas.add(miEntrada);
    
}
    public void mostrarEntrada(){
        //Permite mostrar todas las entradas existentes en el sistema
        
        for(Entrada e: misEntradas)
                        {  
                            
                            System.out.println("========= Tareas Registradas ===========");
                            System.out.println("Id: "+e.getIdEntrada());
                            System.out.println("fecha: "+e.getFecha());
                            System.out.println("descripción: "+e.getDescripcion());
                            System.out.println("----------------------------------");
                        }
        
    }
    
    public void eliminarEntrada(){
        //Permite eliminar del sistema una entrada
        
        System.out.println("digite el identrada que desea eliminar");
                        int id = lector.nextInt();
                        // iterador para buscar en el arraylist
                        Iterator<Entrada> ite = misEntradas.iterator();
                        while(ite.hasNext())
                        {
                           Entrada i =(Entrada) ite.next();
                           if(i.getIdEntrada()==id)
                               ite.remove();                 
                        }
                        System.out.println("Entrada eliminada con exito!");
        
    }
    
    public void modificarEntrada(){
        //Permite modificar la descripcion de la entrada
         System.out.println("Ingrese el id de la entrada que desea modificar");
                        int id2 = lector.nextInt();
                        
                        System.out.println("Ingrese una nueva descripcion para la entrada");
                        lector.nextLine();
                        String nuevaDescripcion = lector.nextLine();
                        
                        Iterator<Entrada> it2 = misEntradas.iterator();
                        while(it2.hasNext())
                        {
                           Entrada e =(Entrada) it2.next();
                           if(e.getIdEntrada()==id2)
                               e.setDescripcion(nuevaDescripcion);
                        }
                        System.out.println("Entrada modificada con exito!");
                        
    }
   
     public static void main(String[] args) {
       //En el método main, se crea un objeto  y se llama al método mostrarMenu() para mostrar el menú de opciones al usuario.
       
        Personal_Diario organizador = new Personal_Diario();
        organizador.mostrarMenu();
    }
    
}