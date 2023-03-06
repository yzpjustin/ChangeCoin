package assignment;

import assignment.ChangeCoin;


/**
 * coin denomination sorter
 * @author      yin zhanpeng    address @ example.com
 * @version     1.0          (current version number of program)
 * Assignment 1
 * this program have functions that finds the coin value of the a person and display it, as well as 
 * providing a summary of all the coins in it 
 */

public class Client {
    
    /**
     * The change coin array
     */
    private static ChangeCoin[] changeArray;

    /**
     * will be use to run the whole program
     */
    public static void run(){
        //body
        changeArray = new ChangeCoin[100];
        initData();
        printMenuAndGetChoice();
    }
    
    /**
     * constructor
     */
    public Client(){}

    // allow the clients to choose between testing data or enter the name n coin amount
    private static void initData(){
        boolean carryOn = true;
        OUTER:
        while (carryOn) {
            String choice = Helper.getString("Please enter number \n1 for Load from hardcode \n2 for Enter by user ");
            switch (choice) {
                case "1" -> {
                    initArrayByHardCode();
                    break OUTER;
                }
                case "2" -> {
                    initArrayByUser();
                    break OUTER;
                }
                default -> Helper.println("INvalid choice, Please only enter the number 1 or 2");
            }
        }

    }   
        
    // testing data 
    private static void initArrayByHardCode(){
        changeArray[0] = new ChangeCoin("A",85);
        changeArray[1] = new ChangeCoin("B",185);
        changeArray[2] = new ChangeCoin("C",285);
        changeArray[3] = new ChangeCoin("D",385);
        changeArray[4] = new ChangeCoin("E",485);
        changeArray[5] = new ChangeCoin("F",585);
        changeArray[6] = new ChangeCoin("G",685);
        changeArray[7] = new ChangeCoin("H",785);
        changeArray[8] = new ChangeCoin("I",885);
        changeArray[9] = new ChangeCoin("J",985);
        printChangeArray();
    }

    // this method will  let the users enter the names and coinamount for each person
    private static void initArrayByUser(){
        Helper.println("Recommendation: Please enter at least 10 records to test the program");
        boolean carryOn = true;
        boolean carryOn2 = true;       
        int count = 0;
        while (carryOn){           
            changeArray[count] = new ChangeCoin(nameChecked(),coinChecked());
            count++;
            carryOn2 = true;
            while(carryOn2){
                if(count >= 1 && carryOn2){
                    String option = Helper.getString("Do you have more person to enter (Y/N): ").toLowerCase();
                    switch(option){
                        case "y" -> {
                            carryOn2 = false;
                        }
                        case "n" -> {
                            carryOn2 = false;
                            carryOn = false;
                        }
                        default -> Helper.println("INvalid choice");
                    }
                }
            }            
        }        
    } 
                
    // this method will give the client options 
    private static void printMenuAndGetChoice(){        
        boolean carryOn = true;
        while(carryOn){
            printMenu();
            String choice = Helper.getString("please enter only options 1 to 6, 6 is to quit");
            switch(choice){
                case "1" -> findNameAndDisplayChangeDenomination();
                case "2" -> findNameWithLargestAmountAndDisplayChangeDenomination();
                case "3" -> findNameWithSmallestAmountAndDisplayChangeDenomination();
                case "4" -> displayTotalNumOfCoinsForEachDenomination();
                case "5" -> displayTotalAmountForEachDenomination();
                case "6" -> {carryOn = false; Helper.println("Thank you, have a good day. bye bye ");}
                default -> System.out.println("INvalid choice, Please only enter the number 1-6");
            }
        }
    }    
    
    // a list of methods to call for each of the respective functions     
    private static void findNameAndDisplayChangeDenomination(){
        findname();
    }  
    
    private static void findNameWithLargestAmountAndDisplayChangeDenomination(){
        findlargest();
    }  
    
    private static void findNameWithSmallestAmountAndDisplayChangeDenomination(){
        findsmallest();        
    }  
    
    private static void displayTotalNumOfCoinsForEachDenomination(){
        totalNumberOfEachCoin();
    }  
    
    private static void displayTotalAmountForEachDenomination(){
        totalAmountOfEachCoin();        
    }    
    
    // this method will add up all the amount of each denomiation then display their value
    private static void totalAmountOfEachCoin(){        
        int [] coin = new int[changeArray.length];
        for (int i = 0; i < changeArray.length; i++){
            if(changeArray[i]!=null){
                coin[i] = changeArray[i].getChangeCoinAmount();
            }
            else{
                coin[i] = 0;
            }
        } 
       changeArray[0].addCoinChangeAmount(coin);        
    }

    // this method will find the toal numer of all the denomination and display it 
    private static void totalNumberOfEachCoin(){        
        int [] coins = new int[changeArray.length];
        for (int i = 0; i < changeArray.length; i++){
            if(changeArray[i]!=null){
                coins[i] = changeArray[i].getChangeCoinAmount();
            }
            else{
                coins[i] = 0;
            }
        } 
       changeArray[0].addCoinChangeNumber(coins);        
    }
    
    // this method will largest coin amount customer and dispay thie demoniation 
    private static void findlargest(){
        int largest = changeArray[0].getChangeCoinAmount();
        for (ChangeCoin changeArray1 : changeArray) {
            if (changeArray1 != null) {
                if (largest < changeArray1.getChangeCoinAmount()) {
                    largest = changeArray1.getChangeCoinAmount();
                }   
            }
        }
        for (ChangeCoin changeArray1 : changeArray) {
            if (changeArray1 != null) {
                if (largest == changeArray1.getChangeCoinAmount()) {
                    changeArray1.display();
                    changeArray1.coinChangeAmount(changeArray1.getChangeCoinAmount());
                }
            }
        }
    }
    
    // this method will smallest coin amount customer and dispay thie demoniation 
    private static void findsmallest(){
        int smallest = changeArray[0].getChangeCoinAmount();
        for(int i = 0; i < changeArray.length; i ++){
            if(changeArray[i]!=null){
                if(smallest > changeArray[i].getChangeCoinAmount()){
                    smallest = changeArray[i].getChangeCoinAmount();                   
                }   
            }
        }
        for(int i = 0; i < changeArray.length; i ++){
            if(changeArray[i]!=null){
                if(smallest == changeArray[i].getChangeCoinAmount() ){
                    changeArray[i].display();
                    changeArray[i].coinChangeAmount(changeArray[i].getChangeCoinAmount());
                }
            }
        }
    }   

    // this method will find the name of the customer 
    private static void findname(){
        String name = Helper.getString("Please enter the customer name");
        for(int i = 0; i < changeArray.length; i ++){
            if (changeArray[i]!= null){ 
                if (name.equals(changeArray[i].getName())){
                    changeArray[i].display();
                    changeArray[0].coinChangeAmount(changeArray[i].getChangeCoinAmount());
                    break;
                }
            }else
            {
            System.out.println("Name: "+ name);
            Helper.println("Not Found ");
            break;
            }
 
        }        
    }

    // using the helper class validea name and duplicate name this method ensure that only valid name is stored
    private static String nameChecked(){        
        boolean carryOn = true;        
        String name = Helper.getString("Please enter the name of the person: " );
        String [] storeName = new String [changeArray.length];
        for(int i = 0; i <changeArray.length;i++){
            if(changeArray[i] != null){
                storeName[i] = changeArray[i].getName();
            }
        }
        while(carryOn){           
            if (Helper.validateName(name) && Helper.duplicateName(name,storeName)){
                carryOn = false;
            }
            if(!(Helper.validateName(name))){
                Helper.println("Names are one-word strings. Please enter the name again");
                name = Helper.getString("Please enter the name of the person: " );
            }
            if(!(Helper.duplicateName(name,storeName))){
                Helper.println("Error!! Please make sure that you dont enter the same name ");
                name = Helper.getString("Please enter the name of the person: " );
            }            
        }        
        return name;
    }

    // using the helper class validate coin value and round off coin value this will return the coin value that is devible by 5 
    private static int coinChecked(){
        boolean carryOn = true;
        boolean carryOn2 = true;  
        int coinValue = 0;
        while (carryOn2){
            coinValue = Helper.getInt("Please enter the coin value for the person: " );
            if (!(Helper.ngativenum(coinValue))){
                while (carryOn){
                    if(Helper.validateCoinInput(coinValue)){                        
                        carryOn = false;
                        carryOn2 = false;
                    }else{
                        coinValue = Helper.roundOffCoinValue(coinValue);
                        carryOn = false;
                        carryOn2 = false;
                    }
                }
            }else {
                Helper.println("please do not enter a negative number ");                
            }
        }        
        return coinValue;
    }
    
    // print out the menu
    private static void printMenu(){
        Helper.println("1.	Enter a name and display change to be given for each denomination ");
        Helper.println("2.	Find the name with the largest amount and display change to be given for each denomination ");
        Helper.println("3.      Find the name with the smallest amount and display change to be given for each denomination ");
        Helper.println("4.	Calculate and display the total number of coins for each denomination ");
        Helper.println("5.	Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations ");
        Helper.println("6.	Exit");        
    } 

    // print out the change coin amount for each denomiation for that person
    private static void printChangeArray(){
        for(int i=0;i<changeArray.length;i++){
            if(changeArray[i]!=null){
            //System.out.println(changeArray[i]);
            changeArray[i].display();
            }
        }
    }    
}
