package Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Greetings extends Packet{
    private String nickname;
    public Greetings(){}
    public Greetings(String nickname)
    {
        this.nickname = nickname;
    }
    @Override
    public short getId() {
        return 120;
    }

    @Override
    public void send(DataOutputStream dos) {

    }

    @Override
    public void receive(DataInputStream dis) {
        try {
           nickname = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle() {
    System.out.print("Hello to " + nickname);
    }
}
