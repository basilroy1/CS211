import java.util.Arrays;
import java.util.Scanner;
class QuickSortStrings {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
     int num=scan.nextInt();
   String x[]=new String[num];
   for(int i=0;i<x.length;i++){
     x[i]=scan.next();
   }
   int low=0;
   int high=x.length-1;

  quicksort(x,low,high);
    for(String c: x){

    System.out.println(c); 
}

// System.out.println(Arrays.toString(x));
  
  }

public static char greatestChar(String c){
char w = c.charAt(0);

for(int i = 1; i<c.length(); i++)
if(c.charAt(i) > w)
w = c.charAt(i);

return w;
}

public static boolean compare(String s1, String s2){
char p = greatestChar(s1);
char p2 = greatestChar(s2); 

if(p==p2){
  
if(s2.compareTo(s1)>0)//alphabetically
return true;

return false;
}

else return p<=p2; 
}

  public static void quicksort(String array[],int low,int high){
    if(array==null||array.length==0){
      return;
    }
    if(low>=high){
      return;
    }
    
    String pivot=array[low+(high-low)/2];
   int i=low;
   int j=high;
    while(i<=j){
      while(compare(array[i],pivot)){

        i++;
      }
      while(compare(pivot,array[j])){
        j--;
      }
      if(i<=j){
        String temp=array[i];//swapping take place
        array[i]=array[j];
        array[j]=temp;
        i++;
        j--;
      }
    }
    if(low<j){
      quicksort(array,low,j);
    }
    if(high>i){               ////recursive call on both sides of array
      
      quicksort(array,i,high);
    }
  }
}

