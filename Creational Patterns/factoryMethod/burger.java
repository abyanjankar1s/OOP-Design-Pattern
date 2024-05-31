
import java.util.ArrayList; 

enum Burgers{
    CHEESE,
    HAM,
    VEGAN,
    DELUXE
}

abstract class BurgerStore {
    abstract Burger createBurger(Burgers item);
    public Burger orderBurger(Burgers type) {
        Burger burger = createBurger(type); 
        System.out.println("---Making a "+ burger.getName() + " ---");
        burger.prepare();
        burger.cook();
        burger.serve();
        return burger;
    }
}

class CheeseBurgerStore extends BurgerStore{
    Burger createBurger(Burgers item){
        if(item.equals(Burgers.CHEESE)){
            return new CheeseBurger(); 
        } else if (item.equals(Burgers.DELUXE)){
            return new DeluxBurger();
        } else return null;
    }
}

class VeganBurgerStore extends BurgerStore {
    Burger createBurger(Burgers item){
        if (item.equals(Burgers.VEGAN)){
            return new VeganBurger();
        } else return null; 
    }
}

class HamBurgerStore extends BurgerStore{
    Burger createBurger(Burgers item){
        if (item.equals(Burgers.HAM)){
            return new HamBurger(); 
        } else return null; 
    }
}

abstract class Burger {
    String name;
    String bread;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>(); 

    void prepare(){

    }
    void cook(){

    }
    void serve(){

    }
    public String getName(){
        return name;
    }
}

class CheeseBurger extends Burger {
    
    public CheeseBurger() {
        name = "Big Macc";
        bread = "Italian";
        sauce = "BBQ"; 
    }
}

class DeluxBurger extends Burger{
    public DeluxBurger() {
        name = "Delux Burger" ;
        bread = "Reg"; 
        sauce = "Ranch";
    }
}

class VeganBurger extends Burger{
    public VeganBurger(){
        name = "Vegan Burger";
        bread = "Flat";
        sauce = "Honey mustard";
    }
}

class BurgerDriveThru {
    public static void main(String[] args) {
        BurgerStore cheeseStore = new CheeseBurgerStore();
        BurgerStore veganStore = new VeganBurgerStore();

        Burger burger = cheeseStore.orderBurger(Burgers.CHEESE);
        System.out.println("Order "+ burger.getName() + "\n");

        burger = veganStore.orderBurger(Burgers.VEGAN);
        System.out.println("order "+ burger.getName() + "\n");
    }
}