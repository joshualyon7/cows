import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;


public class CowSort {

    HashMap<Integer, Cow> cows = new HashMap<Integer, Cow>(); // cows mapped to their individual IDs
    Vector<Cow> sortedCows = new Vector<Cow>();
    
    public static void main(String[] args) {
        CowSort cs = new CowSort();
        Scanner si = new Scanner(System.in);
        String inputFile = si.nextLine();
        cs.parseFile(inputFile);
        
        
        cs.sortCows(cs.cows);
        for(Cow c : cs.sortedCows){
            System.out.println(c);
        }
    }

    // takes in a filename, scans in per line and parses the records either 
    // by updating an existing cow or creating a new cow to put in the map
    public void parseFile(String filename){
        ArrayList<String> strings = new ArrayList<String>();
        try (Scanner s = new Scanner(new File(filename)).useDelimiter("\n")){
            s.nextLine();
            while(s.hasNext()){ //loop through all records
                String curStr = s.next();
                strings.add(curStr);
                String [] line = curStr.split(" ");
                int id, value, time;
                
                //new cow variables
                id = Integer.parseInt(line[0].trim());
                Action action = Action.valueOf(line[1].trim());
                value = Integer.parseInt(line[2].trim());
                time = Integer.parseInt(line[3].trim());

            
                if(!cows.containsKey(id)){ //if cow doesn't exist, create it and put it in the map
                    Cow newCow = new Cow(id, action, value, time);
                    cows.put(newCow.id, newCow);
                }
                else{ //otherwise, update the existing cow
                    cows.get(id).updateCow(action, value, time);
                } 
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //sorts the cows
    public void sortCows(HashMap<Integer, Cow> cows){
        for(Integer k : cows.keySet()){
            Cow current = cows.get(k);
            if(current.avgMilk != 0 && current.lowestWeight != 0){
                sortedCows.add(current);
            }
        }
        Collections.sort(sortedCows);
    }
}   

class Cow implements Comparable<Cow>{
    int id; // unique id for a cow (used for the hashmap)
    int temp; // latest temperature of a cow
    int lowestWeight = 0; // lowest weight recorded 
    int latestWeight = 0; // latest weight recorded
    int milkings = 0; // number of milkings
    int avgMilk = 0; // average milk produced 
    int totalMilk = 0; //running total of all milkings
    int latestMilking; // time of the latest milking

    // constructor
    public Cow(int ID, Action a, int val, int time) {
        id = ID;
        updateCow(a, val, time);
    }

    // prints a cow record in the intended output format:
    // "id lowestWeight latestWeight avgMilk"
    public String toString(){
        return(id + " " + lowestWeight + 
                " " + latestWeight + " " + avgMilk);
    }

    public int compareTo(Cow c2){
        if(lowestWeight == c2.lowestWeight){
            if(latestWeight == c2.latestWeight){
                if(avgMilk == c2.avgMilk){
                    return 0;
                }
                else{
                    return avgMilk < c2.avgMilk ? -1 : 1;
                }
            }
            else{
                return latestWeight < c2.latestWeight ? -1 : 1;
            }
        }
        else{
            return lowestWeight < c2.lowestWeight ? -1 : 1;
        }
    }

    /* <update functions> */
    public void updateCow(Action a, int val, int time){
        switch(a){
            case W :
                updateWeight(val, time);
                break;
            case M :
                updateMilk(val, time);
                break;
            case T :
                updateTemp(val, time);
                break;
            default:
                break;
        }
    }

    public void updateMilk(int val, int time){
        milkings++;
        totalMilk += val;
        avgMilk = totalMilk/milkings;
        latestMilking = time;
    }

    public void updateWeight(int val, int time){
        if(lowestWeight != 0 && val < lowestWeight){
            lowestWeight = val;
        }
        else if(lowestWeight == 0){
            lowestWeight = val;
        }
        latestWeight = val;
    }

    public void updateTemp(int val, int time){
        temp = val;
    }
    /* </update functions> */

    /* <getters> */
    public int getId() {
        return id;
    }

    public int getTemp() {
        return temp;
    }

    public int getLowestWeight() {
        return lowestWeight;
    }

    public int getLatestWeight() {
        return latestWeight;
    }

    public int getMilkings() {
        return milkings;
    }

    public int getAvgMilk() {
        return avgMilk;
    }

    public int getTotalMilk() {
        return totalMilk;
    }

    public int getLatestMilking() {
        return latestMilking;
    }
    /* </getters> */

}

enum Action {
    W, M, T;
}
