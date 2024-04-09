
package code;

import java.util.Calendar;

public class Fecha implements FechaInterface{
    
    private int day;
    private int month;
    private int year;

    public Fecha(int dia, int mes, int anio) {
        day = dia;
        month = mes;
        year = anio;
    }
    
    
    @Override
    public int day() {
        //Devuelve el dia (valor numerico) de la fecha.
        if(day>0 & day<=31){
            return day;
        } else{
            return -1;
        }
    }

    @Override
    public int month() {
        //Devuelve el mes (valor numerico) de la fecha.
        if(month>0 & month<=12){
            return month;
        } else{
            return -1;
        }
    }

    @Override
    public int year() {
        //Devuelve el año de la fecha.
        if(year>0){
            return year;
        } else{
            return -1;
        }
    }

    @Override
    public String monthName() {
        //Devuelve el nombre del mes de la fecha
        String nombreMes = "";
        switch(month){
            case 1:
                nombreMes = "Enero";
                break;
            case 2:
                nombreMes = "Febrero";
                break;
            case 3:
                nombreMes = "Marzo";
                break;
            case 4:
                nombreMes = "Abril";
                break;
            case 5:
                nombreMes = "Mayo";
                break;
            case 6:
                nombreMes = "Junio";
                break;
            case 7:
                nombreMes = "Julio";
                break;
            case 8:
                nombreMes = "Agosto";
                break;
            case 9:
                nombreMes = "Setiembre";
                break;
            case 10:
                nombreMes = "Octubre";
                break;
            case 11:
                nombreMes = "Noviembre";
                break;
            case 12:
                nombreMes = "Diciembre";
                break;
        }
        return nombreMes;
    }

    @Override
    public int numDays(Fecha otherDate) {
        //Devuelve el numero de dias que hay de diferencia entre la fecha y la fecha pasada como parametro otherDate
        //USANDO EL METODO DE APROXIMADO
        
        
        
        //USANDO EL METODO EXACTO
        
        
        //USANDO LA LIBRERIA CALENDAR
        Calendar inicio = Calendar.getInstance();
        inicio.set(otherDate.year, otherDate.month - 1, otherDate.day);
        inicio.set(Calendar.HOUR, 0);
        inicio.set(Calendar.HOUR_OF_DAY, 0);
        inicio.set(Calendar.MINUTE, 0);
        inicio.set(Calendar.SECOND, 0);
        
        
        Calendar actual = Calendar.getInstance();
        actual.set(year, month - 1, day);
        actual.set(Calendar.HOUR, 0);
        actual.set(Calendar.HOUR_OF_DAY, 0);
        actual.set(Calendar.MINUTE, 0);
        actual.set(Calendar.SECOND, 0);
        
        long finMS = actual.getTimeInMillis();
        long inicioMS = inicio.getTimeInMillis();
        
        int dias = (int) ((Math.abs(finMS - inicioMS)) / (1000 * 60 * 60 * 24) ); //1000 * 60 * 60 * 24 = 86 400 000
        
        return dias;
    }

    @Override
    public boolean isLeapYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int compareTo(Fecha otherDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String str() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
