import Packet.*;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler extends Thread {
    private Socket socket;
    public ClientHandler(Socket socket)
    {
        this.socket = socket;
        start();
    }
    public void run()
    {
        while (true)
        {   try {
            if (!isInterrupted())
            {DataInputStream dis = new DataInputStream(socket.getInputStream());
            if (dis.available() > 0)
            {
                Packet p = PacketManager.getPacketById(dis.readShort());
                p.receive(dis);
                p.handle();

            }} } catch (SocketException se)
              {} catch (IOException e)
                {} finally {
            end();
        }
        }
    }

    private void end()
    {
        interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

