
public class PrintService {
    private static volatile PrintService uniqueInstance = null;
    private String mode = null; 
    private PrintService(){
        this.mode = "GrayScale"; 
    }

    public static PrintService getInstance(){
        if(uniqueInstance == null){
            synchronized(PrintService.class){
                if(uniqueInstance == null){
                    uniqueInstance == new PrintService();
                }
            }
        }
        return uniqueInstance; 
    }

    public String getPrintStatus(){
        return mode;
    }
    public void setMode(String mode){
        this.mode = mode; 
        System.out.println("Mode changed to "+ mode);
    }
}

class Client {
    public static void main(String[] args) {
        PrintService worker1 = PrintService.getInstance();
        PrintService worker2 = PrintService.getInstance();

        worker1.setMode("Color");
        worker2.setMode("Grayscale");

        String work1mode = worker1.getPrintStatus();
        String work2mode = worker2.getPrintStatus();

        System.out.println(work1mode);
        System.out.println(work2mode);

    }
}
