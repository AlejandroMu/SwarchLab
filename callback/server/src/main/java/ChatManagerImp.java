import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import com.zeroc.Ice.Current;

import Demo.CallbackPrx;

public class ChatManagerImp implements Demo.ChatManager {

    private List<String> messages;
    // Semaphore mSemaphore = new Semaphore(1);
    private CallbackPrx callbackPrx;

    ChatManagerImp() {
        messages = new ArrayList<>();
    }

    @Override
    public void subscribe(CallbackPrx callback, Current current) {
        System.out.println("subscribe");
        this.callbackPrx = callback;
    }

    @Override
    public String[] getState(Current current) {
        System.out.println("GetState");
        String[] state = new String[messages.size()];

        for (int i = 0; i < state.length; i++) {
            state[i] = messages.get(i);
        }
        return state;
    }

    @Override
    public void sendMessage(String msg, Current current) {

        new Thread(() -> {
            System.out.println("new Message: " + msg);
            messages.add(msg);
            try {

                Thread.sleep(2000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            callbackPrx.notifyCallback();
        }).start();
    }

}
