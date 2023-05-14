/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
class Impresion implements interfazImpresion{

    public Impresion(String datosPedido) {
        
         this.imprimirTicket(datosPedido);
        
    }//Constructor
    
    public interface interfazImpresion {
    // Cuerpo de la interfaz ...
        
    } 
    
    @Override
    public void imprimirTicket(String datosPedido){
        JOptionPane.showMessageDialog(null,datosPedido,"INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
}
