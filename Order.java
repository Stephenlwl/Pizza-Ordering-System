// import scanner
import java.util.Scanner;

//create Order sub Class from Super class Pizza
public class Order extends Pizza {

    protected int orderId;

    public Order(int id) {
        orderId = id;
    }

    public int getOrderID() {
        return orderId;
    }

    public void setOrderID(int id) {
        orderId = id;
    }

    // create return string method to match the code pizza with each pizza flavour name
    public static String matchCodePizza(int choice[], Pizza pizza[], int index, String flavour[]) {

        switch (choice[index]) {
            case 1 ->
                flavour[index] = pizza[0].getPName();
            case 2 ->
                flavour[index] = pizza[1].getPName();
            case 3 ->
                flavour[index] = pizza[2].getPName();
            case 4 ->
                flavour[index] = pizza[3].getPName();
            case 5 ->
                flavour[index] = pizza[4].getPName();
            case 6 ->
                flavour[index] = pizza[5].getPName();
            case 7 ->
                flavour[index] = pizza[6].getPName();
            case 8 ->
                flavour[index] = pizza[7].getPName();
        }

        return flavour[index];
    }

    // create printOrderLine to print out all selected pizza flavour, size , quantity and price
    public static void printOrderLine(String f[], String s[], int q[], double t[], int tmp[], int index) {
        String pizza[] = new String[f.length];

        for (int i = 0; i < index; i++) {
            pizza[i] = f[i] + "-" + s[i];

            // if pizza flavour is not null will continue printing
            if (f[i] != null) {
                System.out.printf("%-5d%-25s %10d %15.2f\n", i + 1, pizza[i], q[i], t[i]);
            }
        }
    }

    //create printOrder method to print out current order receipt
    public static void printOrder(int id, String f[], String s[], int q[], double t[], double TAX, int tmp[], int index) {

        double subTotal = 0.0, tax = 0.0, finalTotal = 0.0;
        String no = "No", flavour = "Pizza Flavour", quantity = "Quantity", total = "Total";
       
        //use calculateSubTotal return method to calculate the subTotal
        subTotal = calculateSubTotal(t, index);
        
        //use calculateTax return method to calculate the tax
        tax = calculateTax(TAX, subTotal);
        
        //use calculateTotal return method to calculate the total cost after adding up the tax and pizza prices
        finalTotal = calculateTotal(tax, subTotal);
        
        // convert the id to orderId variable
        int orderID = id;
        System.out.println();
        printLine("=", 60);
        System.out.println();
        printLine(" ", 20);
        System.out.println("\\Order Receipt/");
        System.out.printf("Order ID: P%-30d Date: ", orderID);
        
        // call the time.LocalDate.now to print the current date
        System.out.println(java.time.LocalDate.now());

        printLine("=", 60);
        System.out.println();

        System.out.printf("%-5s%-25s%12s%15s\n", no, flavour, quantity, total);
        printLine("-", 60);
        System.out.println();
        
        // call printOrderLine to print all the pizzas that the customer has ordered
        printOrderLine(f, s, q, t, tmp, index);
        printLine("-", 60);
        System.out.println();
        printLine(" ", 35);
        System.out.printf("SUB-TOTAL%14.2f\n", subTotal);
        printLine(" ", 35);
        System.out.printf("TAX (5%%)%15.2f\n", tax);
        System.out.println();
        printLine(" ", 35);
        System.out.printf("TOTAL (RM)%13.2f\n", finalTotal);
        printLine("-", 60);
        System.out.println();
    }
    
    // create printViewOrderLine to print out the specific history selected pizza flavour, size , quantity and price
    public static void printViewOrderLine(String f[], String s[], int q[], double t[], int tmp[], int index, int storeCount) {
        String pizza[] = new String[f.length];

        for (int i = 0; i < tmp[storeCount]; i++) {
            pizza[i] = f[i] + "-" + s[i];

            if (f[i] != null) {
                System.out.printf("%-5d%-25s %10d %15.2f\n", i + 1, pizza[i], q[i], t[i]);
            }
        }
    }
    
    // create printViewOrder to print out specific history receipt
    public static void printViewOrder(int id, String f[], String s[], int q[], double t[], double TAX, int tmp[], int index, int storeCount) {

        double subTotal = 0.0, tax = 0.0, finalTotal = 0.0;
        String no = "No", flavour = "Pizza Flavour", quantity = "Quantity", total = "Total";
        subTotal = calculateViewOrderSubTotal(t, tmp, storeCount);
        tax = calculateTax(TAX, subTotal);
        finalTotal = calculateTotal(tax, subTotal);

        java.time.LocalDate.now();
        int orderID = id;
        System.out.println();
        printLine("=", 60);
        System.out.println();
        printLine(" ", 20);
        System.out.println("\\Order Receipt/");
        System.out.printf("Order ID: P%-30d Date: ", orderID);
        System.out.println(java.time.LocalDate.now());

        printLine("=", 60);
        System.out.println();

        System.out.printf("%-5s%-25s%12s%15s\n", no, flavour, quantity, total);
        printLine("-", 60);
        System.out.println();
        printViewOrderLine(f, s, q, t, tmp, index, storeCount);
        printLine("-", 60);
        System.out.println();
        printLine(" ", 35);
        System.out.printf("SUB-TOTAL%14.2f\n", subTotal);
        printLine(" ", 35);
        System.out.printf("TAX (5%%)%15.2f\n", tax);
        System.out.println();
        printLine(" ", 35);
        System.out.printf("TOTAL (RM)%13.2f\n", finalTotal);
        printLine("-", 60);
        System.out.println();
    }

    // calculate the specific history of the order's sub total
    public static double calculateViewOrderSubTotal(double total[], int tmp[], int storeCount) {

        double subTotal = 0.0;

        for (int i = 0; i < tmp[storeCount]; i++) {
            subTotal += total[i];
        }

        return subTotal;
    }

    // for calculating current order's sub total
    public static double calculateSubTotal(double total[], int index) {

        double subTotal = 0.0;

        for (int i = 0; i < index; i++) {
            subTotal += total[i];
        }

        return subTotal;
    }

    // calculate tax
    public static double calculateTax(double TAX, double subTotal) {

        return subTotal * TAX;
    }

    // calculate total
    public static double calculateTotal(double tax, double subTotal) {

        return tax + subTotal;
    }

    // set the order id before start the new order
    public static int setOrderId(int storeOrder[], int storeCount,int SIZE) { //storecount
        int orderId= 0;
        
        switch (storeCount) {
            case 0:
                storeOrder[storeCount]=1001;
                break;
            case 1:
                storeOrder[storeCount]=1002;
                break;
            case 2:
                storeOrder[storeCount]=1003;
                break;
            case 3:
                storeOrder[storeCount]=1004;
                break;
            case 4:
                storeOrder[storeCount]=1005;
                break;
            default:
                break;
        }
            
        
       orderId= storeOrder[storeCount];     
        
        
        return orderId;

    }
    
    // create a inputOrderId method for the view order section
    public static void inputOrderId(int storeOrderId[], String f[], String s[], int q[], double t[], double TAX, int index, int SIZE, int storeCount, int tmp[]) {
        Scanner sc = new Scanner(System.in);

        //int i = 0; 
        int id= 0, storeId= 0;
        if (storeOrderId[0]==1001)
            storeCount=0;
        else if  (storeOrderId[1]==1002)
            storeCount=1;
        else if (storeOrderId[2]==1003)
            storeCount=2;
        
        do {
            // prompt user to enter order id
            System.out.print("Enter your Order ID: P");
            id = sc.nextInt();
            System.out.println("Wait a second.... \nCurrently Searching Your Order ID receipt history...\n");
            
            // if order id cant found, system will display a message
            if (id != storeOrderId[0] && id != storeOrderId[1] && id != storeOrderId[2]) {
                    System.out.println("Sorry! Your Order ID can't be found out...");
                    
                    // implement break fucntion to stop looping and return to main page
                    break;
            }
            else{
                // if the user's order id is existing
                // system will print out the related order receipt
                double subTotal = 0.0, tax = 0.0, finalTotal = 0.0;

                subTotal = calculateSubTotal(t, index);
                tax = calculateTax(TAX, subTotal);
                finalTotal = calculateTotal(tax, subTotal);
                printViewOrder(id, f, s, q, t, TAX, tmp, index, storeCount);
                break;
            }
            // keep looping when the user's order id not existing
        } while (id != storeId);

        

    }
}