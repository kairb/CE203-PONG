package Pong;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kairo on 08/12/2017.
 */

//deals with text file connection
public class TextParser {

    //constructor
    public TextParser(){
    }
    //adds new score to text file
    public void add(long survived){
        long currentTime = System.currentTimeMillis();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

        //writing time survived to scores

        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("scores.txt",true));
            out.write(String.valueOf(currentTime) + " ");
            out.write(String.valueOf(survived) + " ");
            out.write(dateFormat.format(date) + "\n");
            out.close();

        }catch(IOException e){
            System.out.println("error writing to file");
        }

    }

    //returns ordered vector of scores by time survived
    public Vector<Vector<String>> returnVector() {
        Vector<Vector<String>> all = new Vector<>();
        try{
            Scanner file = new Scanner(new File("scores.txt"));
            while(file.hasNext()){
                Vector<String> temp = new Vector<>();
                temp.add(file.next());
                temp.add(file.next());
                temp.add(file.next());
                temp.add(file.next());
                all.add(temp);
            }

        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        //sort vector by seconds survived
        Collections.sort(all, new Comparator<Vector<String>>(){
            @Override  public int compare(Vector<String> v1, Vector<String> v2) {
                return (Integer.valueOf(v2.get(1))).compareTo(Integer.valueOf(v1.get(1)));
                 }});

        //returns orderd vector
        return all;

    }
}

