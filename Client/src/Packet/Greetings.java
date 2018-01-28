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
        System.out.print("GOT IT");
        try {
            dos.writeUTF(nickname);
            System.out.println("Nickname "+nickname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(DataInputStream dis) {

    }

}
