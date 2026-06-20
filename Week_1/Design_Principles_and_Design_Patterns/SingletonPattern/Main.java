public class Main {
    public static void main(String[] args){
        Logger log1= Logger.getInstance();
        Logger log2= Logger.getInstance();

        log1.log("This is the first logger instance");
        log2.log("This is the second Logger instance");
        if(log1==log2){
            System.out.println("Only one Logger instance exists");
        }else{
            System.out.println("Multiple logger instances  exists");
        }
    }
}
