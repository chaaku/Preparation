package Second_Inning;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.sound.sampled.ReverbType;

import TreePrograms.Reverse_order_traversal;

public class Solution {

    // Complete the electionWinner function below.
    static String electionWinner(String[] votes) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String str:votes){
            int count =0;
            if(map.containsKey(str))
                count = map.get(str);

            map.put(str, ++count);
        }

        int max =0;
        ArrayList<String> ar = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) 
                    max= entry.getValue();
        }
        
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                ar.add(entry.getKey());
        }
        Collections.sort(ar);
        return ar.get(ar.size()-1);
    }
  
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

    String []	votes = {"margan","margan","alex","morgan","morgan","mirgan","mirgan","alex","chadnan","chadnan","chkuadnan","kumar"};
        String res = electionWinner(votes);
        System.out.println(res);
    }
}
