module Demo
{
    sequence<string> StringSeq;
    interface Printer
    {
        void printString(string s);
        int fibo(int a, int b);

    }


    interface Callback{
        void notifyCallback();
    }
    interface ChatManager{

        void subscribe(Callback* callback);

        StringSeq getState();

        void sendMessage(string msg);
    }

}