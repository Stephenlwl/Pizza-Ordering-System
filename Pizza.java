// import scanner
import java.util.*;

// crreate Pizza Class
public class Pizza {

    protected String pName; //display the pizza name/flavour
    protected int pCode; //display the pizz code

    public Pizza() {
        pName = "";
        pCode = 0;
    }

    public Pizza(String n, int c) {
        pName = n;
        pCode = c;

    }
    // create getter and setter for each variable
    public String getPName() {
        return pName;
    }

    public int getPCode() {
        return pCode;
    }

    public void setPName(String n) {
        pName = n;
    }

    public void setPCode(int c) {
        pCode = c;
    }
    
    // definePizzas method to store pizza code and name into the array of pizza
    public static void DefinePizzas(Pizza pizza[]) {

        pizza[0] = new Pizza("Blazing Seafood", 1);
        pizza[1] = new Pizza("Chicken Supreme", 2);
        pizza[2] = new Pizza("Hawaiian Supreme", 3);
        pizza[3] = new Pizza("Deluxe Cheese", 4);
        pizza[4] = new Pizza("Veggie Lover", 5);
        pizza[5] = new Pizza("Aloha Lover", 6);
        pizza[6] = new Pizza("Fourse Seasons Deluxe", 7);
        pizza[7] = new Pizza("Mushroom Supreme", 8);
    }

    // printPizzas method is to print out the pizza menu interface
    public static void printPizzas(Pizza pizza[]) {

        Pizza.DefinePizzas(pizza);
        printLine(" ", 10);
        System.out.print("<<Pizza Menu>>");
        System.out.println();
        printLine("-", 35);
        System.out.println();
        System.out.print("Code | Pizza Flavour");
        System.out.println();
        printLine("-", 35);
        System.out.println();
        for (Pizza p : pizza) {
            System.out.printf("%-5d [%-25s]\n", p.pCode, p.pName);
        }

        printLine("=", 35);
        System.out.println();

    }

    // return method is to promt user to enter the pizza code option then return the value 
    public static int optionPizza(int SIZE, int index) {

        Scanner sc = new Scanner(System.in);
        int option[] = new int[SIZE];
        
        do {
            System.out.print("Enter Option: ");
            option[index] = sc.nextInt();
            if (option[index] < 1 || option[index] > 8) {
                System.out.println("You have entered wrong Pizza Code! \nPlese Try Again......\n");
            }
            
        } while (option[index] < 1 || option[index] > 8);
                
        return option[index];
    }

    // create printLine method to customize each of the line when calling
    //String s= the symbol or pattern of the line
    // int l= the number of the symbol or pattern wanted to be displayed
    public static void printLine(String s, int l) {

        for (int i = 1; i < l; i++) {
            System.out.print(s);
        }
    }
    
    
}
