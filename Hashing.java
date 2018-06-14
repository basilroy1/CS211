import java.util.*;

import java.math.BigInteger;
public class Hashing{

 public static void main (String[] args){
 Scanner myscanner = new Scanner(System.in);
 int items = myscanner.nextInt();
 myscanner.nextLine();
 String[] contents = new String[items];
 for(int i=0;i<items;i++){
 contents[i]=myscanner.nextLine();
 }
 HashTable mytable = new HashTable();
 Solution mysolution = new Solution(mytable);
 mysolution.fill(contents);
 mysolution = new Solution(mytable);
 for(int i=0;i<items;i++){
 int rand = (int)(Math.random()*items);
 String temp = contents[i];
 contents[i]=contents[rand];
 contents[rand]=temp;
 }
 for(int i=0;i<items;i++){
 int slot = mysolution.find(contents[i]);
 if(!mytable.check(slot,contents[i])){
 System.out.println("error!");
 }
 }
 System.out.println(mytable.gettotal());
 }
}


class HashTable{

 public int size = 99991;
 private String[] hashTable;
 private int total=0;
 public HashTable(){
 hashTable = new String[size];
 for(int i=0;i<size;i++){
 hashTable[i]="";
 }
 }
 public boolean check(int slot, String check){
 if(hashTable[slot].equals(check)){
 return true;
 }else{
 total++;
 return false;
 }
 }

 public void set(int slot, String word){
 hashTable[slot]=word;
 }

 public int gettotal(){
 return total;
 }
}


class Solution{

 HashTable table = new HashTable();
 static int size;
 public Solution(HashTable input){

        table = input;
        size = input.size;
 }

 public int find(String word){
 int index = getHashIndex(word);
 int doubleHashIndex = getDoubleHashKey(word);
        //While collide
        while(table.check(index, word) == false){
        	//Add the double hash jump size until you find word 
            index+= doubleHashIndex;
            index%= size;
        }
        return index;
 }

 public void fill(String[] array){ //fill this in using some hashing strategy
 //this should add all the words in the array into the
//HashTable
 	 for(int i=0; i<array.length;i++){
            int index = getHashIndex(array[i]);
            int doubleHash = getDoubleHashKey(array[i]);
            
            //While there are collisions
            while(table.check(index, "") == false){
            	// jump until a free slot is found
                index+=doubleHash;
                index=index%size;
            }
            
            table.set(index,array[i]);
         }

 }

 public static int getHashIndex(String word){
    	BigInteger a;
 		BigInteger b;
 		BigInteger power =new BigInteger("256");
 		BigInteger result =new BigInteger("0");
 		
 		
 		for(int i = 0; i < word.length(); i++){
 			a = new BigInteger(Integer.toString(word.charAt(i)));
 			b = power.pow(i);
 			result = result.add(a.multiply(b));	
 		}

 		
 		BigInteger tableSize = new BigInteger(Integer.toString(size));
 		result = result.mod(tableSize);
 		
 		return result.intValue();
    }
     public static int getDoubleHashKey(String word){
    	
         return (int)word.charAt(word.length()-1);
     }
   
 }
