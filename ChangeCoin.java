package assignment;

/**
 * coin denomination sorter
 * @author      yin zhanpeng    address @ example.com
 * @version     1.0          (current version number of program)
 * Assignment 1
 * this program have functions that finds the coin value of the a person and display it, as well as 
 * providing a summary of all the coins in it 
 */

public class ChangeCoin {
        /**
         * The customer name
         */
        private String name;
        /**
         * The customer changeCoinAmount
         */
        private int changeCoinAmount;
        /**
         * The array that will store all the change denomination in descending order
         */
        private int [] changeDenomination ={200, 100, 50, 10, 5};
        /**
         * The array that will store all the number of each change denomination in descending order
         */
        private int [] storingChangeDenomination = new int[100];
        
        /**
	 * Default constructor of ChangeCoin class                          
	 * <p>
	 * This class is used to set a default value for name and changeCoinAmount 
	 * </p>
	 * Precondition: Nil <br>
	 * Postcondition: name and changeCoinAmount is assign a default value of no name and 0
	 */
        public ChangeCoin(){
        this.storingChangeDenomination = new int[100];
            this.name = "no name";
            this.changeCoinAmount = 0;
        }
        
        /**
	 * Constructor of ChangeCoin class                          
	 * <p>
	 * This class is used to represent a ChangeCoin with name and changeCoinAmount
	 * </p>
	 * Precondition: Nil <br>
	 * Postcondition: this returns the name and changeCoinAmount of the ChangeCoin object
	 * @param  name name of ChangeCoin object
	 * @param  changeCoinAmount changeCoinAmount of ChangeCoin object     
	 */
        public ChangeCoin(String name, int changeCoinAmount){
        this.storingChangeDenomination = new int[100];
            this.name = name;
            this.changeCoinAmount = changeCoinAmount;
        }

        /**
	 * This method is used to display the name and changeCoinAmount of the ChangeCoin object                         
	 ** <p>
	 * Precondition - Name and changeCoinAmount is initialised at the Constructor <br>
	 * Postcondition - Display the name and changeCoinAmount of the ChangeCoin class
         * </p>
	 */        
        public void display(){
            System.out.println("Customer name : " + this.name);
            System.out.println("coin value : " + this.changeCoinAmount);
        }
                
        /**
	 * This method is used get name of the ChangeCoin onject                       
	 * <p>
	 * Precondition: Name is initialised at the Constructor <br>
	 * Postcondition: The name of the ChangeCoin object is returned.
	 * </p>   
	 * @return name Return the ChangeCoin object name      
	 */
        public String getName() {

            return name;
        }
        
        /**
	 * This method is used get getChangeCoinAmount of the ChangeCoin onject                       
	 * <p>
	 * Precondition: getChangeCoinAmount is initialised at the Constructor <br>
	 * Postcondition: The getChangeCoinAmount of the ChangeCoin object is returned.
	 * </p>   
	 * @return getChangeCoinAmount Return the ChangeCoin object name      
	 */
        public int getChangeCoinAmount() {
            return changeCoinAmount;
        }
        
        /**
	 * This method is used get set the Name of the ChangeCoin onject                       
	 * <p>
	 * Precondition: Nil <br>
	 * Postcondition: A new name is assign in the ChangeCoin object
         * </p>
         *  @param  name is the name that will be assign in the ChangeCoin object
	 */
        public void setName(String name) {
            this.name = name;
        }

        /**
	 * This method is used get set the setChangeCoinAmount of the ChangeCoin onject                       
	 * <p>
	 * Precondition: Nil <br>
	 * Postcondition: A new setChangeCoinAmount is assign in the ChangeCoin object.
         * @param  changeCoinAmount is the setChangeCoinAmount that will be assign in the ChangeCoin object
	 */
        public void setChangeCoinAmount(int changeCoinAmount) {
            this.changeCoinAmount = changeCoinAmount;
        }

        /**
	 * This method is used to add all the changeCoinAmount and display the total amount for each denomination                      
	 ** <p>
	 * Precondition - The coins array need to contain at least 1 value. <br>
	 * Postcondition - Display the total amount for each denomination
         * </p>
	 * @param  coins coin array that contains all the value of the changeCoinAmount
	 */
        public void addCoinChangeAmount(int [] coins){
            int [] newStoringChangeDenomination = new int[100];
            for(int x = 0; x < coins.length; x++){
                if(coins[x] != 0){
                    for(int i = 0; i < changeDenomination.length; i++){
                        newStoringChangeDenomination [i] = newStoringChangeDenomination [i] +(coins[x] / changeDenomination[i]);
                        coins[x] = coins[x] % changeDenomination[i];
                    }
                }
            }
            for (int i =0; i <changeDenomination.length;i++){
                if (newStoringChangeDenomination[i] != 0){
                    if (changeDenomination[i] > 99){
                        System.out.println(convertToDouble(changeDenomination[i]) /100 + " Dollar : " +(convertToDouble(newStoringChangeDenomination[i]) * convertToDouble(changeDenomination[i]) /100)+" dollars");
                    }else{
                        if((newStoringChangeDenomination[i] * changeDenomination[i])>99){
                            System.out.println(changeDenomination[i] + " cents : " +((convertToDouble(newStoringChangeDenomination[i])* convertToDouble(changeDenomination[i])) / 100)+" dollars");

                        }else{
                            System.out.println(changeDenomination[i] + " cents : " +changeDenomination[i]*newStoringChangeDenomination[i]+" cents");
                        }
                    }
                }
            } 
        } 

        /**
	 * This method is used get an integer to double so that the calculation is correct when displaying                      
	 * <p>
	 * Precondition: Only use for changeDenomination and newStoringChangeDenomination <br>
	 * Postcondition: Convert changeDenomination and newStoringChangeDenomination to a double value 
	 * </p>   
         * @param i only accept changeDenomination and newStoringChangeDenomination
	 * @return d Return the object changeDenomination and newStoringChangeDenomination      
	 */
        public double convertToDouble (int i){
            double d = i;
            return d;
        }

        /**
	 * This method is used to add all the changeCoinAmount and display the total number for each denomination                      
	 ** <p>
	 * Precondition - The coins array need to contain at least 1 value. <br>
	 * Postcondition - Display the total number for each denomination
         * </p>
	 * @param  coins coin array that contains all the value of the changeCoinAmount
	 */
        public void addCoinChangeNumber(int [] coins){
            int [] newStoringChangeDenomination = new int[100];
            for(int x = 0; x < coins.length; x++){
                for(int i = 0; i < changeDenomination.length; i++){
                    newStoringChangeDenomination [i] = newStoringChangeDenomination [i] +(coins[x] / changeDenomination[i]);
                    coins[x] = coins[x] % changeDenomination[i];
                }
            }
            for (int i =0; i <changeDenomination.length;i++){
                if (newStoringChangeDenomination[i] != 0){
                    if (changeDenomination[i] > 99){
                        System.out.println(convertToDouble(changeDenomination[i]) /100 + " Dollar : " +newStoringChangeDenomination[i]);
                    }else{
                        System.out.println(changeDenomination[i] + " cents : " +newStoringChangeDenomination[i]);
                    }
                }
            }   
        } 

        /**
	 * This method is used to display the total number of each denomination of the 1 changeCoinAmount object                      
	 ** <p>
	 * Precondition - The changeCoinAmount cannot be null <br>
	 * Postcondition - Display the total number for each denomination
         * </p>
	 * @param  changeCoinAmount that will be split into each denomination 
	 */
        public void coinChangeAmount(int changeCoinAmount){
            for(int i = 0; i < changeDenomination.length; i++){
                storingChangeDenomination[i] = changeCoinAmount / changeDenomination[i];
                changeCoinAmount = changeCoinAmount % changeDenomination[i];
                if (storingChangeDenomination[i] != 0){
                    if (changeDenomination[i] > 99){
                        System.out.println(convertToDouble(changeDenomination[i]) /100 + " Dollar : " +storingChangeDenomination[i]);
                    }else{
                        System.out.println(changeDenomination[i] + " cents : " +storingChangeDenomination[i]);
                    }
                }
            }
        }
}
    //Testing method
        
    /*
    public static void main (String[] args){
            ChangeCoin cc = new ChangeCoin();
            cc.display();
            ChangeCoin cc2 = new ChangeCoin("john",5);
            cc2.display();
            cc2.setName("tom");
            cc2.setChangeCoinAmount(90);
            cc2.display();
            int [] testing = {50,60,70,80,90};
            cc2.addCoinChangeAmount(testing);
            System.out.println(" ");
            cc2.coinChangeAmount(90);
        }
        

        */