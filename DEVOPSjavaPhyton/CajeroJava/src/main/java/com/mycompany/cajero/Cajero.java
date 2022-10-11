
package com.mycompany.cajero;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vicher
 */
public class Cajero {

    
    
    public static void main(String[] args) {
        
       menu();
    }
    
    
    
    
    //valores
    static double monto=1000;
    static double cantidad=0;
    static String historial="";
    
    
    static String fecha(){
         DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return fecha.format(LocalDateTime.now());
    }
    
    //contraseña
    static void contrasenna(){        
        int contador =1;
        while (contador <= 3) {            
            try {
                int x= Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu pin"));
                if(x == 1235){
                    //JOptionPane.showMessageDialog(null, "Pin correcto");
                    break;
                }else if( contador == 3){
                        System.exit(0);
                }else{
                    JOptionPane.showMessageDialog(null, "Pin incorrecto, te restan :"+ (3-contador) + " intentos mäs");
                    contador ++;                    
                }

            } catch (HeadlessException | NumberFormatException w) {
                JOptionPane.showMessageDialog(null, "Pin incorrecto, te restan :"+ (3-contador) + " intentos mäs");
                    contador ++;   
                System.err.println(" "+w);
                

            } 
        }
    }
    
    //menu
    static void menu(){
        contrasenna();
            int opcion=0;
            while (true) { 
                try {
                   opcion = Integer.parseInt(JOptionPane.showInputDialog(" Bienvenido al cajero automatico\n" +
                    "\n" + "******Menú******\n" +
                    " 1-  Depositar\n" +
                    " 2- Retirar\n" +
                    " 3- Consultar saldo\n" +
                    " 4- Historial \n"+
                    " 5- Salir ")); 
                } catch (Exception e) {
                    System.err.print(e);
                }
                
                switch (opcion) {
                    case 1:
                        Depositar();
                        break;
                    case 2:
                        Retirar();
                        break;
                    case 3:
                        Ver();
                        break;
                    case 4:
                        Historial();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:JOptionPane.showMessageDialog(null, "Opcion invalida vuelve a intentar");
                        //throw new AssertionError();
                }
            }
       }
    
    
    //Metodos
    static void Depositar(){
        try {
            cantidad=Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a ingresar"));
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
            //JOptionPane.showMessageDialog(null,"Usted deposito: $"+ cantidad );
            historial+= " "+fecha()+ " ingreso $"+ cantidad +" M/N\n";
            monto+=cantidad;
           // JOptionPane.showMessageDialog(null,"y su saldo es de: "+ monto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Valores invalidos");
            System.err.println("Texto invalido "+e);
        }  
    }
    
    static void Retirar(){
        try {
            cantidad=Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar"));
            //JOptionPane.showMessageDialog(null,"Usted retiro: $"+ cantidad +"\n");
            if(monto >= cantidad){
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
                historial+= " "+fecha()+ " retiro $"+ cantidad +" M/N\n";
                monto-=cantidad;
                //JOptionPane.showMessageDialog(null,"y su saldo es de: "+ monto);
            }else{
                JOptionPane.showMessageDialog(null, "Fondos insuficientes");
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null,"Valores invalidos");
            System.err.println("Texto invalido "+a);
        }  
    }
     
     static void Ver(){
        JOptionPane.showMessageDialog(null, "Tu saldo es de: $"+monto);
    }
    static void Historial(){
        if (historial != ""){
            JOptionPane.showMessageDialog(null, "El historial es :\n"+ historial);
        }else{
            JOptionPane.showMessageDialog(null, "No hay registros");
        }
        
        
    }
    
}
