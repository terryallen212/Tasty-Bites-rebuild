import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    //Data members
    int stockNumber;
    String stockName;
    int amount;

    static Scanner sc= new Scanner(System.in);

    //Main function
    public static void main(String[] args) {
//Arraylist of Inventory object
        List<Inventory> inventory= new ArrayList<>();
        int choice;
//User Menu
        do{
            System.out.println("\nUser Menu");
            System.out.println("---------");
            System.out.println("1. Add an item");
            System.out.println("2. Discount an item");
            System.out.println("3. Display the amount in stock of an item.");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice....");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    add(inventory);
                    break;
                case 2:
                    discount(inventory);
                    break;
                case 3:
                    display(inventory);
                    break;
            }
        }while(choice!=4);
    }
    /**
     * Method to add inventory object to the inventory array
     * @param inventory array
     */
    private static void add(List<Inventory> inventory) {
        Inventory i= new Inventory();
        i.stockNumber=inventory.size() + 1000;
        System.out.println("Enter Stock Name : ");
        i.stockName=sc.nextLine();
        System.out.println("Enter amount in stock : ");
        i.amount= sc.nextInt();
        inventory.add(i);
        System.out.println("Stock added to inventory successfully!!!");
        System.out.println("Stock Number for this Stock is : "+valueOf(i.stockNumber));
    }

    /**
     * Method to discount inventory object
     * @param inventory array
     */
    private static void discount(List<Inventory> inventory) {
        String stockName;
        Boolean flag=false;
        System.out.println("Enter stock name for discounting it :");
        stockName=sc.nextLine();
        for (Inventory i : inventory)
        {
            if(i.stockName.equalsIgnoreCase(stockName))
            {
                int index=inventory.indexOf(i);
                Inventory temp= new Inventory();
                temp.stockNumber=i.stockNumber;
                temp.stockName="discontinued";
                temp.amount=0;
                inventory.set(index, temp);
                System.out.println("Item is discounted successfully!");
                flag= true;
            }
        }
        if(flag==false)
        {
            System.out.println(stockName+" is not found in Inventory!");
        }

    }

    /**
     * Method to display amount of inventory object
     * @param inventory array
     */
    private static void display(List<Inventory> inventory) {
        String stockName;
        Boolean flag=false;
        System.out.println("Enter stock name for display its amount :");
        stockName=sc.nextLine();
        for (Inventory i : inventory)
        {
            if(i.stockName.equalsIgnoreCase(stockName))
            {
                System.out.println("Amount of "+ stockName +" in the inventory is :" + i.amount);
                flag= true;
            }
        }
        if(flag==false)
        {
            System.out.println(stockName+" is not found in Inventory!!!!!");
        }

    }

}