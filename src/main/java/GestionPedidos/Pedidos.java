/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GestionPedidos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class Pedidos extends javax.swing.JInternalFrame {
        
    public ArrayList<Comida> alComida3=new ArrayList<Comida>();
    public ArrayList<Bebida> alBebida3=new ArrayList<Bebida>();
    public ArrayList<DatosClientes> alClientes3=new ArrayList<DatosClientes>();
 
    String datosPedido;
    float importePedido;
    String otros="";
    
    
    

    /**
     * Creates new form Pedidos
     */
    

     public Pedidos(ArrayList<Comida> alComida1, ArrayList<Bebida> alBebida1,ArrayList<DatosClientes> alClientes1) {
        
        
        initComponents();
        alClientes3=alClientes1;
        alComida3=alComida1;
        alBebida3=alBebida1;
        
    }//Pedidos
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClientesDisponibles = new javax.swing.JLabel();
        lblProductosDisponiblesComida = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClientesDisponibles = new javax.swing.JList<>();
        btnMostrarDatos = new javax.swing.JButton();
        btnRealizarPedido = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDatosPedido = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductosDisponiblesComida = new javax.swing.JTable();
        lblProductosDisponiblesBebida = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbProductosDisponiblesBebida = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("NUEVO PEDIDO");
        setToolTipText("NUEVO PEDIDO");

        lblClientesDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClientesDisponibles.setText("Clientes disponibles");

        lblProductosDisponiblesComida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductosDisponiblesComida.setText("Productos disponibles (COMIDA)");

        lstClientesDisponibles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstClientesDisponibles);

        btnMostrarDatos.setText("Mostrar Datos");
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });

        btnRealizarPedido.setText("Realizar pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        taDatosPedido.setColumns(4);
        taDatosPedido.setRows(5);
        jScrollPane3.setViewportView(taDatosPedido);

        tbProductosDisponiblesComida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO (€)", "CALORIAS", "FECHA ENVASE", "FECHA CADUCIDAD", "PERECEDRO", "VEGANO", "OTROS"
            }
        ));
        tbProductosDisponiblesComida.setToolTipText("Productos de cmida disponibles");
        tbProductosDisponiblesComida.setDragEnabled(true);
        tbProductosDisponiblesComida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tbProductosDisponiblesComida);
        if (tbProductosDisponiblesComida.getColumnModel().getColumnCount() > 0) {
            tbProductosDisponiblesComida.getColumnModel().getColumn(7).setPreferredWidth(300);
        }
        tbProductosDisponiblesComida.getAccessibleContext().setAccessibleDescription("Productos de comida disponibles");

        lblProductosDisponiblesBebida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductosDisponiblesBebida.setText("Productos disponibles (BEBIDA)");

        tbProductosDisponiblesBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO (€)", "MEDIDA (ml)", "FECHA ENVASE", "FECHA CADUCIDAD", "GASEOSO", "LACTEO", "OTROS"
            }
        ));
        tbProductosDisponiblesBebida.setToolTipText("Productos de bebida disponibles");
        tbProductosDisponiblesBebida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(tbProductosDisponiblesBebida);
        if (tbProductosDisponiblesBebida.getColumnModel().getColumnCount() > 0) {
            tbProductosDisponiblesBebida.getColumnModel().getColumn(7).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblProductosDisponiblesBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblClientesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(lblProductosDisponiblesComida, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnMostrarDatos)
                        .addGap(39, 39, 39)
                        .addComponent(btnRealizarPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClientesDisponibles)
                    .addComponent(lblProductosDisponiblesComida))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductosDisponiblesBebida)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarDatos)
                    .addComponent(btnRealizarPedido))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed
        
        //ArrayList<String> datosClientes=new ArrayList<String>();
        //ArrayList<String> datosProductos=new ArrayList<String>();
        
        TratamientoFicheros tfCargarDatos=new TratamientoFicheros();
        //tf3.leerFichero(1,datosClientes);
        //tf3.leerFichero(2,datosProductos);
        
        DefaultListModel<String> modeloClientes = new DefaultListModel<>();
        DefaultTableModel modeloComidas = new DefaultTableModel();
        DefaultTableModel modeloBebidas = new DefaultTableModel();
 

        
       modeloComidas = (DefaultTableModel) tbProductosDisponiblesComida.getModel();
       modeloBebidas = (DefaultTableModel) tbProductosDisponiblesBebida.getModel();
        
         for (int i = 0; i < alClientes3.size(); i++) {
             modeloClientes.addElement(alClientes3.get(i).getNombre());
         }//Clientes
        
         for (int j = 0; j < alComida3.size(); j++) {
             
             //Se comprueba si es una oferta o caducado
             
             String[] caducadoYOtros = new String[] { "false", "Apto"};
             caducadoYOtros=this.esOfertaOCaducado(j, 'C', caducadoYOtros);
             
             
             if(caducadoYOtros[0].equals("true")){
                 
                 //Producto caducado. No se añade la linea
                 //modeloComidas.addRow(new Object [] {alComida3.get(j).getNombre(),alComida3.get(j).getPrecio(),alComida3.get(j).getcalorias(),alComida3.get(j).getfechaEnvase(),alComida3.get(j).getFechaCaducidad(),alComida3.get(j).getperecedero(),alComida3.get(j).getvegano(),caducadoYOtros[1]});
                 
             }else{
                modeloComidas.addRow(new Object [] {alComida3.get(j).getNombre(),alComida3.get(j).getPrecio(),alComida3.get(j).getcalorias(),alComida3.get(j).getfechaEnvase(),alComida3.get(j).getFechaCaducidad(),alComida3.get(j).getperecedero(),alComida3.get(j).getvegano(),caducadoYOtros[1]});
  
             }

         }//Comida
       
          for (int k = 0; k < alBebida3.size(); k++) {
             
               //Se comprueba si es una oferta o caducado
             
             String[] caducadoYOtros = new String[] { "false", "Apto"};
             caducadoYOtros=this.esOfertaOCaducado(k, 'B', caducadoYOtros);
              
              if(caducadoYOtros[0].equals("true")){
               //Caducado. No se añade la linea
              //modeloBebidas.addRow(new Object [] {alBebida3.get(k).getNombre(),alBebida3.get(k).getPrecio(),alBebida3.get(k).getMedida(),alBebida3.get(k).getFechaEnvase(),alBebida3.get(k).getFechaCaducidad(),alBebida3.get(k).getGaseoso(),alBebida3.get(k).getLacteo(),caducadoYOtros[1]});
              }else{
               modeloBebidas.addRow(new Object [] {alBebida3.get(k).getNombre(),alBebida3.get(k).getPrecio(),alBebida3.get(k).getMedida(),alBebida3.get(k).getFechaEnvase(),alBebida3.get(k).getFechaCaducidad(),alBebida3.get(k).getGaseoso(),alBebida3.get(k).getLacteo(),caducadoYOtros[1]});       
              }
              
          }//Bebida
        
        //Se asignan los modelos a las listas o tablas
        lstClientesDisponibles.setModel(modeloClientes);
        tbProductosDisponiblesComida.setModel(modeloComidas);
        tbProductosDisponiblesBebida.setModel(modeloBebidas);
        
    }//GEN-LAST:event_btnMostrarDatosActionPerformed

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoActionPerformed
        
        if(btnRealizarPedido.getText().equals("PAGAR PEDIDO")) {
            
                    //Se genera un objeto tipo SistemaPago
            
                    SistemaPago pago=new SistemaPago (importePedido,datosPedido);
                      
                    pago.show();
       }
        
        
        if(btnRealizarPedido.getText().equals("Realizar pedido")) {
        
                    //Hay que pedirle al usuario la cantidad
                    
                    int cantidad=Integer.parseInt(JOptionPane.showInputDialog("¿Cantidad del producto seleccionado (entero) ?:"));
      
                    //Se obtienen las selecciones del usuario y se genera el pedido correspondiente
                    
                    int seleccionClientes,seleccionComida,seleccionBebida;
                    
                    seleccionClientes=lstClientesDisponibles.getSelectedIndex();
                    seleccionComida=tbProductosDisponiblesComida.getSelectedRow();
                    seleccionBebida=tbProductosDisponiblesBebida.getSelectedRow();
                    
                    String datosPedido;
                    //datosPedido=taDatosPedido.getText();
        		       	
                    taDatosPedido.append("Pedido dado de alta con los siguientes datos :\n");
                    //taDatosPedido.append("===               =====             =========                 =========          =====\n");
                    taDatosPedido.append("CLIENTE           CANT.             PRODUCTO                  PRECIO UD.         TOTAL\n");
                    
                    //Se comprueba si se ha seleccionado comida/bebida...
                    
                    if(seleccionComida!=-1){
                        
                     importePedido=Float.parseFloat(alComida3.get(seleccionComida).getPrecio())*cantidad;
                     
                     taDatosPedido.append(alClientes3.get(seleccionClientes).getNombre()+"           "+cantidad+"                     "+alComida3.get(seleccionComida).getNombre()+"                           "+alComida3.get(seleccionComida).getPrecio()+"                              "+importePedido+" €\n");     
                    }
                    
                    if(seleccionBebida!=-1){
                        
                    importePedido=Float.parseFloat(alBebida3.get(seleccionBebida).getPrecio())*cantidad;
                        
                    taDatosPedido.append(alClientes3.get(seleccionClientes).getNombre()+"            "+cantidad+"                     "+alBebida3.get(seleccionBebida).getNombre()+"                           "+alBebida3.get(seleccionBebida).getPrecio()+"                               "+importePedido+" €\n");
                    }
                    
                    //Se recogen los datos del pedido para ser impresos...
                    
                    this.datosPedido=taDatosPedido.getText();
                	
                    //Se cambia el texto del boton a "PAGAR PEDIDO"
                	
                    btnRealizarPedido.setText("PAGAR PEDIDO");	
        }
        
        
    }//GEN-LAST:event_btnRealizarPedidoActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblClientesDisponibles;
    private javax.swing.JLabel lblProductosDisponiblesBebida;
    private javax.swing.JLabel lblProductosDisponiblesComida;
    private javax.swing.JList<String> lstClientesDisponibles;
    private javax.swing.JTextArea taDatosPedido;
    private javax.swing.JTable tbProductosDisponiblesBebida;
    private javax.swing.JTable tbProductosDisponiblesComida;
    // End of variables declaration//GEN-END:variables


//Metodo para determinar si un producto esta en oferta o caducado. Devuelve una cadena indicandolo
    public String[] esOfertaOCaducado (int pos,char tipo,String[] caducadoYOtros){
        
        String fechaCaducidadString;

        //DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if(tipo=='C'){
            
            fechaCaducidadString=alComida3.get(pos).getFechaCaducidad();
            
              String anio = fechaCaducidadString.substring(6, 10);
              String mes = fechaCaducidadString.substring(3, 5);
              String dia = fechaCaducidadString.substring(0, 2);
              String fechaCaducidadStringValida = anio+"-"+mes+"-"+dia;

            LocalDate fechaCaducidad1 =LocalDate.parse(fechaCaducidadStringValida);
            
            LocalDate fechaActual1=LocalDate.now();
            
                    //Se comparan las dos fechas
        
                    if(fechaCaducidad1.isAfter(fechaActual1)){
                        //Apto
            
                        //Si es apto se comprueba si esta en oferta o no...
            
                       if(fechaActual1.isAfter(fechaCaducidad1.minusDays(5))){
                        caducadoYOtros[1]="¡¡OFERTA!! DCTO 30% Precio anterior : "+alComida3.get(pos).getPrecio();
                        
                            if(alComida3.get(pos).getOferta().equals("false")){
                            alComida3.get(pos).setPrecio(Double.toString((Float.parseFloat(alComida3.get(pos).getPrecio())*0.7)));
                            //Se marca como producto en oferta
                            alComida3.get(pos).setOferta("true");
                            }
                       }
            
                    }
                    
                    if( fechaCaducidad1.isBefore(fechaActual1) ){
                        //Producto caducado
                       
                        caducadoYOtros[0]="true";
                        caducadoYOtros[1]="COMIDA CADUCADA";
                        
                    }
            
        }//comida
        
        if(tipo=='B'){
            
            fechaCaducidadString=alBebida3.get(pos).getFechaCaducidad();
            
             String anio = fechaCaducidadString.substring(6, 10);
              String mes = fechaCaducidadString.substring(3, 5);
              String dia = fechaCaducidadString.substring(0, 2);
              String fechaCaducidadStringValida = anio+"-"+mes+"-"+dia;

            LocalDate fechaCaducidad1 =LocalDate.parse(fechaCaducidadStringValida);
           
            
            LocalDate fechaActual1=LocalDate.now();
            
                    //Se comparan las dos fechas
        
                    if(fechaCaducidad1.isAfter(fechaActual1)){
                        //Apto
            
                        //Si es apto se comprueba si esta en oferta o no...
            
                       if(fechaActual1.isAfter(fechaCaducidad1.minusDays(5))){
                        caducadoYOtros[1]="¡¡OFERTA!! DCTO 30% Precio anterior : "+alBebida3.get(pos).getPrecio();
                        
                            if(alBebida3.get(pos).getOferta().equals("false")){
                            alBebida3.get(pos).setPrecio(Double.toString((Float.parseFloat(alBebida3.get(pos).getPrecio())*0.7)));
                            //Se marca como producto en oferta
                            alBebida3.get(pos).setOferta("true");
                            }
                       }
            
                    }
                    
                    if( fechaCaducidad1.isBefore(fechaActual1) ){
                        //Producto caducado
                       
                        caducadoYOtros[0]="true";
                        caducadoYOtros[1]="BEBIDA CADUCADA";
                        
                    }
            
            
        }//bebida            
                    
         //Se devuelve
         return(caducadoYOtros);
        
    }//esOfertaOCaducado
       
}





