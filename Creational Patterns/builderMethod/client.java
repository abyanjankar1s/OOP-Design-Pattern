

enum Starter {
    SALAD,
    SOUP,
    BRUSCHETTA,
    VEGGIE,
    WINGS
}

enum Main {
    GRILLED_CHICKEN,
    PASTA,
    VEGGIE_STIRFRY,
    FISH,
    PIZZA
}

enum Dessert {
    FRUIT_SALAD,
    ICE_CREAM,
    CHOCLATE_CAKE,
    VEGAN_PUDDING,
    CHEESECAKE
}

enum Drink {
    WATER,
    VEGAN_SHAKE,
    SODA,
    FRUIT_JUICE
}

class Meal {
    private Starter starter;
    private Main main;
    private Dessert dessert;
    private Drink drink;
    
    Starter getStarter(){
        return this.starter; 
    }
    Main getMain(){
        return this.main;
    }
    Dessert getDessert(){
        return this.dessert;
    }
    Drink getDrink(){
        return this.drink;
    }
    void setStarter(Starter starter){
        this.starter = starter;
    }
    void setMain(Main main){
        this.main = main;
    }
    void setDessert(Dessert dessert){
        this.dessert = dessert;
    }
    void setDrink(Drink drink){
        this.drink = drink; 
    }
}

interface Builder {
    void addStarter();
    void addMain();
    void addDessert();
    void addDrink();
}

class VeganMealBuilder implements Builder {
    private Meal meal;
    
    public VeganMealBuilder(){
        this.meal = new Meal(); 
    }
    @Override
    public void addStarter(){
        meal.setStarter(Starter.SALAD);
    }
    @Override
    public void addMain(){
        meal.setMain(Main.VEGGIE_STIRFRY);
    }
    @Override
    public void addDessert(){
        meal.setDessert(Dessert.VEGAN_PUDDING);
    }
    @Override
    public void addDrink(){
        meal.setDrink(Drink.VEGAN_SHAKE);
    }

    Meal build(){
        return this.meal; 
    }
}

class HealthyMealBuilder implements Builder {
    private Meal meal; 

    public HealthyMealBuilder(){
        this.meal = new Meal();
    }

    @Override
    public void addStarter() {
        meal.setStarter(Starter.SALAD);
    }
    @Override
    public void addMain() {
        meal.setMain(Main.GRILLED_CHICKEN);
    }
    @Override
    public void addDessert() {
        meal.setDessert(Dessert.FRUIT_SALAD);
    }
    @Override
    public void addDrink() {
        meal.setDrink(Drink.WATER);
    }
    Meal build(){
        return this.meal; 
  }
}

class Director {
    void constructVegalMeal(VeganMealBuilder builder){
        builder.addStarter();
        builder.addMain();
        builder.addDessert();
        builder.addDrink();
    }
    void constructHealthyMeal(HealthyMealBuilder builder){
        builder.addStarter();
        builder.addMain();
        builder.addDessert();
        builder.addDrink();
    }
}

class Client {
    public static void main(String[] args) {
        Director director = new Director();
        VeganMealBuilder builder = new VeganMealBuilder();
        director.constructVegalMeal(builder);

        Meal veganMeal = builder.build();
        System.out.println("Meal constructed: ");
        System.out.println("Starter: " + veganMeal.getStarter());
        System.out.println("Main: " + veganMeal.getMain());
        System.out.println("Dessert: " + veganMeal.getDessert());
        System.out.println("Drink: " + veganMeal.getDrink());

    }
}

