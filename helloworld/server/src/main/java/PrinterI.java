import com.zeroc.Ice.Current;

public class PrinterI implements Demo.Printer {

    public void printString(String msg, com.zeroc.Ice.Current current) {
        System.out.println(msg);
    }
}
