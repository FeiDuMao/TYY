package concurrent;


import lombok.SneakyThrows;

import java.net.*;
import java.util.Scanner;

public class T2 {


    static DatagramSocket sendSocket;


    static {

        try {
            sendSocket = new DatagramSocket(3333, InetAddress.getLocalHost());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        //发送消息线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {

                        Scanner scanner = new Scanner(System.in);
                        String msg = scanner.nextLine();

                        byte[] buffer = msg.getBytes();

                        // 确定发送方的IP地址及端口号，地址为本地机器地址
                        int port = 2222;
                        InetAddress ip = InetAddress.getLocalHost();


                        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, ip, port);
                        // 通过套接字发送数据
                        sendSocket.send(sendPacket);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //接收消息线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {

                        byte[] getBuffer = new byte[1024];

                        DatagramPacket getPacket = new DatagramPacket(getBuffer, getBuffer.length);

                        sendSocket.receive(getPacket);

                        String backMsg = new String(getBuffer, 0, getPacket.getLength());
                        System.out.println("msg:" + backMsg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
