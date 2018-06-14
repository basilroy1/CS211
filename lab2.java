import java.io.*;
import java.util.Scanner;

	public class lab2{
	public static void main(String args[]) throws IOException{
	//BufferedReader q = new BufferedReader(new InputStreamReader(System.in));
	//BufferedWriter y = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner scan = new Scanner(System.in);
	String s = scan.nextLine();
	int x=0 ,c=1;
	String array []= new String[256];
	long start=System.currentTimeMillis();

	for(int i=0;i<s.length();i++){
		x=(int)s.charAt(i);
		
		if (Integer.toBinaryString(x).length()<7){
			array[i]="0"+Integer.toBinaryString(x);	///checks for less than 7 digits then addsd 0 if less than 7
			System.out.print(" "+array[i]);
			
			//y.write(" "+array[i]);

		}
		else{

			array[i]=Integer.toBinaryString(x); //prints string to binary string
			System.out.print(" "+array[i]);
		//	y.write(" "+array[i]);
		}
		

		}

	String temp="";

	for(int i=0;i<s.length();i++){
		for(int j=0;j<s.length()-1;j++){
			if((Integer.parseInt(array[j],2))>(Integer.parseInt(array[j+1],2))){
				temp=array[j+1];
				array[j+1]=array[j]; /// bubble sorting binary string
				array[j]=temp;
			}

		}
	}
	System.out.println();
		//y.write("\n");

	char f;
	for(int i=0;i<s.length();i++){

	f=(char)Integer.parseInt(array[i],2);	//checks if char appeared in the sentcence and counts it
	if(array[i].equals(array[i+1])){
		c++;
	}
	else {
		if(c==1){
		System.out.println("'"+f+"'"+" appeared "+c+ " time");
		//y.write("'"+f+"'"+" appeared "+c+ " time"+"\n");	
		//b.append("'"+f+"'"+" appeared "+c+ " time");
		}
		else{
			//b.append("'"+f+"'"+" appeared "+c+ " times");
		System.out.println("'"+f+"'"+" appeared "+c+ " times");
			//y.write("'"+f+"'"+" appeared "+c+ " times"+"\n");
		c=1; //resets to 1 at the end.
	}
 }

}
//y.flush();
	System.out.println("Took "+(System.currentTimeMillis()-start)+" milli seconds");
}

}


	
	



