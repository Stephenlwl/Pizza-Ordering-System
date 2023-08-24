//Group 2 Project
/* Group Members:   Lee Woei Liang
                    Ooi Hui San
                    Nur Amalina
                    Sean Alexander
*/

import java.io.File; //import file function
import java.io.FileWriter;  //to enable to write inside the txt file
import java.io.FileReader; //to enable to read inside the txt file
import java.io.BufferedWriter; //to enable to write inside the txt file
import java.io.BufferedReader; //to enable to read inside the txt file
import java.io.IOException; // to enable the function of exception to enable to check the error by using the try and check
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner; // to enable the users to key in data

public class Main_Page {

    public static void main(String args[]) {
        // call scanner
        Scanner sc = new Scanner(System.in);

        // to constant the important variable value 
        final double TAX = 0.05;  // Goverment tax 5%
        final int TOTAL_ID = 10;   // the maximum order id can be printed
        final int SIZE_PIZZA = 8;   // the total number of pizzas
        final int SIZE_PRICE = 4;   // the total number of each price and size of the pizzas

        String flavour[] = new String[SIZE_PIZZA];  //create flavour array to match the pizzaCode and pizzaFlavour  
        String alphabetSize[] = new String[SIZE_PRICE];   // store the converted the string size that has selected by user
        double total[] = new double[SIZE_PIZZA];  //calculate the price for each pizza which has selected by the user
        int tmp[] = new int[TOTAL_ID]; //store the previoud index number into this tmp array

        int option[] = new int[SIZE_PIZZA];     // store the selected pizza code by user
        int quantity[] = new int[SIZE_PRICE];   // store the entered quantity pizza number by user
        int storeOrderId[] = new int[TOTAL_ID]; // store each order ID
        int totalQuantity = 0;  // the total quantity of pizza has entered by user
        int selection = 0;  // the input of the main page section
        int index = 0;  // calculate the number of times the user has selected pizza code
        int storeCount = 0; // for counting the number of times the user has selected new order section
        String cont = " "; // input of the next pizza code

        Pizza pizza[] = new Pizza[SIZE_PIZZA];   //store each of the pizza flavour and pizza code

        //store each pizza's price and size
        Price p1[] = new Price[SIZE_PRICE];  //blazing seafood
        Price p2[] = new Price[SIZE_PRICE]; //chicken supreme
        Price p3[] = new Price[SIZE_PRICE]; //hawaiian supreme
        Price p4[] = new Price[SIZE_PRICE]; //deluxe cheese
        Price p5[] = new Price[SIZE_PRICE]; //veggie lover
        Price p6[] = new Price[SIZE_PRICE]; //aloha lover
        Price p7[] = new Price[SIZE_PRICE]; //fourse seasons deluxe
        Price p8[] = new Price[SIZE_PRICE]; //mushroom supreme

        // Order orderId[] = new Order[TOTAL_ID]; //store each times of the order id when, once the user has completed order
        // start to store the order history into Ordered Pizza.txt file
        File file = new File("Ordered Pizza.txt");

        //use if else to check the file existing or not
        if (!file.exists()) {
            try{
            file.createNewFile();
            }catch(IOException e){
                System.out.println("Unable to Create New File!");
            }
        }

        
        do { 
            try{
            //call the class order to return back the storeOrderId
            storeOrderId[storeCount] = Order.setOrderId(storeOrderId, storeCount, TOTAL_ID);

            // print out the main page then return the selection
            selection = printMainPage();

            //base on the user selection
            //use switch case to identify the main page section
            switch (selection) {
                // if selection is 1
                // create a do while loop to display each pizzas flavour and prompt user to enter the pizza code
                case 1 -> {
                    do {
                        try{
                        //import Pizza class to print out each pizzas flavour
                        Pizza.printPizzas(pizza);

                        // promt user to enter the option code then return back the option 
                        option[index] = Pizza.optionPizza(SIZE_PIZZA, index);
                        
                        }catch(InputMismatchException ex){
                            System.out.println("Invalid Code!");
                        }
                        // import Order class to match the pizza code that has enter by the user then, return back to string flavour variable array
                        flavour[index] = Order.matchCodePizza(option, pizza, index, flavour);

                        // import Pizza class then print out the specific and related pizza's size and price
                        // promt user to enter the option code of the size
                        Price.printPrice(SIZE_PRICE, option, index, pizza, p1, p2, p3, p4, p5, p6, p7, p8);

                        // import Price class to convert the integer size code into string then return back into new string alphaberSize array
                        alphabetSize[index] = Price.size(SIZE_PRICE, index, option);
                        
                        //create external do while loop 
                        //to keep looping when the total quantity more then 8
                        do {
                            //import Price class to prompt user to enter the number of quantity then,
                            //return back the value to store into the quantity array
                            quantity[index] = Price.quantity(SIZE_PIZZA, index, totalQuantity);

                            //import Price class to sum all the quantity then, return back to totalQuantity variable
                            totalQuantity = Price.totalQuantity(quantity, index, totalQuantity, SIZE_PIZZA);

                        } while (totalQuantity > 8);

                        // import Print class to calculate the price after selected the pizza size and entered the quantity of pizza
                        total[index] = Price.pizzaCost(SIZE_PIZZA, option, index, quantity, alphabetSize, p1, p2, p3, p4, p5, p6, p7, p8);

                        //increate the index value to store new data into each related array
                        index++;

                        // use if else to identity the current order can be continue or not
                        // if totalQuantity is less then 8
                        // the user allow to continue order or stop ordering
                        if (totalQuantity < 8) {

                            //use do while loop to keep looping when the user enter wrong input
                            // open internal do while loop
                            do {

                                // prompt user to enter cont variable
                                System.out.print("Do you want to continue order [Y/N]: ");
                                cont = sc.next();

                                // use  if else to  identify the cont variable is correct input or not
                                //if cont variable are not y or n
                                // system ill display the message
                                if (!"y".equalsIgnoreCase(cont) && !"n".equalsIgnoreCase(cont)) {
                                    System.out.println("You have entered wrong input... \n");
                                } // else if the cont variable is n
                                // system will print out the order receipt and store the order receipt into txt file
                                else if ("n".equalsIgnoreCase(cont)) {
                                    write(file, storeOrderId[storeCount], flavour, alphabetSize, total);
                                    Order.printOrder(storeOrderId[storeCount], flavour, alphabetSize, quantity, total, TAX, tmp, index);

                                    // set the totalQuantity to 0 before starting new order
                                    totalQuantity = 0;
                                }

                                //close internal do while loop
                                // keep looping when the cont variable are not y and n
                            } while (!"y".equalsIgnoreCase(cont) && !"n".equalsIgnoreCase(cont));
                            printLine("* ", 25);
                            System.out.println();

                        } // if the totalQuantity is more then 8 the system will straigh print out the order receipt
                        // to avoid the user continue order  
                        else {

                            // system will print out the order receipt and store the order receipt into txt file
                            write(file, storeOrderId[storeCount], flavour, alphabetSize, total);
                            Order.printOrder(storeOrderId[storeCount], flavour, alphabetSize, quantity, total, TAX, tmp, index);

                            // set the totalQuantity to 0 before starting new order
                            totalQuantity = 0;

                            // use break funtion to straigh return back to main page
                            break;
                        }

                        // close external do while loop
                        // keep looping when cont variable is y
                    } while ("y".equalsIgnoreCase(cont));

                    // pass the index value to tmp array to store the previous index value 
                    tmp[storeCount] = index;

                    // increate the storeCount number 
                    // to display new order id for each new order
                    storeCount++;

                    // set the index value to 0 before start new order
                    index = 0;

                }

                // if selection is 2
                case 2 -> {

                    // call Order class to display the specific order history
                    Order.inputOrderId(storeOrderId, flavour, alphabetSize, quantity, total, TAX, index, SIZE_PIZZA, storeCount, tmp);
                }

                // if selection is 3
                case 3 -> {

                    file = new File("pizza.txt");
                    try {
                        //call the file function

                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (IOException e) {
                        System.out.println("System can't find the text file");
                    }

                    // Read the existing pizza data
                    List<String> pizzaData = readPizzaData(file);

                    // Parse the existing data to extract pizza details
                    Map<String, List<String>> pizzaDetails = parsePizzaData(pizzaData);

                    // Prompt the user for new pizza details
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the name of the new pizza: ");
                    String newPizzaName = scanner.nextLine();
                    System.out.println("Enter the prices for each size started from P->R->L->XL");
                    System.out.print("[separated by commas]: ");
                    String[] newPizzaSizes = scanner.nextLine().split(",");

                    // Update the pizza details with the new pizza
                    pizzaDetails.put(newPizzaName, Arrays.asList(newPizzaSizes));

                    // Write the updated data back to the pizza.txt file
                    writePizzaData(pizzaDetails);
                    System.out.println("\nCongratulation!! You have Successfully added a New Pizza!\n");
                }

                // if selection is 4
                case 4 -> {
                    System.out.println("See you again! Bye bye....");

                }

                //if the selection input are not 1,2,3 and 4 will display the message
                default ->
                    System.out.println("Invalid option. Please try again.");

            }

        }catch(InputMismatchException Ex){
        System.out.println("Your input option doesn't match!");
        }    
            
            //keep looping when the selection is not 4
        } while (selection != 4);
    
 }

    // create a method call write to store the order receipt into text file
    //pass the parameters of file name, order id, pizza flavour, pizza size, pizza price
    // skip the ioexception for this method
    public static void write(File file, int id, String[] flavour, String[] size, double[] total){

        // call the fileWrite and bufferedWriter to write into text file
        try{
        FileWriter fw = new FileWriter(file.getName(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        // use for loop to store all the information into text file
        for (int i = 0; i < flavour.length; i++) {
            if (flavour[i] != null) {
                //store the slected pizza information into the text file
                bw.write(id + "\n");
                bw.write("Pizza Flavour: " + flavour[i] + "\n");
                bw.write("Size: " + size[i] + "\n");
                bw.write("Price: RM" + total[i] + "\n");
                bw.newLine();
            }
        }
        //close bufferedWriter
        bw.close();
        }catch(IOException e){
            System.out.println("Unable to Write In the Current File!");
        }
    }

    // create return int method call printMainPage 
    // to return back the selection and print out the main page interface
    public static int printMainPage() {

        Scanner sc = new Scanner(System.in);
        int selection = 0;

        // use printline method to print out customize line
        printLine("-", 40);
        System.out.println();
        printLine(" ", 10);
        System.out.println("Pizza Ordering System");
        printLine("-", 40);
        System.out.println();
        System.out.println("1 [Order Pizza   }");
        System.out.println("2 [View Order    ]");
        System.out.println("3 [Add New Pizza ]");
        System.out.println("4 [Exit          ]\n");
        System.out.print("Enter Option: ");
        selection = sc.nextInt();
        printLine("* ", 20);
        System.out.println();

        // return the user input selection value
        return selection;
    }
    
     public static List<String> readPizzaData(File file) {
        List<String> pizzaData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pizzaData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaData;
    }

    public static Map<String, List<String>> parsePizzaData(List<String> pizzaData) {
        Map<String, List<String>> pizzaDetails = new HashMap<>();
        for (String line : pizzaData) {
            String[] parts = line.split(",");
            String pizzaName = parts[0];
            List<String> pizzaSizes = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
            pizzaDetails.put(pizzaName, pizzaSizes);
        }
        return pizzaDetails;
    }

    public static void writePizzaData(Map<String, List<String>> pizzaDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pizza.txt"))) {
            for (Map.Entry<String, List<String>> entry : pizzaDetails.entrySet()) {
                String pizzaName = entry.getKey();
                List<String> pizzaSizes = entry.getValue();
                StringBuilder lineBuilder = new StringBuilder(pizzaName);
                for (String size : pizzaSizes) {
                    lineBuilder.append(",").append(size);
                }
                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }
    
    
    // create printLine method to customize each of the line when calling
    //String s= the symbol or pattern of the line
    // int l= the number of the symbol or pattern wanted to be displayed
    public static void printLine(String s, int l) {

        //use for loop to continue print out till reach the parameter of int l
        for (int i = 1; i < l; i++) {
            System.out.print(s);
        }
    }
}
