
package assignment;
import java.util.Scanner;

/**
 * coin denomination sorter
 * @author      yin zhanpeng    address @ example.com
 * @version     1.0          (current version number of program)
 * Assignment 1
 * this program have functions that finds the coin value of the a person and display it, as well as 
 * providing a summary of all the coins in it 
 */

public class Helper {

    public Helper(){}
  
        public static int getInt(String msg){
            boolean carryOn = true;
            int n = 0;
            while(carryOn){
                System.out.println(msg);
                Scanner kb = new Scanner(System.in);
                if(kb.hasNextInt()){
                    n = kb.nextInt();
                    carryOn = false;
                }else{
                    System.out.println("please only enter integer ");
                }
            }
            return n;
        }

        public static String getString(String msg){
            System.out.println(msg);
            Scanner kb = new Scanner(System.in);
            String n = kb.nextLine();
            return n;
        }

        public static void println(String msg){
            System.out.println(msg);
        }


        public static void print(String msg){
            System.out.print(msg);
        }

        // check if the number is negative 
        public static boolean ngativenum(int num){
            return num<0;
        }
        
        // check if the value ia able to divide by 5
        public static boolean validateCoinInput(int number ){
            return number % 5 == 0;
        }
        
        //round off the value to the nearest 5
        public static int roundOffCoinValue(int number){
            int n;
            if (number % 5 > 2){
                n = number - (number % 5) + 5;
            }
            else {
                n = number - (number % 5);
            }

            return n;
        }
        
        // check if the name is more than one word
        public static boolean validateName(String name ){
            return (name.length()>0 && name.split("\\s+").length ==1);
        }

        // check fo dupliacted names
        public static boolean duplicateName(String name, String [] nameArray){
            // check fo dupliacted names if fupli name return false
          boolean carryOn = true;
          boolean dupli = true;
          while(carryOn){
              for(int i = 0; i <nameArray.length;i++){
                  if(nameArray != null){
                      if (name.equals(nameArray[i])){
                          dupli = false;
                          carryOn=false;
                      }

                    }
              }
              carryOn=false;
          }

           return dupli;
        }
        
        // testing 
        /*
        public static void main (String[] args){
            // testing 
            int test = getInt("please enter the int ");
            System.out.println(test);
            String tests = getString("please enter the string");
            System.out.println(tests);
            println("testing println");
            print("testing print");
            System.out.println(ngativenum(-50)); 
            System.out.println(validateCoinInput(3));
            System.out.println(roundOffCoinValue(3));
            System.out.println(validateName("john tim"));
            String [] name = {"tim","john", "tom", "katty"};
            System.out.println(duplicateName("katty", name));
            
            
            
        }*/
    
}
