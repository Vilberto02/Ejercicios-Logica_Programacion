/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import clases.Nodo;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class RegistroEmpleadosV2 extends javax.swing.JFrame {

    /**
     * Creates new form listas_simples
     */
    //Variables Locales
    private Nodo ini, fin;
    private Nodo pFound;
    private int num=0;
    //Formato de la Tabla
    public DefaultTableModel miModelo;
    private String[] cabecera = {"N","Codigo","Nombres","Apellidos","Sexo","Sueldo"};
    private String[][] data = {};
    
    
    public RegistroEmpleadosV2() {
        initComponents();
        setTitle("Registro de empleados V2");
        //Inicializar punteros
        ini = fin = pFound  = null;
        
        //Encabezados de tabla
        miModelo = new DefaultTableModel(data, cabecera){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer todas las celdas no editables
                return false;
            }
        };
        tblRegistros.setModel(miModelo);
        
    }
    
    void Habilitar(){
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
    }
    
    void Deshabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }
    
    void LimpiarEntradas(){
        TextFieldCodigo.setText("");
        TextFieldNombre.setText("");
        TextFieldSueldo.setText("");
        TextFieldApellidos.setText("");
        cbxSexo.setSelectedIndex(0);
        TextFieldCodigo.requestFocus();

    }
    
    void Resumen() {
        Nodo aux=ini;
        String nom="", acum="";
        float suma = 0, mayor = -9999;
        float s;
        
        while(aux!=null){
            s = aux.sueldo;
            if(s>mayor){
                mayor=s;
                nom=aux.nombre+" "+aux.apellidos;
            }
            suma = suma + s;
            aux = aux.sig;
        }
        
        TextFieldNombreMayor.setText(nom);
        DecimalFormat df2 = new DecimalFormat("####.00");
        acum = df2.format(suma);
        TextFieldAcumulado.setText(acum);
    }
    
    void vaciar_tabla(){
        //Obteniendo el # de Filas
        int filas = tblRegistros.getRowCount();
        for(int i=0 ; i<filas ; i++){
            miModelo.removeRow(0);
        }
    }


    
    public void VerDatos(int ind){
        //Variable para recorrer la lista
        String cod, nom, ape, se, su;
        float s;
        switch (ind) {
            case 1: //Recorrido hacia delante
                {
                    vaciar_tabla();
                    Nodo aux=ini;
                    num = 0;
                    while(aux!=null){
                        cod = aux.codigo;
                        nom = aux.nombre;
                        ape = aux.apellidos;
                        se = aux.sexo;
                        //Dando formato al sueldo
                        DecimalFormat df2 = new DecimalFormat("####.00");
                        su = df2.format(aux.sueldo);
                        num++;
                        Object[] fila = {num, cod, nom, ape, se, su};
                        miModelo.addRow(fila);
                        aux=aux.sig;
                    }
                }
                break;
            case 2: //Recorrido hacia atras
                {
                    vaciar_tabla();
                    Nodo aux=fin;
                    num = 0;
                    while(aux!=null){
                        cod = aux.codigo;
                        nom = aux.nombre;
                        ape = aux.apellidos;
                        se = aux.sexo;
                        //Dando formato al sueldo
                        DecimalFormat df2 = new DecimalFormat("####.00");
                        su = df2.format(aux.sueldo);
                        num++;
                        Object[] fila = {num, cod, nom, ape, se, su};
                        miModelo.addRow(fila);
                        aux=aux.ant;
                    }
                }
                break;
        }
    }

    
    void Eliminar(){
        Nodo actual;
        boolean encontrado=false;
        actual=ini;
        while((actual!=null)&&(!encontrado)) //bucle de Busqueda
        {
            encontrado=actual.codigo.equalsIgnoreCase(TextFieldCodigo.getText().trim());
            if(!encontrado)
                actual=actual.sig;
        }
        //Realizando los enlaces
        if(actual!=null)
        {
            if(actual==ini)
            {
                ini=actual.sig; //borrar el primero
                if(actual.sig!=null)
                    actual.sig.ant=null;
            }
            else if(actual.sig!=null) //no es el ultimo
            {
                actual.ant.sig=actual.sig;
                actual.sig.ant=actual.ant;
            }
            else {
                actual.ant.sig=null; //el ultimo
                fin=actual.ant; //moviendo el final
            }
            actual=null;
        }
    }

    
    
    Nodo Buscar (Nodo inicio, String cod){
        Nodo pos = inicio;
        //Recorriendo la lista para encontrar la informacion
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo)){
            pos = pos.sig;
        }
        return pos;
    }

    
    Nodo InsertarFinal(Nodo inicio, String cod, String nom, String ape, String sex, float suel){
        Nodo nuevo = new Nodo(cod, nom, ape, sex, suel);
        //Realizando los enlaces correspondientes
        nuevo.sig = inicio;
        if(inicio == null){
            fin=nuevo;
            fin.sig=null;
        }
        if(inicio!=null){
            inicio.ant = nuevo;
        }
        inicio = nuevo;
        return inicio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextFieldSueldo = new javax.swing.JTextField();
        TextFieldCodigo = new javax.swing.JTextField();
        TextFieldNombre = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TextFieldApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextFieldNombreMayor = new javax.swing.JTextField();
        TextFieldAcumulado = new javax.swing.JTextField();
        btnAd_At = new javax.swing.JButton();
        btnAt_Ad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setText("Registro de empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel2.setText("Sueldo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel3.setText("Codigo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        TextFieldSueldo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jPanel1.add(TextFieldSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 400, 30));

        TextFieldCodigo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jPanel1.add(TextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 400, 30));

        TextFieldNombre.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jPanel1.add(TextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 400, 30));

        btnSalir.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 160, 30));

        btnActualizar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(52, 152, 219));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 160, 30));

        btnEliminar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 87, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 160, 30));

        btnRestaurar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(144, 148, 151));
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 150, 30));

        btnConsultar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 195, 0));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 150, 30));

        btnGuardar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(46, 204, 113));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 150, 30));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        TextFieldApellidos.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        TextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 400, -1));

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel6.setText("Sexo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        cbxSexo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccione---", "Femenino", "Masculino" }));
        jPanel1.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 210, -1));

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 920, 260));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel7.setText("Empleado con el sueldo mayor:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, -1, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel8.setText("Monto de sueldos acumulados:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, -1, -1));

        TextFieldNombreMayor.setEditable(false);
        TextFieldNombreMayor.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jPanel1.add(TextFieldNombreMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 340, -1));

        TextFieldAcumulado.setEditable(false);
        TextFieldAcumulado.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jPanel1.add(TextFieldAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 680, 290, -1));

        btnAd_At.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnAd_At.setText("Adelante - Atras");
        btnAd_At.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAd_AtActionPerformed(evt);
            }
        });
        jPanel1.add(btnAd_At, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 150, 30));

        btnAt_Ad.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnAt_Ad.setText("Atras - Adelante");
        btnAt_Ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAt_AdActionPerformed(evt);
            }
        });
        jPanel1.add(btnAt_Ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1062, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String cod=TextFieldCodigo.getText();
        String nom=TextFieldNombre.getText().toUpperCase();
        String ape=TextFieldApellidos.getText().toUpperCase();
        String sex=cbxSexo.getSelectedItem().toString();
        String suel=TextFieldSueldo.getText();
        //Creando el nodo de la lista en memoria y colocando la informacion
        ini=InsertarFinal(ini, cod, nom, ape,sex,Float.parseFloat(suel));
        LimpiarEntradas();
        VerDatos(1);
        Resumen();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        pFound.codigo = TextFieldCodigo.getText();
        pFound.nombre = TextFieldNombre.getText().toUpperCase();
        pFound.apellidos = TextFieldApellidos.getText().toUpperCase();
        pFound.sexo=cbxSexo.getSelectedItem().toString();
        pFound.sueldo =Float.parseFloat(TextFieldSueldo.getText());
        LimpiarEntradas();
        Deshabilitar();
        VerDatos(1);
        Resumen();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String cod=TextFieldCodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese un codigo por favor");
        } else {
            pFound=Buscar(ini,cod);
            if(pFound!=null){
                TextFieldNombre.setText(pFound.nombre);
                TextFieldApellidos.setText(pFound.apellidos);
                if(pFound.sexo.equalsIgnoreCase("MASCULINO"))
                    cbxSexo.setSelectedIndex(2);
                else
                    cbxSexo.setSelectedIndex(1);
                TextFieldSueldo.setText(String.valueOf(pFound.sueldo));
                Habilitar();
            }
            else{
                JOptionPane.showMessageDialog(this,"El codigo: " + cod + ", no esta en la Lista..");
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Eliminar();
        LimpiarEntradas();
        VerDatos(1);
        if(ini==null){
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        }
        Deshabilitar();
        Resumen();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        LimpiarEntradas();
        Deshabilitar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void TextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldApellidosActionPerformed

    private void btnAd_AtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAd_AtActionPerformed
        // TODO add your handling code here:
        VerDatos(1);
    }//GEN-LAST:event_btnAd_AtActionPerformed

    private void btnAt_AdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAt_AdActionPerformed
        // TODO add your handling code here:
        VerDatos(2);
    }//GEN-LAST:event_btnAt_AdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEmpleadosV2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField TextFieldAcumulado;
    public javax.swing.JTextField TextFieldApellidos;
    public javax.swing.JTextField TextFieldCodigo;
    public javax.swing.JTextField TextFieldNombre;
    public javax.swing.JTextField TextFieldNombreMayor;
    public javax.swing.JTextField TextFieldSueldo;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAd_At;
    public javax.swing.JButton btnAt_Ad;
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnRestaurar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
