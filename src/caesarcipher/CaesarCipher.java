//Scott Weagley - Caesar Cipher Project for COMP 424
//Users must enter valid input for this cipher to work properly.
package caesarcipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CaesarCipher {

    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";        
        
        //Create object to accept user input
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            //Check for text to encode   
            System.out.println("Enter the text to cipher: ");
            String input = userInput.readLine();
            input = input.toLowerCase();
            
            //Get the offset value for encoding & convert it to a number
            System.out.println("Enter the number of bits to cipher");
            int k = userInput.read() - 48; 
            
            //Output information to the user
            System.out.println("Original Message \"" + input+ "\":");
            String encoded = code(input, alphabet, k, true);

            //Output the information to the user
            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + code(encoded, alphabet, k, false));        
        
        } catch (IOException e){
            System.out.println("An error has occured with your input. Exiting Program.");
        }
    }
    
    //Function to encode and decode
    //If encode is set to true then the function will use encode. Otherwise, it 
    //will use the decode function.
    static String code(String input, String alphabet, int k, boolean encode){
        String output = "";
        int index; 
        
        //If encode then run encode algorithm
        if(encode == true){
           for(int i = 0; i < input.length(); i++){
               if(input.regionMatches(i, " ", 0, 1)){
                output += " ";
               } else {                   
                index = alphabet.indexOf(input.charAt(i));
                output += alphabet.charAt((index + k) % 26);   
               }             
           }            
        } else { //Otherwise run decode algorithm
           for(int i = 0; i < input.length(); i++){
               if(input.regionMatches(i, " ", 0, 1)){
                output += " ";
               } else {                   
                index = alphabet.indexOf(input.charAt(i));
                if((index-k) < 0){
                    output += alphabet.charAt(alphabet.length() + ((index - k) % 26));
                } else {
                     output += alphabet.charAt((index - k) % 26);  
                }
               }             
           }                 
        }            
        return output;
    }   
}
