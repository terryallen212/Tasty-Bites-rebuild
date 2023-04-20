// Import the utilitys that Will be using in the project. We want teh array list since we will be using arrays for the ingrredients. Hash map is also for the ingredients and to make the code neater.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
//The public class is called resturant.
public class Restaurant {
    // Make two hashmaps to the array and string since we will be using the array to string for the inventory or stock.
    HashMap<String,ArrayList<String>> ingredients;

    HashMap<String,Integer> inventory;


    public Restaurant(){
        //Make an ingredient hash map and an iventory hashmap. Then we intilize both for the statemetns below.
        ingredients= new HashMap<>();
        inventory= new HashMap<>();
        initializeIngredients();
        initializeInventory();


    }
    public void initializeIngredients(){
        //Our first part will be the ingredients, below is the list of each ingredient for each item.
        ArrayList<String> burgerIngredients=new ArrayList<>();
        burgerIngredients.add("lettuce");
        burgerIngredients.add("tomato");
        burgerIngredients.add("pickles");
        burgerIngredients.add("ketchup");
        burgerIngredients.add("patty");
        //add the ingredients from above to match with the array string statement.
        ingredients.put("burger", burgerIngredients);

        ArrayList<String> chickenIngredients=new ArrayList<>();
        chickenIngredients.add("lettuce");
        chickenIngredients.add("mayo");
        chickenIngredients.add("patty");
        chickenIngredients.add("chicken");
        ingredients.put("chickenSandwich", chickenIngredients);

        ArrayList<String> smoothieVanilla=new ArrayList<>();
        smoothieVanilla.add("cup vanilla almond milk");
        smoothieVanilla.add(" tablespoon real maple syrup");
        smoothieVanilla.add("frozen bananas");
        ingredients.put("Vanilla Smoothie", smoothieVanilla);

        ArrayList<String> jumboshrimpBasket=new ArrayList<>();
        jumboshrimpBasket.add("shrimp");
        jumboshrimpBasket.add("fries");
        ingredients.put("Jumboshrimp basket", jumboshrimpBasket);









    }
    //Make a public void class. This will dispay the items to the User side of the app.
    public void displayItems(){
        Set<String> items = ingredients.keySet();
        System.out.println(items.toString());
    }

    public void initializeInventory(){
        inventory.put("lettuce",20);
        inventory.put("patty", 20);
        inventory.put("chicken", 30);
        inventory.put("tomato", 30);
        inventory.put("pickles", 20);
        inventory.put("mayo", 10);
        inventory.put("ketchup", 7);
        inventory.put("cup vanilla almond milk", 9);
        inventory.put("tablespoon real maple syrup", 5);
        inventory.put("frozen bananas", 4);
        inventory.put("fries", 3);
        inventory.put("shrimp", 2);


    }
    public boolean order(String foodName){
        if(!ingredients.containsKey(foodName)){
            return false;
        }
        ArrayList<String> foodNameIngredients= ingredients.get(foodName);
        for(String ingredient:foodNameIngredients){
            Integer quanity =inventory.get(ingredient);
            if(quanity == null || quanity == 0){
                return false;
            }
        }
        for(String ingredient:foodNameIngredients){
            Integer quanity =inventory.get(ingredient);
            inventory.put(ingredient, quanity - 1);
        }
        return true;
    }
}