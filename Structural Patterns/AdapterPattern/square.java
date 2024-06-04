// Implement the Adapter design pattern.

// The Adapter is a structural design pattern that allows incompatible interfaces 
//to work together. It wraps an existing class with a new interface so that it becomes 
//compatible with the client's interface.

// You are given completed SquareHole, Square and Circle classes. 
//A Square fits into a SquareHole if the Square's side length is 
//less than or equal to the SquareHole's length. A Circle has a radius and 
//a Circle fits into a SquareHole if the Circle's diameter is less than or equal to 
//the SquareHole's length.

// Complete the implementation of the CircleToSquareAdapter class such that 
//it adapts a Circle to a Square.

class SquareHole {
    private double sideLength;

    public SquareHole(double sideLength){
        this.sideLength = sideLength;
    }

    public boolean canFit(Square square){
        return this.sideLength >= square.getSideLength(); 
    }
}

class Square {
    private double sideLength;

    public Square(){}

    public Square(double sideLength){
        this.sideLength = sideLength;
    }
    public double getSideLength(){
        return this.sideLength;
    }
}

class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
}

class CircleToSquareAdapter extends Square {
    private Circle circle;

    public CircleToSquareAdapter(Circle circle){
        this.circle = circle;
    }
    @Override
    public double getSideLength(){
        return 2 * this.circle.getRadius();
    }
}


// SquareHole squareHole = new SquareHole(5);

// Square square = new Square(5);
// squareHole.canFit(square);            // true

// Circle circle = new Circle(5);
// CircleToSquareAdapter circleAdapter = new CircleToSquareAdapter(circle);
// squareHole.canFit(circleAdapter);     // false

