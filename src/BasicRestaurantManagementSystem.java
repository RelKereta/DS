class BasicRestaurantManagementSystem {
    // Menu using arrays
    String[] menuItems = new String[100];
    int menuCount = 0;

    // Reservations using arrays
    String[] reservations = new String[100];
    int reservationCount = 0;

    // Orders using arrays
    String[] orders = new String[100];
    int orderCount = 0;

    // Add a menu item
    void addMenuItem(String item) {
        menuItems[menuCount++] = item;
    }

    // Add a reservation
    void addReservation(String customerDetails) {
        reservations[reservationCount++] = customerDetails;
    }

    // Place an order
    void placeOrder(String orderDetails) {
        orders[orderCount++] = orderDetails;
    }

    // Display the menu
    void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuCount; i++) {
            System.out.println("Item: " + menuItems[i]);
        }
    }

    // Display reservations
    void displayReservations() {
        System.out.println("Reservations:");
        for (int i = 0; i < reservationCount; i++) {
            System.out.println("Customer: " + reservations[i]);
        }
    }

    // Process orders
    void processOrders() {
        System.out.println("Processing Orders:");
        for (int i = 0; i < orderCount; i++) {
            System.out.println("Order Details: " + orders[i]);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Starting time of the program
        Runtime rt = Runtime.getRuntime(); // To get readings of memory usage

        BasicRestaurantManagementSystem brms = new BasicRestaurantManagementSystem();

        // Adding menu items
        brms.addMenuItem("Burger");
        brms.addMenuItem("Pizza");
        brms.addMenuItem("Fries");

        // Adding reservations
        brms.addReservation("Alice");
        brms.addReservation("Bob");

        // Placing orders
        brms.placeOrder("Burger, Fries");
        brms.placeOrder("Pizza");

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
