import java.lang.Character;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /** Text input **/
        String line = "no war but the class war";

        /** Tree Map to store the bigrams in an alphabetical order**/
        TreeMap<String, Integer> bigrams = new TreeMap<>();

        /** frequency to store how many times a bigram occurs **/
        int freq;

        /** variable to keep count of total number of bigrams **/
        int countBigram = 0;


        for (int i=0; i<line.length(); i++){
            //if we are at the last index of the input, break out of the loop
            if(i == line.length()-1)
                break;

            //if the current index is a space then skip that index
            if((int) line.charAt(i) == 32)
                continue;

            //if the current index is a character then,
            if( ((int) line.charAt(i) < 8192) && (Character.isLetter(line.charAt(i))) ){
                //if next index is space, skip this iteration
                if((int) line.charAt(i+1) == 32)
                    continue;

                /** if next index is a character then
                 * combine both indices and form a string i.e bigram
                 * add the bigram to the tree map
                 **/
                if(((int) line.charAt(i+1) < 8192) && (Character.isLetter(line.charAt(i+1))) ){
                    StringBuilder bigram = new StringBuilder(Character.toString(line.charAt(i)) + Character.toString(line.charAt(i+1)));
                    if(bigrams.containsKey(bigram.toString())){
                        freq = bigrams.get(bigram.toString());
                        bigrams.put(bigram.toString(),freq+1);
                    } else
                        bigrams.put(bigram.toString(),1);

                    //Incrementing total number of bigrams added into the map
                    countBigram++;

                }
            }
        }


        /** Getting the values of bigrams and their frequencies from Tree Map
         * Storing both of these values in 2 Object type arrays for ease of access
         **/
        Object[] keys = bigrams.keySet().toArray();         //array for storing all the keys to access via index
        Object[] values = bigrams.values().toArray();       //array for storing all the values to access via index



        double propFrequency = 0.0;
        int value;

        for (int i=0; i<bigrams.size(); i++){
            value = bigrams.get(keys[i].toString());            //get bigram at index i of the map
            propFrequency = (double) value / countBigram;       //calculate proportional frequency

            //print out all 3 items
            System.out.printf("%s \t %s \t %.10f\n", keys[i].toString(), values[i].toString(), propFrequency);
        }
    }
}


