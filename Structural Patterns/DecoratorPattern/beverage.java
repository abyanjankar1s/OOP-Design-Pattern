
abstract class Beverage {
    abstract double cost();
    abstract String description();
}

class DarkRoast extends Beverage {
    @Override
    public double cost(){
        return 3.45;
    }
    @Override
    public String description(){
        return "Dark Roast Coffee"; 
    }
}

class LightRoast extends Beverage {
    @Override
    public double cost(){
        return 3.45;
    }
    public String description(){
        return "Light Roast Coffee"; 
    }
}

abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
    }
}

class EspressoDecorator extends BeverageDecorator {
    public EspressoDecorator(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost(){
        return beverage.cost() + 0.5;
    }
    @Override
    public String description(){
        return beverage.description() + "Espress0";
    }
}

class CreamDecorator extends BeverageDecorator {
    public CreamDecorator(Beverage beverage){
        super(beverage);
    }
    @Override
    public double cost(){
        return beverage.cost() + 1;
    }
    @Override
    public String description() {
        return beverage.description() + ", Cream."; 
    }
}

class Main {
    public static void main(String[] args) {
        Beverage beverage = new EspressoDecorator(
            new CreamDecorator(new LightRoast())
        );
        System.out.println(beverage.description());
        System.out.println(beverage.cost());
    }
}
