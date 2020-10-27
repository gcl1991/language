package args.finish;

public class ArgsUseDemo {
    public static void main(String[] args) throws ArgsException {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);}
        catch(ArgsException e){
            System.out.printf("Argument error:%s%n", e.errorMessage());
        }
    }

    public static void executeApplication(boolean logging,int port,String directory){

    }
}
