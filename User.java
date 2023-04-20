import java.util.Scanner;// in the top!import java.util.Scanner;// in the top!

public class User {
    public static void main(String[] args) {
        Restaurant myRestaurant = new Restaurant();


        System.out.println("Welcome, here are our items!");
        while (true) {
            Scanner sc = new Scanner(System.in);

            myRestaurant.displayItems();
            System.out.println("Order from above items");
            String userfoodChoice = sc.next();

            boolean userorder = myRestaurant.order(userfoodChoice);

            if (userorder) {
                System.out.println("enjoy!");



            } else {



                System.out.println("item doesent exist, or out of inventory");



            }


        }
    }
}



