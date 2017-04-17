package client;

import java.net.InetAddress;

public class Client {

    private static final String USAGE = "java client.Client <server_host> <server_port>";

    public static void main(String... args) {

        InetAddress host;
        int port;

        try {
            host = InetAddress.getByName(args[0]);
            port = Integer.getInteger(args[1], -1);
            if (-1 == port)
                throw new Exception();
        } catch (Exception e) {
            System.out.println(USAGE);
            return;
        }

        new Client(host, port);
    }


    public Client(InetAddress serverAddress, int serverPort) {

    }


}
