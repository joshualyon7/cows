import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cow {
    int id;
    int temp;
    int lowestWeight = 0;
    int latestWeight = 0;
    int milkings = 0;
    int avgMilk = 0;
    int totalMilk = 0;
    int latestMilking;

    //constructor
    public Cow(int ID, Action a, int val, int time) {
        id = ID;
        updateCow(a, val, time);
    }

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