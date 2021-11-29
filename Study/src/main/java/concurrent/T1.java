package concurrent;

import java.net.*;
import java.util.Scanner;

/*
多线程接发消息
 */
public class T1 {

    static DatagramSocket getSocket;
    static {
        try {
            getSocket = new DatagramSocket(2222, InetAddress.getLocalHost());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //接收消息线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    while (true) {
                        byte[] buf = new byte[1024];
                        DatagramPacket getPacket = new DatagramPacket(buf, buf.length);

                        getSocket.receive(getPacket);

                        String getMes = new String(buf, 0, getPacket.getLength());
                        System.out.println("msg:" + getMes);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //发送消息线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {
                        Scanner scanner=new Scanner(System.in);
                        String msg = scanner.nextLine();

                        byte[] buffer = msg.getBytes();

                        int port = 3333;
                        InetAddress ip = InetAddress.getLocalHost();

                        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, ip, port);
                        getSocket.send(sendPacket);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
