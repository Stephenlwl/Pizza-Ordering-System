// import Scanner

import java.util.Scanner;

//create Price sub Class from Super class Pizza
public class Price extends Pizza {

    protected int optionSize;   // int sizeOption (input by user)
    protected String pSize;    //create String pSize for the purpose of converting the int OptionSize variable
    protected double pPrice;  // double pPrice= pizza Price

    public Price(int oSize, String size, double price) {
        optionSize = oSize;
        pSize = size;
        pPrice = price;

    }

    //create getter and setter
    public int getOptionSize() {
        return optionSize;
    }

    public String getPSize() {
        return pSize;
    }

    public double getPPrice() {
        return pPrice;
    }

    public void setOptionSize(int oSize) {
        optionSize = oSize;
    }

    public void setPSize(String size) {
        pSize = size;
    }

    public void setPPrice(double price) {
        pPrice = price;
    }

    // create priceDefine method to store the specific prices and sizes into specific pizzas array
    public static void priceDefine(Price p1[], Price p2[], Price p3[], Price p4[], Price p5[], Price p6[], Price p7[], Price p8[]) {

        p1[0] = new Price(1, "Personal", 8.9);
        p1[1] = new Price(2, "Regular", 16.0);
        p1[2] = new Price(3, "Large", 26.0);
        p1[3] = new Price(4, "XLarge", 36.0);

        p2[0] = new Price(1, "Personal", 10.0);
        p2[1] = new Price(2, "Regular", 18.0);
        p2[2] = new Price(3, "Large", 30.0);
        p2[3] = new Price(4, "XLarge", 40.0);

        p3[0] = new Price(1, "Personal [N/A]", 0);
        p3[1] = new Price(2, "Regular", 17.5);
        p3[2] = new Price(3, "Large", 28.8);
        p3[3] = new Price(4, "XLarge", 38.0);

        p4[0] = new Price(1, "Personal", 8.5);
        p4[1] = new Price(2, "Regular", 15.0);
        p4[2] = new Price(3, "Large", 24.0);
        p4[3] = new Price(4, "XLarge", 33.0);

        p5[0] = new Price(1, "Personal", 7.5);
        p5[1] = new Price(2, "Regular", 14.0);
        p5[2] = new Price(3, "Large", 22.5);
        p5[3] = new Price(4, "XLarge", 32.0);

        p6[0] = new Price(1, "Personal", 9.5);
        p6[1] = new Price(2, "Regular", 17.5);
        p6[2] = new Price(3, "Large", 28.0);
        p6[3] = new Price(4, "XLarge", 38.0);

        p7[0] = new Price(1, "Personal [N/A]", 0);
        p7[1] = new Price(2, "Regular", 20);
        p7[2] = new Price(3, "Large", 40);
        p7[3] = new Price(4, "XLarge", 60);

        p8[0] = new Price(1, "Personal", 8.0);
        p8[1] = new Price(2, "Regular", 16.0);
        p8[2] = new Price(3, "Large", 26.0);
        p8[3] = new Price(4, "XLarge", 36.0);

    }

    // create printPrice to print out the specific pizza's sizes and prices after selected the wanted pizza
    public static void printPrice(int SIZE, int option[], int index, Pizza pizza[], Price p1[], Price p2[], Price p3[], Price p4[], Price p5[], Price p6[], Price p7[], Price p8[]) {

        // call the pricedefine method to import all the pizza's prices and sizes
        priceDefine(p1, p2, p3, p4, p5, p6, p7, p8);

        System.out.println();

        // use switch case to identify the pizza option, then display the related pizza prices and sizes
        switch (option[index]) {
            case 1 -> {
                System.out.printf("%s\n", pizza[0].getPName());
                for (Price pizza1 : p1) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza1.optionSize, pizza1.pSize, pizza1.pPrice);
                }
            }
            case 2 -> {
                System.out.printf("%s\n", pizza[1].getPName());
                for (Price pizza2 : p2) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza2.optionSize, pizza2.pSize, pizza2.pPrice);
                }
            }
            case 3 -> {
                System.out.printf("%s\n", pizza[2].getPName());
                for (Price pizza3 : p3) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza3.optionSize, pizza3.pSize, pizza3.pPrice);
                }
            }
            case 4 -> {
                System.out.printf("%s\n", pizza[3].getPName());
                for (Price pizza4 : p4) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza4.optionSize, pizza4.pSize, pizza4.pPrice);
                }
            }
            case 5 -> {
                System.out.printf("%s\n", pizza[4].getPName());
                for (Price pizza5 : p5) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza5.optionSize, pizza5.pSize, pizza5.pPrice);
                }
            }
            case 6 -> {
                System.out.printf("%s\n", pizza[5].getPName());
                for (Price pizza6 : p6) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza6.optionSize, pizza6.pSize, pizza6.pPrice);
                }
            }
            case 7 -> {
                System.out.printf("%s\n", pizza[6].getPName());
                for (Price pizza7 : p7) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza7.optionSize, pizza7.pSize, pizza7.pPrice);
                }
            }
            case 8 -> {
                System.out.printf("%s\n", pizza[7].getPName());
                for (Price pizza8 : p8) {
                    System.out.printf("%d [%-15s - RM %-5.2f] \n", pizza8.optionSize, pizza8.pSize, pizza8.pPrice);
                }
            }
            // else display error message
            default -> {
                System.out.println("You have entered wrong Pizza Code! \nPlese Try Again......");
            }
        }

    }

    // Create return String Size method to prompt user enter the size code
    // then convert the int size code to the String size
    public static String size(int SIZE, int index, int option[]) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        String alphabetSize[] = new String[SIZE];

        //implement do while loop to keep looping when the size code invalid or not in the size code range
        do {
            printLine("=", 35);
            System.out.println();
            System.out.print("Select Pizza Size [1/2/3/4]: ");
            size = sc.nextInt();
            System.out.println();

            // use if else to specific the pizza code 3 and pizza code 7 
            // if the user has entered the not available pizza size
            // system will display invalid message to prompt user re-enter 
            if (option[index] == 3 && size == 1) {
                System.out.println("This Pizza Size is not available... Please Try Again!");
            } else if (option[index] == 7 && size == 1) {
                System.out.println("This Pizza Size is not available... Please Try Again!");
            } // else if size code not in the range will display invalid message
            else if (size < 1 || size > 4) {
                System.out.println("Enter Wrong input.....Try Again!");
            }

        } while ((size < 1 || size > 4) || (option[index] == 3 && size == 1)
                || (option[index] == 7 && size == 1));

        // implement if else to conver the int size code to String Size 
        if (size == 1) {
            alphabetSize[index] = "P";
        } else if (size == 2) {
            alphabetSize[index] = "R";
        } else if (size == 3) {
            alphabetSize[index] = "L";
        } else if (size == 4) {
            alphabetSize[index] = "XL";
        }

        // return back in String Size
        return alphabetSize[index];
    }

    // Create totalQuantity to calculate the total number of quantity pizza has ordered
    public static int totalQuantity(int q[], int index, int total, int SIZE) {

        //adding up the previous quantity and current quantity 
        // and store into total
        total = total + q[index];

        // if total more then 8 display the message
        if (total > 8) {
            System.out.println("You have ordered up to 8 pieces of Pizzas...\n");

            // and implement do while
            do {
                // to minus the total with the current quantity
                total = total - q[index];

                // call the quantity method to re prompt user enter new quantity
                q[index] = quantity(SIZE, index, total);
                // then adding up the previous quantity and current quantity 
                total = total + q[index];

            } while (total > 8);
        }
        //return the totalQuantity
        return total;
    }

    // Create return int quantity to prompt user to enter quantity of pizza
    public static int quantity(int SIZE, int index, int total) {
        Scanner sc = new Scanner(System.in);

        int q[] = new int[SIZE];

        // implement do while to keep looping when the quantity is less then 1 or more then 8
        do {
            System.out.println("Your current pizza quantity: " + total);
            System.out.println("You can place a maximum of up to 8 pizzas per order");
            System.out.print("\nEnter Quantity: ");
            q[index] = sc.nextInt();

            // if quantity is more then 8 
            // system will display error message to user
            if (q[index] > 8) {
                System.out.println("You have ordered more then the provided quantity range...TRY AGAIN.....\n");
            } // if quantity is less then 1
            // system will display error message to user
            else if (q[index] < 1) {
                System.out.println("You have ordered less then 1 quantity of pizza...TRY AGAIN.....\n");
            }

            printLine("=", 60);
            System.out.println();
        } while (q[index] < 1 || q[index] > 8);

        // retrun back the user quantity value
        return q[index];
    }

    // Create return double pizzaCost to calculate the pizza cost , after selected the pizza code, size and quantity
    public static double pizzaCost(int SIZE, int option[], int index, int quantity[], String size[], Price p1[], Price p2[], Price p3[], Price p4[], Price p5[], Price p6[], Price p7[], Price p8[]) {
        double total = 0.0;

        //use switch case to identify the pizza flavour/ code
        switch (option[index]) {
            case 1 -> {

                //use if else to identify the size of the pizza
                if (size[index].equals("P")) {

                    // call the Pizza class to get the pizza cost
                    // then multiply with the quantity
                    total = (p1[0].pPrice * quantity[index]);
                } else if (size[index].equals("R")) {
                    total = (quantity[index] * p1[1].pPrice);
                } else if (size[index].equals("L")) {
                    total = (quantity[index] * p1[2].pPrice);
                } else if (size[index].equals("XL")) {
                    total = (quantity[index] * p1[3].pPrice);
                }

            }
            case 2 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p2[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p2[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p2[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p3[3].pPrice;
                }
            }
            case 3 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p3[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p3[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p3[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p3[3].pPrice;
                }
            }
            case 4 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p4[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p4[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p4[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p4[3].pPrice;
                }
            }
            case 5 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p5[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p5[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p5[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p5[3].pPrice;
                }
            }
            case 6 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p6[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p6[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p6[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p6[3].pPrice;
                }
            }
            case 7 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p7[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p7[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p7[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p7[3].pPrice;
                }
            }
            case 8 -> {
                if (size[index].equals("P")) {
                    total = quantity[index] * p8[0].pPrice;
                } else if (size[index].equals("R")) {
                    total = quantity[index] * p8[1].pPrice;
                } else if (size[index].equals("L")) {
                    total = quantity[index] * p8[2].pPrice;
                } else if (size[index].equals("XL")) {
                    total = quantity[index] * p8[3].pPrice;
                }
            }

        }

        return total;

    }
}
