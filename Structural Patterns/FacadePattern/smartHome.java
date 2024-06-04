

enum Brightness {
    UNKNOWN,
    BRIGHT,
    DIM,
}

enum Service {
    UNKNOWN,
    NETFLIX,
    HULU, 
    HBO,
}

class SmartHouseSubSystem {
    private Brightness brightness;
    private int temperature;
    private Service service;
    private boolean isSecurityArmed;

    public SmartHouseSubSystem(){
        this.brightness = Brightness.UNKNOWN; 
        this.temperature = 19;
        this.service = Service.UNKNOWN;
        this.isSecurityArmed = false;
    }

    public void setBrightness(Brightness brightness){
        this.brightness = brightness;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    public void setService(Service service){
        this.service = service;
    }
    public void setSecurity(boolean isSecurityArmed){
        this.isSecurityArmed = isSecurityArmed;
    }
}

class SmartHomeFacade {
    private SmartHouseSubSystem smartHome; 

    public SmartHomeFacade(SmartHouseSubSystem smartHome){
        this.smartHome = smartHome;
    }

    public void setMovieMode(){
        smartHome.setBrightness(Brightness.BRIGHT);
        smartHome.setTemperature(74);
        smartHome.setSecurity(true);
        smartHome.setService(Service.NETFLIX);
    }

    public void setFocusMode(){
        smartHome.setBrightness(Brightness.DIM);
        smartHome.setTemperature(65);
        smartHome.setSecurity(true);
        smartHome.setService(Service.UNKNOWN);
    }

}

class Client {
    public static void main(String[] args) {
        SmartHomeFacade home = new SmartHomeFacade(new SmartHouseSubSystem());
        home.setMovieMode();
        home.setFocusMode();
    }
}

