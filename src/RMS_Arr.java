class RMS_Arr {
    // Menu using arrays
    String[] menuItems = new String[10];
    int menuCount = 0;

    // Reservations using arrays
    String[] reservations = new String[10];
    int reservationCount = 0;

    // Orders using arrays
    String[] orders = new String[10];
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

    // Delete an item from above
    public static String[] deleteAnySystem(String[] any, int index){
        String[] temp = new String[any.length - 1];

        for (int i = 0, k =0; i < any.length; i++){
            if (i == index) {
                continue;
            }

            temp[k++] = any[i];
        }

        return temp;
    }

    public static String[] insertAnySystem(String[] any, int index, String item){
        String[] temp = new String[any.length + 1];

        for (int i = 0, k =0; i < any.length; i++){
            if (i == index) {
                temp[k++] = item;
            }

            temp[k++] = any[i];
        }

        return temp;
    }

    void searchAnySystem(String[] any, String element){
        boolean found = false;
        for (String i: any){
            if (i.equals(element)){
                found = true;
                System.out.println("It exist");
                break;
            }
        }
        if (!found){
            System.out.println("It does not exist");
        }
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

        RMS_Arr brms = new RMS_Arr();

        int inputn = 10;
        for (int i = 0; i < inputn;i++){
            // Adding menu items
            brms.addMenuItem("Item " + i);

            // Add reservations
            brms.addReservation("Name " + i);

            // Placing orders
            brms.placeOrder("Food " + i);
        }

        brms.menuItems = deleteAnySystem(brms.menuItems, 5);
        brms.reservations = deleteAnySystem(brms.reservations,5);
        brms.orders = deleteAnySystem(brms.orders,5);

        long addingTime = System.nanoTime(); // Time after setting up the system

        brms.menuItems = insertAnySystem(brms.menuItems,5, "magic");
        brms.reservations = insertAnySystem(brms.reservations,5, "magic");
        brms.orders = insertAnySystem(brms.orders,5, "magic");

        long insertTime = System.nanoTime(); // Time after setting up the system

        // Displaying menu, reservations, and processing orders
        brms.displayMenu();
        brms.displayReservations();
        brms.processOrders();

        long printingTime = System.nanoTime();

        brms.searchAnySystem(brms.menuItems, "magic");
        brms.searchAnySystem(brms.reservations, "magic");
        brms.searchAnySystem(brms.orders, "magic");

        long endTime = System.nanoTime(); // Time after processing

        // Calculate memory usage
        long totalMem = rt.totalMemory();
        long freeMem = rt.freeMemory();
        long usedMem = totalMem - freeMem; // Calculate the memory being used

        // Print time and memory usage
        System.out.println("\nTime taken to add to the system: " + (addingTime - startTime) + " ns");
        System.out.println("Time insert to add to the system: " + (insertTime - addingTime) + " ns");
        System.out.println("Time taken to print the orders: " + (printingTime - insertTime) + " ns");
        System.out.println("Time taken to print the orders: " + (endTime - printingTime) + " ns");
        System.out.println("Total runtime: " + (endTime - startTime) + " ns");
        System.out.println("Amount of used memory: " + usedMem / (1024.0 * 1024.0) + " MB");
    }
}