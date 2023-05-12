/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static java.util.Date.parse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Comida extends DatosProductos{
       String perecedero;
       String vegano;
       String calorias;
       String fechaEnvase;
       String fechaCaducidad;
       String oferta;

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

        
    public Comida(String nombre, String precio, String calorias,String fechaEnvase,String perecedero, String vegano){
     
        super(nombre,precio);
        this.perecedero=perecedero;
        this.vegano=vegano;
        this.calorias=calorias;
        this.fechaEnvase=fechaEnvase;
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //this.fechaCaducidad=sdf.format(fechaCaducidad);
        this.fechaCaducidad=this.obtenerCaducidad(fechaEnvase);
        
        //Campo para determinar si el producto esta en oferta
        this.oferta="false";
   
    }
    
    /**
     * @return the perecedero
     */
	public String getperecedero() {
		return perecedero;
	}


    /**
     * @param perecedero the perecedero to set
    */
    public void setperecedero(String perecedero) {
		this.perecedero = perecedero;
    }

    /**
     * @return the vegano
     */
	public String getvegano() {
		return vegano;
	}


    /**
     * @param vegano the vegano to set
    */
    public void setvegano(String vegano) {
		this.vegano = vegano;
    }
    
    /**
     * @return the vegano
     */
	public String getcalorias() {
		return calorias;
	}


    /**
     * @param calorias the calorias to set
    */
    public void setcalorias(String calorias) {
		this.calorias = calorias;
    }


    /**
     * @return the vegano
     */
	public String getfechaEnvase() {
		return fechaEnvase;
	}


    /**
     * @param vegano the pereced to set
    */
    public void setfechaEnvase(String fechaEnvase) {
		this.fechaEnvase = fechaEnvase;
    }
    
    
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    @Override
    public String obtenerCaducidad(String fechaEnvase){
        
        //Si es perecedero fechaCaducidad=fechaEnvase +10
        //en cualquier otro caso fechaCaducidad=fechaEnvase +20
        
        Date fecha = new Date();
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        
           try {
               fecha = sdf.parse(fechaEnvase);
               
                //String fechaEnvaseS = formato.format(fechaEnvase);
                
                cal.setTime(fecha);
                if(this.getperecedero().equals("true"))
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
        
       String texto="Tipo de producto:COMIDA \n"
                    +"Nombre:"+this.getNombre()+"\n"
                    +"Precio:"+this.getPrecio()+"\n"
                    +"Calorias:"+this.getcalorias()+"\n"
                    +"Peredero:"+this.getperecedero()+"\n"
                    +"Vegano:"+this.getvegano()+"\n"
                    +"Fecha Envase:"+this.getfechaEnvase()+"\n"
                    +"Fecha Caducidad:"+this.getFechaCaducidad()
                    ;
       return(texto);      
        
    }
    
    
    
}
    

