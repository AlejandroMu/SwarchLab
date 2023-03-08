import java.util.Arrays;

import com.zeroc.Ice.Current;

import Demo.ChatManagerPrx;

public class CallbackImp implements Demo.Callback {

    private ChatManagerPrx server;

    CallbackImp(ChatManagerPrx m) {
        server = m;
    }

    @Override
    public void notifyCallback(Current current) {
        System.out.println("notifyCall");
        String state[] = server.getState();

        System.out.println("Callback exec: " + Arrays.toString(state));
    }

}
