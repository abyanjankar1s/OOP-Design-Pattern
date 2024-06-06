

interface TrafficLightState {
    void changeState(TrafficLight trafficLight);
}

class GreenState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light){
        System.out.println("Green - GO");
        light.setState(new YellowState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        if(light.getPrevState() instanceof RedState){
            System.out.println("Yellow (from Red to Green)");
            light.setState(new GreenState());
        } else {
            System.out.println("Yellow (Green to Red)");
            light.setState(new RedState());
        }
    }
}

class RedState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Red - STOP");
        light.setState(new YellowState());
    }
}

class TrafficLight {
    private TrafficLightState state;
    private TrafficLightState prevState;

    TrafficLight() {
        this.state = new RedState();
        this.prevState = null;
    }

    void setState(TrafficLightState state){
        this.prevState = this.state;
        this.state = state;
    }
    TrafficLightState getPrevState() {
        return this.prevState;
    }
    void change() {
        this.state.changeState(this);
    }
}

public class Client {
    public static void main(String[] args) {
        TrafficLight lightSys = new TrafficLight();

        lightSys.change(); //red
        lightSys.change(); // yellow
        lightSys.change(); // green
        lightSys.change(); // yellow
        lightSys.change(); // red
        lightSys.change(); // yellow
        lightSys.change(); // green 

    }
}