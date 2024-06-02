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

    // Search for a menu item
    void searchMenuItem(int id) {
        if (menu.containsKey(id)) {
            System.out.println("Menu Item Found: ID: " + id + ", Item: " + menu.get(id));
        } else {
            System.out.println("Menu Item Not Found: ID: " + id);
        }
    }

    // Insert a menu item
    void insertMenuItem(int id, String item) {
        menu.put(id, item);
        System.out.println("Inserted Menu Item: ID: " + id + ", Item: " + item);
    }

    // Delete a menu item
    void deleteMenuItem(int id) {
        if (menu.remove(id) != null) {
            System.out.println("Deleted Menu Item: ID: " + id);
        } else {
            System.out.println("Menu Item Not Found: ID: " + id);
        }
    }

    // Search for a reservation
    void searchReservation(int id) {
        if (reservations.containsKey(id)) {
            System.out.println("Reservation Found: ID: " + id + ", Customer: " + reservations.get(id));
        } else {
            System.out.println("Reservation Not Found: ID: " + id);
        }
    }

    // Insert a reservation
    void insertReservation(int id, String customerDetails) {
        reservations.put(id, customerDetails);
        System.out.println("Inserted Reservation: ID: " + id + ", Customer: " + customerDetails);
    }

    // Delete a reservation
    void deleteReservation(int id) {
        if (reservations.remove(id) != null) {
            System.out.println("Deleted Reservation: ID: " + id);
        } else {
            System.out.println("Reservation Not Found: ID: " + id);
        }
    }

    // Search for an order
    void searchOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            System.out.println("Order Found: ID: " + orderId + ", Details: " + orders.get(orderId));
        } else {
            System.out.println("Order Not Found: ID: " + orderId);
        }
    }

    // Insert an order
    void insertOrder(int orderId, String orderDetails) {
        orderQueue.add(orderId);
        orders.put(orderId, orderDetails);
        System.out.println("Inserted Order: ID: " + orderId + ", Details: " + orderDetails);
    }

    // Delete an order
    void deleteOrder(int orderId) {
        if (orders.remove(orderId) != null) {
            orderQueue.remove(orderId);
            System.out.println("Deleted Order: ID: " + orderId);
        } else {
            System.out.println("Order Not Found: ID: " + orderId);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        RestaurantManagementSystem rms = new RestaurantManagementSystem();

        // Adding items
        int i;
        for (i = 0; i <= 25; i++) {
            rms.addMenuItem(i, "Item" + i);
            rms.addReservation(i, "Customer" + i);
            rms.placeOrder(i, "Order" + i);
        }

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

        // Measure search, insert, and delete operations
        long searchStart = System.nanoTime();
        rms.searchMenuItem(12);
        rms.searchReservation(12);
        rms.searchOrder(12);
        long searchEnd = System.nanoTime();

        long insertStart = System.nanoTime();
        rms.insertMenuItem(26, "NewItem");
        rms.insertReservation(26, "NewCustomer");
        rms.insertOrder(26, "NewOrder");
        long insertEnd = System.nanoTime();

        long deleteStart = System.nanoTime();
        rms.deleteMenuItem(12);
        rms.deleteReservation(12);
        rms.deleteOrder(12);
        long deleteEnd = System.nanoTime();

        // Calculate memory usage after operations
        long totalMemAfterOps = rt.totalMemory();
        long freeMemAfterOps = rt.freeMemory();
        long usedMemAfterOps = totalMemAfterOps - freeMemAfterOps;

        // Print time and memory usage for search, insert, and delete operations
        System.out.println("\nTime taken for search operations: " + (searchEnd - searchStart) + " ns");
        System.out.println("Time taken for insert operations: " + (insertEnd - insertStart) + " ns");
        System.out.println("Time taken for delete operations: " + (deleteEnd - deleteStart) + " ns");
        System.out.println("Amount of used memory after operations: " + usedMemAfterOps / (1024.0 * 1024.0) + " MB");
    }
}
