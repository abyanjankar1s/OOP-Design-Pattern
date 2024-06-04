// Implement the Facade design pattern.

// The Facade is a structural design pattern that provides a simplified 
//interface to a complex system of classes, library, or framework. 
//It wraps the complexities of the system and provides a simple interface to clients.

// You are given several classes that represent different parts of 
//a restaurant's operation: Order, Cashier, Food, Chef, PackagedFood, 
//KitchenStaff, and DriveThruFacade.

// The Cashier takes the customer's Order.
// The Chef prepares the Food as per the Order.
// The KitchenStaff packages the Food if it's a takeout order.
// The DriveThruFacade acts as the interface between the customer 
//and these internal components of the restaurant.
// Your task is to implement the DriveThruFacade class to coordinate 
//these components. The facade should handle taking orders from 
//customers and returning either Food or PackagedFood, depending 
//on whether the order is for takeout.

class Order {
    private String contents;
    private boolean takeOut;

    public Order(String contents, boolean takeOut) {
        this.contents = contents;
        this.takeOut = takeOut;
    }
    public String getOrder() {
        return contents;
    }
    public boolean isTakeOut() {
        return takeOut;
    }
}

class Cashier {
    public Order takeOrder(String contents, boolean takeOut) {
        return new Order(contents, takeOut);
    }
}

class Food {
    private String contents;

    public Food(String order) {
        this.contents = order;
    }
    public String getFood(){
        return contents;
    }
}

class Chef {
    public Food prepareFood(Order order) {
        return new Food(order.getOrder());
    }
}

class PackagedFood extends Food {
    public PackagedFood(Food food) {
        super(food.getFood() + " in a bag");
    }
}

class KitchenStaff {
    public PackagedFood packageOrder(Food food) {
        return new PackagedFood(food);
    }
}

class DriveThruFacade {
    private Cashier cashier = new Cashier(); 
    private Chef chef = new Chef();
    private KitchenStaff kitchenStaff = new KitchenStaff();

    public Food takeOrder(String orderContents, boolean takeOut) {
        Order order = cashier.takeOrder(orderContents, takeOut);
        Food food = chef.prepareFood(order);
        if(order.isTakeOut()){
            return kitchenStaff.packageOrder(food);
        }
        return food; 
    }
}

// DriveThruFacade driveThru = new DriveThruFacade();

// Food dineInFood = driveThru.takeOrder("Burger and Fries", /* takeOut= */ false);
// dineInFood.getFood(); // "Burger and Fries"

// Food takeOutFood = driveThru.takeOrder("Pizza", /* takeOut= */ true);
// takeOutFood.getFood(); // "Pizza in a bag"
