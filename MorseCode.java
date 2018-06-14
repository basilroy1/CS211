import javax.sound.sampled.*;
import java.util.Scanner;
public class MorseCode{
	public static void main(String args[]) throws LineUnavailableException,InterruptedException{
Scanner scan = new Scanner(System.in);



String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"};
	
char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
  
    String textToChange = scan.nextLine();;
    String newText=new String("");
 
    
    textToChange = textToChange.toLowerCase();
      
    for (int i = 0; i < textToChange.length(); i++) {
      for (int j = 0; j < letters.length; j++) {
        if (textToChange.charAt(i) == letters[j]) {
          newText += morse[j]+" ";

         j=letters.length;
        
      }
      else if(j==35){
      	newText+=" ";
      }
  }
    }
    System.out.println(newText);

    for(int x=0; x<newText.length(); x++){
          if(newText.charAt(x)==('.')){
          	//System.out.print(newText+" ");
			tone(200,90,88);
          }
          else if(newText.charAt(x)==('-')){
        
          	tone(200,400,88);
          }
          else{
          	
          	Thread.sleep(1000);
          }
        }   
	}

public static void tone(int hz, int msecs, double vol) throws LineUnavailableException{
float SAMPLE_RATE = 8000f;
byte[] buf = new byte[1];
AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
sdl.open(af);
sdl.start();
for (int i=0; i < msecs*8; i++) {
double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
sdl.write(buf,0,1);
}
sdl.drain();
sdl.stop();
sdl.close();
}
}