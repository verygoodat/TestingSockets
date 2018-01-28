package Packet;

import java.util.HashMap;

public class PacketManager {
    private static HashMap<Integer, Class<? extends Packet>> packets = new HashMap<>();
    static
    {
        packets.put(120, Greetings.class);
    }

    public static Packet getPacketById(int i)
    {
        try {
            return packets.get(i).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

