public class Server {
    public static void main(String[] args) {
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "server.cfg")) {
            String value = communicator.getProperties().getProperty("name");
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Service");

            ChatManagerImp chatManagerImp = new ChatManagerImp();
            adapter.add(chatManagerImp, com.zeroc.Ice.Util.stringToIdentity("ChatManager"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}