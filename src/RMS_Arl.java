import java.util.ArrayList;

class RMS_Arl {
    // Menu using arrays
    ArrayList<String> menuItems = new ArrayList<>();

    // Reservations using arrays
    ArrayList<String>  reservations = new ArrayList<>();

    // Orders using arrays
    ArrayList<String>  orders = new ArrayList<>();

    // Add a menu item
    void addMenuItem(String item) {
        menuItems.add(item);
    }

    // Add a reservation
    void addReservation(String customerDetails) {
        reservations.add(customerDetails);
    }

    // Place an order
    void placeOrder(String orderDetails) {
        orders.add(orderDetails);
        //orders[ordersCount++] = orderDetails;
    }

    // Display the menu
    void displayMenu() {
        System.out.println("Menu:");
        for (String menuItem : menuItems) {
            System.out.println("Item: " + menuItem);
        }
    }

    // Display reservations
    void displayReservations() {
        System.out.println("Reservations:");
        for (String reservation : reservations) {
            System.out.println("Customer: " + reservation);
        }
    }

    // Process orders
    void processOrders() {
        System.out.println("Processing Orders:");
        for (String order : orders) {
            System.out.println("Order Details: " + order);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        RMS_Arl brms = new RMS_Arl();

        for (int i = 0;i < 10000; i++){
            // Adding menu items
            brms.addMenuItem("Item: " +i);

            // Adding reservations
            brms.addReservation("Name: " + i);

            // Placing orders
            brms.placeOrder("Food: " + i);
        }

        long midTime = System.nanoTime(); // Time after setting up the system

        // Displaying menu, reservations, and processing orders
        brms.displayMenu();
        brms.displayReservations();
        brms.processOrders();

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