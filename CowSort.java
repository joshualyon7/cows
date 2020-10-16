import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class CowSort {

    HashMap<Integer, Cow> cows = new HashMap<Integer, Cow>(); // cows mapped to their individual IDs
    
    public static void main(String[] args) {
        CowSort cs = new CowSort();
        cs.parseFile("records.txt");
        System.out.println(cs.cows);
    }

    // takes in a filename, scans in per line and parses the records either 
    // by updating an existing cow or creating a new cow to put in the map
    public void parseFile(String filename){
        ArrayList<String> strings = new ArrayList<String>();
        try (Scanner s = new Scanner(new File("records.txt")).useDelimiter("\n")){
            
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
        
    }
}   
