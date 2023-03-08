import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {
    public void printString(String msg, com.zeroc.Ice.Current current) {

        System.out.println(msg);
    }

    @Override
    public int fibo(int a, int b, Current current) {
        try {
            long id = Thread.currentThread().getId();
            System.out.println("Server Id: " + id);
            Thread.sleep(a);
            System.out.println("Value: " + a);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a + b;
    }
}
