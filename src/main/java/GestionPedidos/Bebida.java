/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Bebida extends DatosProductos{
   
    String medida;
    String gaseoso;
    String lacteo;
    String fechaEnvase;
    String fechaCaducidad;
    String oferta;
    String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getGaseoso() {
        return gaseoso;
    }

    public void setGaseoso(String gaseoso) {
        this.gaseoso = gaseoso;
    }

    public String getLacteo() {
        return lacteo;
    }

    public void setLacteo(String lacteo) {
        this.lacteo = lacteo;
    }

    public String getFechaEnvase() {
        return fechaEnvase;
    }

    public void setFechaEnvase(String fechaEnvase) {
        this.fechaEnvase = fechaEnvase;
    }
    
    public Bebida(String nombre, String precio,String medida,String fechaEnvase,String gaseoso,String lacteo) {
     
        super(nombre, precio);

        this.medida=medida;
        this.fechaEnvase=fechaEnvase;
        this.gaseoso=gaseoso;
        this.lacteo=lacteo;
        this.fechaCaducidad=obtenerCaducidad(fechaEnvase);
        
        //Campo para determinar si el producto esta en oferta
        this.oferta="false";
        this.estado="apto";
        
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    
    @Override
    public String obtenerCaducidad(String fechaEnvase){
        
         //Si es lacteo fechaCaducidad=fechaEnvase +10
        //en cualquier otro caso fechaCaducidad=fechaEnvase +20
        
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
           try {
               fecha = sdf.parse(fechaEnvase);
               
                //String fechaEnvaseS = formato.format(fechaEnvase);
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                if(this.getLacteo().equals("true"))
                {
                cal.add(Calendar.DAY_OF_MONTH,10);
            
                fecha = cal.getTime();
            
            
                }else{
            
                cal.add(Calendar.DAY_OF_MONTH,20);
           
                fecha = cal.getTime();
            
                 }//if
           } catch (ParseException ex) {
               Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
                   //Se devuelve la fecha de caducidad calculada
        
                    //String fechaC = fecha.toString();
                    String fechaC=sdf.format(fecha).toString();
        
                    return (fechaC);
           }
       
        
    }//obtenerCaducidad
    
    @Override
    public String detalleProducto(){
        
       String texto="Tipo de producto: BEBIDA \n"
                    +"Nombre:"+this.getNombre()+"\n"
                    +"Precio:"+this.getPrecio()+"\n"
                    +"Medida (ml):"+this.getMedida()+"\n"
                    +"Gaseoso:"+this.getGaseoso()+"\n"
                    +"Lacteo:"+this.getLacteo()+"\n"
                    +"Fecha Envase:"+this.getFechaEnvase()+"\n"
                    +"Fecha Caducidad:"+this.getFechaCaducidad()
                    ;
       return(texto);      
    }
}
