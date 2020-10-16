import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cow {
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