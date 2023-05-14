/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPedidos;

import javax.swing.JOptionPane;
import java.util.regex.*;

/**
 *
 * 
 */
public class MisExcepciones extends Exception {

    private int codigoError;
    String mensaje;

    public MisExcepciones(int codigoError) {
        super();
        this.codigoError = codigoError;
    }

    @Override
    public String getMessage() {

        String mensaje = "";
        
        //Se muestra el texto asociado a cada codigo de error

        switch (codigoError) {

            case 1:
                mensaje = "Algun campo obligatorio de Nuevo Cliente no se ha informado. Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;

            case 2:
                mensaje = "El telefono informado no es correcto (8 digitos empezando por 9,6 o 7).Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;

            case 3:
                mensaje = "Algun campo obligatorio de Nuevo Producto no se ha informado. Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
            case 4:
                mensaje = "El formato del campo Calorias no es correcto (solo números). Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
            case 5:
                mensaje = "El precio no puede ser negativo o cero.Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
             case 6:
                mensaje = "Algun campo obligatorio de Nuevo Producto no se ha informado. Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
             case 7:
                mensaje = "El formato del campo Medida no es correcto (solo números). Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
               case 8:
                mensaje = "No se ha seleccionado ningun cliente. Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;                
               case 9:
                mensaje = "No se ha seleccionado ningun producto (comida/bebida). Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
               case 10:
                mensaje = "Importe a ingresar no puede menor que importe a pagar. Revise el formulario por favor.";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
                case 11:
                mensaje = "Se han introducido valores no validos en el número de cuenta.Vuelva a introducirla , por favor";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
                case 12:
                mensaje = "Longitud de numero de cuenta incorrecta. Vuelva a introducirla , por favor";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
                case 13:
                mensaje = "Longitud de numero de tarjeta incorrecta. Vuelva a introducirla , por favor";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
                case 14:
                mensaje = "Se han introducido valores no validos en el número de tarjeta. Vuelva a introducirla , por favor";
                JOptionPane.showMessageDialog(null, mensaje);
                break;

        }

        return mensaje;

    }

}
