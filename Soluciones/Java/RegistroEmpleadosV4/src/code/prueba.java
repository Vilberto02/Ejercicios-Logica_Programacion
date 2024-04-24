/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class prueba {
    public void VerDatos(int ind){
        //Variable para recorrer la lista
        String cod, nom, ape, se, su;
        Nodo aux=tope;
        vaciar_tabla();
        Nodo p;
        num=Num_elem();
        while(aux!=null){
            cod=aux.codigo;
            nom=aux.nombre;
            ape=aux.apellidos;
            se=aux.sexo;
            
            //Dando formato al sueldo
            DecimalFormat df2 = new DecimalFormat("####.00");
            su = df2.format(aux.sueldo);
            Object[] fila = {num, cod, nom, ape, se, su};
            num--;
            miModelo.addRow(fila);
            aux=aux.sig;

        }
    }
    private int Num_elem(){
        int num=0;
        Nodo aux=tope;
        while(aux!=null){
            num++;
            aux=aux.sig;
        }
        return num;
    }
    
    private Nodo Buscar (Nodo tope, String cod){
        Nodo pos = tope;
        //Recorriendo la lista para encontrar la informacion
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo)){
            pos = pos.sig;
        }
        return pos;
    }
    
    private void push(String cod, String nom, String ape, String sex, float suel){
        Nodo nuevo = new Nodo(cod, nom, ape, sex, suel);
        //Realizando los enlaces correspondientes
        if(tope == null){
            nuevo.sig = null;
        }
        else{
            nuevo.sig = tope;
        }
        tope = nuevo;
    }
    
    private void mensaje(String data){
        StringTokenizer st = new StringTokenizer(data, ",");
        //Partiendo el texto
        String c = st.nextToken();
        String n = st.nextToken();
        String a = st.nextToken();
        String s = st.nextToken();
        String su = st.nextToken();
        String datos = "Descripcion del dato eliminado: \n"+
                        "Codigo: "+c+"\n"+
                        "Nombre: "+n+"\n"+
                        "Apellidos: "+a+"\n"+
                        "Sexo: "+s+"\n"+
                        "Sueldo: "+su+"\n";
        JOptionPane.showMessageDialog(this, datos);
    }


}
