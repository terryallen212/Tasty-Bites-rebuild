import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Restaurant {
    HashMap<String,ArrayList<String>> ingredients;

    HashMap<String,Integer> inventory;


    public Restaurant(){
        ingredients= new HashMap<>();
        inventory= new HashMap<>();
        initializeIngredients();
        initializeInventory();


    }
    public void initializeIngredients(){
        ArrayList<String> burgerIngredients=new ArrayList<>();
        burgerIngredients.add("lettuce");
        burgerIngredients.add("tomato");
        burgerIngredients.add("pickles");
        burgerIngredients.add("ketchup");
        burgerIngredients.add("patty");
        ingredients.put("burger", burgerIngredients);

        ArrayList<String> chickenIngredients=new ArrayList<>();
        chickenIngredients.add("lettuce");
        chickenIngredients.add("mayo");
        chickenIngredients.add("patty");
        chickenIngredients.add("chicken");
        ingredients.put("chickenSandwich", chickenIngredients);








    }
    public void displayItems(){
        Set<String> items = ingredients.keySet();
        System.out.println(items.toString());
    }

    public void initializeInventory(){
        inventory.put("lettuce", 5);
        inventory.put("patty", 5);
        inventory.put("chicken", 3);
        inventory.put("tomato", 1);
        inventory.put("pickles", 4);
        inventory.put("mayo", 2);
        inventory.put("ketchup", 3);
        inventory.put("cup vanilla almond milk", 5);
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