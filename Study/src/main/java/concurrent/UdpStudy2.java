package concurrent;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


/**
 * udp学习
 * 不需要建立连接
 */
public class UdpStudy2 {


    static int port1=3333;
    static int port2=4444;


    @SneakyThrows
    public static void main(String[] args) {

        DatagramSocket socket=new DatagramSocket(port1, InetAddress.getLocalHost());

        new Thread(()->{
            while (true){
                try {
                    byte[] buf = new byte[1024];
                    DatagramPacket getPacket = new DatagramPacket(buf, buf.length);
                    socket.receive(getPacket);

                    String msg = new String(buf, 0, getPacket.getLength());
                    System.out.println(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },"receive").start();

        new Thread(()->{
            try {
                while (true) {
                    Scanner scanner=new Scanner(System.in);
                    String msg = scanner.nextLine();
                    byte[] buffer = msg.getBytes();

                    DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), port2);
                    socket.send(sendPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"send").start();


    }












}
