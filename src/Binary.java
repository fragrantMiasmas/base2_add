
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */
public class Binary {

    int new_base = 2;
       
//    public char int2char(int base10num){ //reverses above process
//        if(base10num >=0 && base10num <= 9){
//            return(char)(base10num + 48); //returns digits 0-9
//        }
//        else{
//            return(char)(base10num + 55); //returns a letter
//        }
//     }
//    
    public int char2int(char input){ //char to ascii
         
         int ascii = (int) input;
         if(ascii >= 48 && ascii <= 57)
            ascii = ascii - 48; //only accounts for digits 0-9
            
         else if(ascii >= 65 && ascii <= 90){
             ascii = ascii - 55; //capitol letters
         }
         else
             System.out.println("Out of range!");
         return ascii;
    }   
    
    //bc ruehr said not to use math.pow
    public int maxInt(int n){
         // if n=8, can have ints up to 127 bc 2^(n-1) -1
        int maxInt = 2;
        for(int i=1; i < n-1; i++){
            maxInt = maxInt*2;
        }
         maxInt = maxInt-1;
        return maxInt;
    }
    
    public int minInt(int n){
         // if n=8, can have ints down to -127 bc -2^(n-1) 
        int minInt = 2;
        for(int i=1; i < n-1; i++){
            minInt = minInt*2;
        }
        minInt = -minInt;
        return minInt;
    }
    
     public int twosCompliment(int user_number){ //for negative user numbers       
        int positiveCompliment = (user_number - 2*(user_number))-1; //ex -9 -->8
        return(positiveCompliment);
    }
     
    public boolean trueFalse(int remainder){
        return remainder == 1;
    }
    
   
    //use arrays
    public boolean[] BoolArray(int middleman, int n) { //goes to base 2
        boolean[] TF = new boolean[n];
        
        //divide method
        int remainder = middleman % new_base;
        TF[n-1]= trueFalse(remainder); //start at end of array
        
        int semi_quotient = (middleman - remainder) / new_base;
        
        int i = n-2;
        while (semi_quotient != 0) {

            remainder = semi_quotient % new_base; // until your semi quotient reaches zero
            TF[i]= trueFalse(remainder);
            i--;
            semi_quotient = (semi_quotient - remainder) / new_base;

        }
       return TF;
    }
    
    
    public boolean[] invert(boolean[] BoolArray, int n){
        boolean[] twoComplimentA = new boolean[n];
        
        for(int i = 0; i<BoolArray.length;i++ ){
            twoComplimentA[i] = !BoolArray[i]; 
        }
        return twoComplimentA;
    }
   
    public StringBuilder boolean2String(boolean[] BoolArray, int n){
        
        StringBuilder boolString = new StringBuilder();
        for(int i =0; i<n; i++){
            char boolInt = (BoolArray[i]) ? '1' : '0';
            boolString.append(boolInt);
        }
      
        return boolString;
    }
       
     public boolean[] carryArray(boolean[] firstByte, boolean[] secondByte, int n) { 
        
        boolean[] carryByte = new boolean[n];
       
        for (int i = n-1; i > 0; i--) { //start at end
            //compare to element i of second byte
            if(firstByte[i] && secondByte[i] && i<= n-1){ // both ones
                carryByte[i-1] = true; //two ones returns a carry in the next spot over 
            }
            else{ //has two ones
                if(i<n-1)
                 carryByte[i-1] = false; //not two ones returns a zero 
            }
            
        }
        return carryByte;
    }
     
     public StringBuilder finalresult(boolean[] firstByte, boolean[] secondByte, boolean[] carryByte){
         
         boolean[] result = new boolean[firstByte.length];
         
         for (int i = firstByte.length-1; i >0; i--) { //start at end
             //logic here
             
             if( firstByte[i]){ 
                 result[i] = (secondByte[i] ^ carryByte[i]); //xor 
             }
             else
                 result[i] = (secondByte[i] ==  carryByte[i]);
         }
         StringBuilder finalresult = boolean2String(result, result.length);
         return finalresult;
     }
     
     //pass in result array in
      public int toBase10(StringBuilder base2num){ //multiply add method
        
        //start with first digit
        int total = 0;
        int old_base = 2;
        for(int i = 0; i< base2num.length(); i++){
            total = total * old_base + char2int(base2num.charAt(i));
        }
        return(total); //total becomes new middleman
    }
 
}
