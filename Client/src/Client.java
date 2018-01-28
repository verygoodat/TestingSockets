import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

import Packet.*;

import javax.xml.crypto.Data;

public class Client {
    private static Scanner sc = new Scanner(System.in);
    private static Socket client;
    private static Random r = new Random();
    public static int status = 0;
    public static String nickname;
    public static void main(String[] args) {
    connect();
    handle();
//   end();
    }



    private static void connect()
    {
        try {
            client = new Socket("localhost",9999);
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            System.out.print("Подключился... Вы не авторизованы, введите ник: ");
            String sl = sc.nextLine();
            sendPacket(new Greetings(sl));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendPacket(Packet packet)
    {
            try {

                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                System.out.println("Номер пакета: "+packet.getId());
                System.out.print(dos.size());
                dos.writeShort(12);
                System.out.println("Размер потока: "+dos.size());
                dos.writeUTF("nick");
                dos.flush();
                System.out.println("Размер потока: "+dos.size());
            } catch (SocketException se) {} catch (IOException e) {
                e.printStackTrace();
            }
    }
    private static void handle()
    {
//        Scanner sc = new Scanner(System.in);
//        while (true){
//        if (sc.hasNextLine())
//        {
//            String line = sc.nextLine();
//            sendPacket(new Greetings("nickname"));
//        }
//        else {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        }

//                String ls = sc.nextLine();



        }


    private static void end()
    {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
