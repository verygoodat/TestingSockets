package Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public abstract class Packet {

    public abstract short getId();
    public abstract void send(DataOutputStream dos); //Отправить письмо всем вокруг
    public abstract void receive(DataInputStream dis); //Принять письма от всех вокруг
    public abstract void handle();
}
