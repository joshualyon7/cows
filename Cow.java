import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cow {
    int id;
    double temp;
    double lowestWeight = 0;
    double latestWeight = 0;
    int milkings = 0;
    double avgMilk = 0;
    double totalMilk = 0;
    int latestMilking;

    //constructor
    public Cow(int ID, Action a, double val, int time) {
        id = ID;
        updateCow(a, val, time);
    }

    public String toString(){
        return("cow # " + id + ", lowest weight: " + lowestWeight + 
                ", \nlatest weight: " + latestWeight + ", \navg milk: " + avgMilk + 
                ", \ntotal milk: " + totalMilk + ", \nlatest milking: " + latestMilking + 
                "\ntemperature: " + temp + "\n");
    }

    /* <update functions> */
    public void updateCow(Action a, double val, int time){
        System.out.println("calling update cow on: " + id);
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

    public void updateMilk(double val, int time){
        milkings++;
        totalMilk += val;
        avgMilk = totalMilk/milkings;
        latestMilking = time;
    }

    public void updateWeight(double val, int time){
        if(lowestWeight != 0 && val < lowestWeight){
            lowestWeight = val;
        }
        else if(lowestWeight == 0){
            lowestWeight = val;
        }
        latestWeight = val;
    }

    public void updateTemp(double val, int time){
        temp = val;
    }
    /* </update functions> */

    /* <getters> */
    public int getId() {
        return id;
    }

    public double getTemp() {
        return temp;
    }

    public double getLowestWeight() {
        return lowestWeight;
    }

    public double getLatestWeight() {
        return latestWeight;
    }

    public int getMilkings() {
        return milkings;
    }

    public double getAvgMilk() {
        return avgMilk;
    }

    public double getTotalMilk() {
        return totalMilk;
    }

    public int getLatestMilking() {
        return latestMilking;
    }
    /* </getters> */

}