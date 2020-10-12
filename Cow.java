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
    double lowestWeight;
    double latestWeight;
    int milkings = 0;
    double avgMilk;
    double totalMilk = 0;
    int latestMilking;

    public Cow(int ID, Action a, double val, int time) {
        id = ID;
        switch(a){
            case W :
                lowestWeight = val;
                latestWeight = val;
                break;
            case M :
                milkings++;
                totalMilk = val;
                avgMilk = val;
                latestMilking = time;
                break;
            case T :
                break;
            default:
                break;
        }
    }

    public String toString(){
        return("cow # " + id + ", lowest weight: " + lowestWeight + 
                ", latest weight: " + latestWeight + ", avg milk: " + avgMilk + 
                ", total milk: " + totalMilk + ", latest milking: " + latestMilking);
    }



    



}