import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

public class Server {
    private static ServerSocket serverSocket;
    private static HashMap<ClientHandler, Socket> users = new HashMap<>();
    public static void main(String[] args) {
      connect();
      handle();
    }

    private static void connect()
    {
        try {
            serverSocket = new ServerSocket(9999);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle()
    {
        while (true)
        {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler c = new ClientHandler(socket);
            } catch (SocketException se){} catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

