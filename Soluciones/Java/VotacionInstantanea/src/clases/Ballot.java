package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author sanf_
 */
public class Ballot implements Comparable<Ballot> {
    private LinkedList<String> preferences;
    public Ballot(String[] names){
        preferences = new LinkedList<>();
        for(String next : names){
            preferences.add(next);
        }
    }
    
    public String getCandidate(){
        return preferences.getFirst();
    }
    
    public void eliminate(String name){
        preferences.remove(name);
    }
    
    @Override
    public int compareTo(Ballot other){
        return this.getCandidate().compareTo(other.getCandidate());
    }
    
    public void printPreferences(){
        for(String vote : preferences){
            System.out.print(vote + "\t");
        }
        System.out.println("");
    }
    
}
