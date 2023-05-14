/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

/**
 *
 * @author MSI
 */

    
 import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author x100171
 *
 */
public class TratamientoFicheros{
	
	//Ruta es global 
	String ruta_clientes = "C:\\Users\\MSI\\Documents\\NetBeansProjects\\GestionPedidos\\src\\main\\java\\GestionPedidos\\alamcenamiento\\Clientes.txt";
	String ruta_productos = "C:\\Users\\MSI\\Documents\\NetBeansProjects\\GestionPedidos\\src\\main\\java\\GestionPedidos\\alamcenamiento\\Productos.txt";
	
	public TratamientoFicheros() {
		
		
	}
	/**
	 * 
	 * @param datos
	 * @param tipo
	 */
	
	public void escribeFicheroClientes(ArrayList <DatosClientes> alClientes) {
            
                 ArrayList <DatosClientes> alClientes1 = new ArrayList<DatosClientes>();
                 alClientes1=alClientes;
	
		FileWriter fichero = null;
		PrintWriter pw = null;
                
		try {
                    
		//Se trata del fichero de clientes
			
		// Añadir flag a true para no machacar contenido del fichero de escritura
            	fichero = new FileWriter(ruta_clientes, true);
                            	
                //Se añade al fichero la ultima posición del arrayList
		
                int i=alClientes1.size()-1;
                
                //Se guardan cada uno de los campos del cliente separados por el delimitador ,
                pw = new PrintWriter(fichero);
			
                pw.println(alClientes1.get(i).getNombre()+","+alClientes1.get(i).getApellidos()+","+alClientes1.get(i).getTlfno()+","+alClientes1.get(i).getDireccion()+",");
                //}//for               
			
               
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
					// Nuevamente aprovechamos el finally para
					// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try
		}//finally
	
	}//escribeFicheroClientes
	
	public void escribeFicheroProductos(ArrayList <Comida> alComida,ArrayList <Bebida> alBebida,char tipoProducto) {
		
            if(tipoProducto=='C')
            {
            
                 ArrayList<Comida> alComida1;
                 alComida1=alComida;
     
            
		FileWriter fichero = null;
		PrintWriter pw = null;
                
		try {
                    
		// Añadir flag a true para no machacar contenido del fichero de escritura
            	fichero = new FileWriter(ruta_productos, true);
                            	
               	//Se añade al fichero la ultima posicion del arrayList de Comidas
                            	
                int i=alComida1.size()-1;
			
                //Se guardan cada uno de los campos del cliente separados por el delimitador ,
                pw = new PrintWriter(fichero);
		
                pw.println("C,"+alComida1.get(i).getNombre()+","+alComida1.get(i).getPrecio()+","+alComida1.get(i).getcalorias()+","+alComida1.get(i).getfechaEnvase()+","+alComida1.get(i).getperecedero()+","+alComida1.get(i).getvegano()+","+alComida1.get(i).getFechaCaducidad()+",");           
                   		
               
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try
		}//finally
                
            }//Comida
            
         
            if(tipoProducto=='B')
            {
            
                 ArrayList<Bebida> alBebida1;
                 alBebida1=alBebida;
     
            
		FileWriter fichero = null;
		PrintWriter pw = null;
                
		try {
                    
		// Añadir flag a true para no machacar contenido del fichero de escritura
            	fichero = new FileWriter(ruta_productos, true);
                            	
               	//Se añade la ultima posicion del arrayList de Bebidas
                            	
                int j=alBebida1.size()-1;
                //Se guardan cada uno de los campos del cliente separados por el delimitador ,
                pw = new PrintWriter(fichero);
		
                pw.println("B,"+alBebida1.get(j).getNombre()+","+alBebida1.get(j).getPrecio()+","+alBebida1.get(j).getMedida()+","+alBebida1.get(j).getFechaEnvase()+","+alBebida1.get(j).getGaseoso()+","+alBebida1.get(j).getLacteo()+","+alBebida1.get(j).getFechaCaducidad()+",");           
                   		
               
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try
		}//finally
                
            }//Bebida
            
         
	
	}//escribeFicheroProductos
	
	
    public void leerFicheroClientes(ArrayList<DatosClientes> alClientes1)
    {
               
            File f = new File(ruta_clientes);
            //System.out.println("La ruta del fichero es: " +f.getAbsolutePath());
            Scanner s;
			try {
				s = new Scanner(f);
				while (s.hasNextLine()) {
					String linea = s.nextLine();
					Scanner sl = new Scanner(linea);
					sl.useDelimiter("\\s*,\\s*");
                                                                              
                                        //Se genera un nuevo objeto tipo DatosClientes...
                                        DatosClientes nuevoCliente=new DatosClientes("1","1","1","1");
                                        
                                        
                                        //Se rellenan los datos del cliente
                                        
					nuevoCliente.setNombre(sl.next());
                                        nuevoCliente.setApellidos(sl.next());
                                        nuevoCliente.setTlfno(sl.next());
                                        nuevoCliente.setDireccion(sl.next());
                                        
                                        //Se añade el cliente al arrayList
                                        
                                        alClientes1.add(nuevoCliente);                                   
                                        
					
				}//while
				s.close();
			} catch (FileNotFoundException e) {
				// PrintWriter pw = null;
				e.printStackTrace();
				// e.printStackTrace(pw);
			}//try
                        
    }//leerFicheroClientes

    public void leerFicheroProductos(ArrayList<Comida> alComida1,ArrayList<Bebida> alBebida1) {
        
        char tipoProducto;
    	
    	File f = new File(ruta_productos);
        //System.out.println("La ruta del fichero es: " +f.getAbsolutePath());
        Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				
				sl.useDelimiter("\\s*,\\s*");
                                
                                //Se lee el primer campo para discriminar si es C/B
                                
                                if(sl.next().equals("C")){
                                    
                                    //Se genera un nuevo objeto Comida
                                    Comida nuevaComida=new Comida("1","1","1","1/1/2000","false","false");
                                    
                                    //Se rellenan los datos de la nuevaComida
                                        
					nuevaComida.setNombre(sl.next());
                                        nuevaComida.setPrecio(sl.next());
                                        nuevaComida.setcalorias(sl.next());
                                        nuevaComida.setfechaEnvase(sl.next());
                                        nuevaComida.setperecedero(sl.next());
                                        nuevaComida.setvegano(sl.next());
                                        nuevaComida.setFechaCaducidad(sl.next());
                                       
                                        
                                        //Se añade el cliente al arrayList
                                        
                                        alComida1.add(nuevaComida);      
                                    
                                }else{
                                    
                                    //Se trata de una bebida
                                    
                                    //Se genera un nuevo objeto Bebida
                                    Bebida nuevaBebida=new Bebida("1","1","1","1/1/2000","false","false");
                                    
                                    //Se rellenan los datos de la nuevaComida
                                        
					nuevaBebida.setNombre(sl.next());
                                        nuevaBebida.setPrecio(sl.next());
                                        nuevaBebida.setMedida(sl.next());
                                        nuevaBebida.setFechaEnvase(sl.next());                
                                        nuevaBebida.setGaseoso(sl.next());
                                        nuevaBebida.setLacteo(sl.next());
                                        nuevaBebida.setFechaCaducidad(sl.next());
                                       
                                        
                                        //Se añade el cliente al arrayList
                                        
                                        alBebida1.add(nuevaBebida);      
                                    
                                }
                                
                                /*
                                if(sl.next().equals("B")){
                                    
                                    //Se genera un nuevo objeto Bebida
                                    Bebida nuevaBebida=new Bebida("1","1","1","1","1","1");
                                    
                                    //Se rellenan los datos de la nuevaComida
                                        
					nuevaBebida.setNombre(sl.next());
                                        nuevaBebida.setPrecio(sl.next());
                                        nuevaBebida.setMedida(sl.next());
                                        nuevaBebida.setFechaEnvase(sl.next());                
                                        nuevaBebida.setGaseoso(sl.next());
                                        nuevaBebida.setLacteo(sl.next());
                                        nuevaBebida.setFechaCaducidad(sl.next());
                                       
                                        
                                        //Se añade el cliente al arrayList
                                        
                                        alBebida1.add(nuevaBebida);      
                                    
                                }//if nuevaBebida
				
                                */
				
			}//while
			s.close();
		} catch (FileNotFoundException e) {
			// PrintWriter pw = null;
			e.printStackTrace();
			// e.printStackTrace(pw);
		}//try
    	
		
			
    }//leerFicheroProductos
    
}//TratamientoFicheros

    
