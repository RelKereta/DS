import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class RestaurantManagementSystem {
    // Menu using HashMap
    HashMap<Integer, String> menu = new HashMap<>();

    // Reservations using HashMap
    HashMap<Integer, String> reservations = new HashMap<>();

    // Orders using Queue and HashMap
    Queue<Integer> orderQueue = new LinkedList<>();
    HashMap<Integer, String> orders = new HashMap<>();

    // Add a menu item
    void addMenuItem(int id, String item) {
        menu.put(id, item);
    }

    // Add a reservation
    void addReservation(int id, String customerDetails) {
        reservations.put(id, customerDetails);
    }

    // Place an order
    void placeOrder(int orderId, String orderDetails) {
        orderQueue.add(orderId);
        orders.put(orderId, orderDetails);
    }

    // Display the menu
    void displayMenu() {
        System.out.println("Menu:");
        for (Integer id : menu.keySet()) {
            System.out.println("ID: " + id + ", Item: " + menu.get(id));
        }
    }

    // Display reservations
    void displayReservations() {
        System.out.println("Reservations:");
        for (Integer id : reservations.keySet()) {
            System.out.println("Reservation ID: " + id + ", Customer: " + reservations.get(id));
        }
    }

    // Process orders
    void processOrders() {
        System.out.println("Processing Orders:");
        while (!orderQueue.isEmpty()) {
            int orderId = orderQueue.poll();
            System.out.println("Order ID: " + orderId + ", Details: " + orders.get(orderId));
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        RestaurantManagementSystem rms = new RestaurantManagementSystem();

        // Adding menu items
        rms.addMenuItem(1, "Burger");
        rms.addMenuItem(2, "Pizza");
        rms.addMenuItem(3, "Fries");

        // Adding reservations
        rms.addReservation(101, "Alice");
        rms.addReservation(102, "Bob");

        // Placing orders
        rms.placeOrder(1001, "Burger, Fries");
        rms.placeOrder(1002, "Pizza");

        long midTime = System.nanoTime(); // Time after setting up the system

        // Displaying menu, reservations, and processing orders
        rms.displayMenu();
        rms.displayReservations();
        rms.processOrders();

        long endTime = System.nanoTime(); // Time after processing

        // Calculate memory usage
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem; // Calculate the memory being used

        // Print time and memory usage
        System.out.println("\nTime taken to set up the system: " + (midTime - startTime) + " ns");
        System.out.println("Time taken to process the orders: " + (endTime - midTime) + " ns");
        System.out.println("Total runtime: " + (endTime - startTime) + " ns");
        System.out.println("Amount of used memory: " + usedMem / (1024.0 * 1024.0) + " MB");
    }
}
