
import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Socket soc= null;
        Long d1 = System.currentTimeMillis();
        Long d2 = System.currentTimeMillis();

         System.out.println(d1);
//        while(true){
//            long t = System.currentTimeMillis()-d1;
//            if(t>=6000){
//                System.out.print("test : "+t);
//
//                d1=System.currentTimeMillis();
//            }
//
//        }
       /* try {
            soc = new Socket("127.0.0.1",6754);
            transferfileClient t=new transferfileClient(soc);
            t.displayMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
