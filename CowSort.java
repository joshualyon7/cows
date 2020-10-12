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
                //Cow newCow = new Cow( Integer.parseInt(line[0]), 
                //                        Action.valueOf(line[1]), 
                //                        Integer.parseInt(line[2]), 
                //                        Integer.parseInt(line[3]) );
                System.out.println("added cow #: [" + line[0] + "]");
                System.out.println("added cow #: [" + line[1] + "]");
                System.out.println("added cow #: [" + line[2] + "]");
                System.out.println("added cow #: [" + line[3] + "]");
                //cows.put(newCow.id, newCow);
                    
                //do string parsing logic to add/update cows
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}   
