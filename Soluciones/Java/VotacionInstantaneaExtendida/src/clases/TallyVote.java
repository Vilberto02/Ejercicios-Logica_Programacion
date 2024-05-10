package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author sanf_
 */
public class TallyVote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("votes.txt"));
        LinkedList<Ballot> ballots = readFile(input);
        int round = 1;
        boolean done = false;
        while(!done){
            System.out.println("Round #" + round);
            printBallotsPreferences(ballots);
            Collections.sort(ballots);
            done = onRound(ballots);
            System.out.println("----------------");
            round++;
        }
    }
    
    public static void printBallotsPreferences(LinkedList<Ballot> ballots){
        for(Ballot b: ballots){
            b.printPreferences();
        }
        System.out.println("----------------");
    }
    
    public static LinkedList<Ballot> readFile(Scanner input){
        LinkedList<Ballot> result = new LinkedList<>();
        String text;
        while(input.hasNextLine()){
            text = input.nextLine();
            if(text.isEmpty()){
                continue;
            }
            result.add(new Ballot(text.split("\t")));
        }
        return result;
    }
    
    public static boolean onRound(LinkedList<Ballot> ballots){
        String top = null;
        String bottom = null;
        int topCount = 0;
        int bottomCount = ballots.size() + 1;
        int index = 0;
        String next;
        int count;
        while(index < ballots.size()){
            next = ballots.get(index).getCandidate();
            count = processVotes(next,index,ballots);
            if(count > topCount){
                top = next;
                topCount = count;
            }
            if(count < bottomCount){
                bottom = next;
                bottomCount = count;
            }
            index += count;
        }
        
        if(topCount == bottomCount){
            System.out.println("Election has no winner");
            return true;
        }else if(topCount > ballots.size()/2.0){
            System.out.println("Winner is " + top);
            return true;
        }else{
            System.out.println("No winner, eliminating " + bottom);
            eliminate(bottom,ballots);
            return false;
        }
    }
    
    public static int processVotes(String name, int index, LinkedList<Ballot> ballots){
        int count = 0;
        while(index < ballots.size() && ballots.get(index).getCandidate().equals(name)){
            index++;
            count++;
        }
        double percent = 100.0 * count /  ballots.size();
        System.out.printf("%d votes for %s (%4.1f%%)\n",count,name,percent);
        return count;
    }
    
    public static void eliminate(String candidate, LinkedList<Ballot> ballots){
        for(Ballot b : ballots){
            b.eliminate(candidate);
            if(b.isEmpty()){
                ballots.remove(b);
            }
        }
    }
    
}
