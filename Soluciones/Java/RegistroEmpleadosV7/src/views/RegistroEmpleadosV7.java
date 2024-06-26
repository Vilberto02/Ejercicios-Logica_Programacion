/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import code.NodoArbol;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class RegistroEmpleadosV7 extends javax.swing.JFrame {

    /**
     * Creates new form listas_simples
     */
    //Formato de la Tabla
    DefaultTableModel miModelo;
    String[] cabecera = {"N","Codigo","Nombres","Apellidos","Sexo","Sueldo"};
    String[][] data = {};
    
    //Variables Locales
    public NodoArbol raiz;
    public NodoArbol pFound;
    int num = 0, tam = 0;
    
    
    public RegistroEmpleadosV7() {
        initComponents();
        fincola = null;
        tam = 0;
        setTitle("Registro de empleados V7: Uso de arboles binarios");
        
        miModelo = new DefaultTableModel(data, cabecera){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer todas las celdas no editables
                return false;
            }
        };
        tblRegistros.setModel(miModelo);
        
    }
    
    private void agregar(int cod, String nom, String ape, String sex, float suel){
        NodoArbol aux = null, back = null;
        NodoArbol nuevo = new NodoArbol(cod, nom, ape, sex, suel);
        if(raiz == null){
            raiz = nuevo;
        }else{
            aux = raiz;
            while(aux != null){
                back = aux;
                if(cod < aux.codigo){
                    aux = aux.hijoIzquierdo;
                }else{
                    aux = aux.hijoDerecho;
                }
            }
            if(cod<back.codigo){
                back.hijoIzquierdo = nuevo;
            }else{
                back.hijoDerecho = nuevo;
            }
        }
    }
    
    
    public NodoArbol agregarRecursivo(NodoArbol p, int cod, String nom, String ape, String sex, float suel){
        if(p == null){
            p = new NodoArbol(cod, nom, ape, sex, suel);
        }else{
            if(cod < p.codigo){
                p.hijoDerecho = agregarRecursivo(p.hijoDerecho, cod, nom, suel);
            }else{
                p.hijoIzquierdo = agregarRecursivo(p.hijoIzquierdo, cod, nom, suel);
            }
        }
    }
    
    
    private NodoArbol Buscar (NodoArbol frente, String cod){
        NodoArbol pos = frente;
        //Recorriendo la lista para encontrar la informacion
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo)){
            pos = pos.sig;
        }
        return pos;
    }
    
    private void mensaje(String data){
        StringTokenizer st = new StringTokenizer(data, ",");
        //Partiendo el texto
        String c = st.nextToken();
        String n = st.nextToken();
        String a = st.nextToken();
        String s = st.nextToken();
        String su = st.nextToken();
        String datos = "Eliminando al primer dato ingresado\n"+
                        "Descripcion del dato eliminado: \n"+
                        "Codigo: "+c+"\n"+
                        "Nombre: "+n+"\n"+
                        "Apellidos: "+a+"\n"+
                        "Sexo: "+s+"\n"+
                        "Sueldo: "+su+"\n";
        JOptionPane.showMessageDialog(this, datos);
    }
    
    void Habilitar(){
        btnActualizar.setEnabled(true);
        btnPostOrden.setEnabled(false);
    }
    
    void Deshabilitar(){
        btnActualizar.setEnabled(false);
        btnPostOrden.setEnabled(true);
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
        String nom="", acum="";
        float suma = 0, mayor = -9999;
        float s;
        NodoArbol p = frente;
        
        while(p != null){
            s = p.sueldo;
            if(s>mayor){
                mayor = s;
                nom = p.nombre + " " + p.apellidos;
            }
            suma = suma + s;
            p = p.sig;
        }
        //Estableciendo la informacion en el txt
        TextFieldNombreMayor.setText(nom);
        
        //Formato del Acumulado
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


    
    public void VerDatos(){
        String cod, nom, ape, se, su;
        NodoArbol aux=frente;
        vaciar_tabla();
        num = 0;
        tam = 0;
        while(aux != null){
            cod=aux.codigo;
            nom=aux.nombre;
            ape=aux.apellidos;
            se=aux.sexo;
            
            //Dando formato al sueldo
            DecimalFormat df2 = new DecimalFormat("####.00");
            su = df2.format(aux.sueldo);
            Object[] fila = {num, cod, nom, ape, se, su};
            num++;
            tam++;
            miModelo.addRow(fila);
            aux=aux.sig;
        }
        TextFieldTamanio.setText(String.valueOf(tam));
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
        btnPostOrden = new javax.swing.JButton();
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
        btnGuardar1 = new javax.swing.JButton();
        btnPreOrden = new javax.swing.JButton();
        btnInOrden = new javax.swing.JButton();

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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 160, 30));

        btnActualizar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(52, 152, 219));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 160, 30));

        btnEliminar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 87, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 160, 30));

        btnRestaurar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(144, 148, 151));
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 150, 30));

        btnConsultar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 195, 0));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 150, 30));

        btnPostOrden.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnPostOrden.setForeground(new java.awt.Color(62, 47, 91));
        btnPostOrden.setText("Mostrar Post-Orden");
        btnPostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 250, 30));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 920, 200));

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

        btnGuardar1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(46, 204, 113));
        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 150, 30));

        btnPreOrden.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnPreOrden.setForeground(new java.awt.Color(0, 15, 8));
        btnPreOrden.setText("Mostrar Pre-Orden");
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 200, 30));

        btnInOrden.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnInOrden.setForeground(new java.awt.Color(243, 66, 19));
        btnInOrden.setText("Mostrar In-Orden");
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 220, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1062, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostOrdenActionPerformed
        // TODO add your handling code here:
        String cod=TextFieldCodigo.getText();
        String nom=TextFieldNombre.getText().toUpperCase();
        String ape=TextFieldApellidos.getText().toUpperCase();
        String sex=cbxSexo.getSelectedItem().toString();
        String suel=TextFieldSueldo.getText();
        //Creando el nodo de la lista en memoria y colocando la informacion
        encolar(cod, nom, ape,sex,Float.parseFloat(suel));
        tam++;
        LimpiarEntradas();
        VerDatos();
        Resumen();
    }//GEN-LAST:event_btnPostOrdenActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        pFound.codigo = TextFieldCodigo.getText();
        pFound.nombre = TextFieldNombre.getText().toUpperCase();
        pFound.apellidos = TextFieldApellidos.getText().toUpperCase();
        pFound.sexo=cbxSexo.getSelectedItem().toString();
        pFound.sueldo =Float.parseFloat(TextFieldSueldo.getText());
        LimpiarEntradas();
        Deshabilitar();
        VerDatos();
        Resumen();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String cod=TextFieldCodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese un codigo por favor");
        } else {
            pFound=Buscar(frente,cod);
            if(pFound!=null){
                TextFieldNombre.setText(pFound.nombre);
                TextFieldApellidos.setText(pFound.apellidos);
                if(pFound.sexo.equalsIgnoreCase("MASCULINO")){
                    cbxSexo.setSelectedIndex(2);
                }else{
                    cbxSexo.setSelectedIndex(1);
                }
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
        if(frente == null){
            JOptionPane.showMessageDialog(this, "La cola esta vacia");
            TextFieldCodigo.requestFocus();
        }else{
            String dato = frente();
            mensaje(dato);
            LimpiarEntradas();
            VerDatos();
            if(frente == null){
                JOptionPane.showMessageDialog(this, "La lista esta vacia");
            }
            Deshabilitar();
            Resumen();
        }
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

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnPreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreOrdenActionPerformed

    private void btnInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInOrdenActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEmpleadosV7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosV7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEmpleadosV7().setVisible(true);
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
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar1;
    public javax.swing.JButton btnInOrden;
    public javax.swing.JButton btnPostOrden;
    public javax.swing.JButton btnPreOrden;
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
