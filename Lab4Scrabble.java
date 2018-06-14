import java.util.*;
import java.io.*;
public class Lab4Scrabble{
    public static void main(String args[]) throws FileNotFoundException{
    
        Scanner file = new Scanner(new FileReader("dic.txt"));
        ArrayList<String> words = new ArrayList<String>();

        //Fills an array list with all the words in the dictionary
        while(file.hasNext())
            words.add(file.nextLine());

        //Reads in the letters and stores them in a char array
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your scrabble letters");
        String temp = scan.nextLine().replaceAll(" ", ",");
        System.out.println();
        char letters[] = temp.toCharArray();

        //Will store in an array list all the words that match the letters
        ArrayList<String> result = checkWords(words, letters);

        //Sorts those words in desending order of length 
        Collections.sort(result);
        //int size = Math.min(5, result.size());
int count=0;
        

        for(int i = 1; i < result.size(); i++){
            System.out.println(i+"."+result.get(i));
            count++;
        }
        System.out.printf("Here are the top "+count+" suggestions:\n");
    }

    //Checks all the words in the dictionary againt the letters entered
    public static ArrayList<String> checkWords(ArrayList<String> words, char[] letters) {
        ArrayList<String> result = new ArrayList<String>();

        //Calls checkString method on every word and adds word to list if it returns true
        for(int i = 0; i < words.size(); i++){
            boolean check = checkString(words.get(i), letters) ;
            if(check){
                result.add(words.get(i));
            }
        }
        return result;
    }

    //Checks a string against the letters given
    public static boolean checkString(String word, char[] letters){
        //Create a hashtable that will store each letter and it's frequency
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

        for(int i = 0; i < letters.length; i++){
            char temp = letters[i];

            //Increment the frequency of a leter if seen before by one
            if(table.get(temp) != null)
                table.put(temp, table.get(temp)+1);

            //If you've never seen the letter before insert 1 in to that slot in the hashtable
            else
                table.put(temp, 1);
        }

        //Loop through all the letters in the word you're checking to see if they're in the table
        for(int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);

            //Decrement a letter's frequency if you find it in the table
            if(table.get(temp) != null && table.get(temp) > 0)
                table.put(temp, table.get(temp)-1);
            else
                return false;
        }
        return true;

    }


}
