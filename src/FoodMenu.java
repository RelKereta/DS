import java.util.HashMap;

public class FoodMenu {
    static HashMap<Integer, String> foodMap = new HashMap<>();

    /* Function to add items to the HashMap */
    void addFoodItems() {
        foodMap.put(1, "Menu");
        foodMap.put(2, "1Food");
        foodMap.put(3, "2Drinks");
        foodMap.put(4, "3Main-Dish");
        foodMap.put(5, "4Side-Dish");
        foodMap.put(6, "5Alcoholic");
        foodMap.put(7, "6Non-alcoholic");
        foodMap.put(8, "7Burger");
        foodMap.put(9, "8Pizza");
        foodMap.put(10, "9Popcorn");
        foodMap.put(11, "10Fries");
        foodMap.put(12, "11Beer");
        foodMap.put(13, "12Wine");
        foodMap.put(14, "13Lemon");
        foodMap.put(15, "14Water");
    }

    /* Function to search for an item in the HashMap */
    void searchFood(String key) {
        boolean found = foodMap.containsValue(key);
        if (found) {
            System.out.println("\nIt exists");
        } else {
            System.out.println("\nIt does not exist");
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        FoodMenu menu = new FoodMenu(); // Creating a FoodMenu object

        // Adding food items to the HashMap
        menu.addFoodItems();
        long endTime = System.nanoTime();
        System.out.println("Adding runtime: " + (endTime - startTime)); // Runtime to create the HashMap

        // Function call to search for an item
        menu.searchFood("10Fries");
        endTime = System.nanoTime();
        System.out.println("Search runtime: " + (endTime - startTime)); // Runtime to search the HashMap

        long total_mem = rt.totalMemory();
        long free_mem = rt.freeMemory();
        long used_mem = total_mem - free_mem; // Calculate the memory being used
        System.out.println("\nAmount of used memory: " + used_mem);
        endTime = System.nanoTime();
        System.out.println("Total runtime: " + (endTime - startTime)); // Total runtime for the program
    }
}
