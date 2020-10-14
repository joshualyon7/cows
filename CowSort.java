import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class CowSort {

    HashMap<Integer, Cow> cows = new HashMap<Integer, Cow>();
    
    

    public static void main(String[] args) {
        CowSort cs = new CowSort();
        cs.parseFile("records.txt");
        System.out.println(cs.cows);
    }

    public void parseFile(String filename){
        ArrayList<String> strings = new ArrayList<String>();
        try (Scanner s = new Scanner(new File("records.txt")).useDelimiter("\n")){
            
            while(s.hasNext()){
                String curStr = s.next();
                strings.add(curStr);
                String [] line = curStr.split(" ");
                int id, value, time;

                //new cow variables
                id = Integer.parseInt(line[0].trim());
                Action action = Action.valueOf(line[1].trim());
                value = Integer.parseInt(line[2].trim());
                time = Integer.parseInt(line[3].trim());

                if(!cows.containsKey(id)){
                    Cow newCow = new Cow(id, action, value, time);
                    cows.put(newCow.id, newCow);
                }
                else{
                    cows.get(id).updateCow(action, value, time);
                }
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}   
