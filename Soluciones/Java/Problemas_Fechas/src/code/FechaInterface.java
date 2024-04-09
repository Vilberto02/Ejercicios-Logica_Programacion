
package code;

public interface FechaInterface {
    
    public int day();
    
    public int month();
    
    public int year();
    
    public String monthName();
    
    public int numDays(Fecha otherDate);
    
    public boolean isLeapYear();
    
    public int compareTo(Fecha otherDate);
    
    public String str();
    
}
