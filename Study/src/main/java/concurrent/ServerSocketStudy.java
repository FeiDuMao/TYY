package concurrent;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


/**
 * ServerSocket
 */
@NoArgsConstructor
public class ServerSocketStudy {


    @SneakyThrows
    @Test
    public void test1() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8189, 10, InetAddress.getLocalHost());
            Socket accept = serverSocket.accept();
            while (true) {
                InputStream in = accept.getInputStream();
                int bytes = in.read();
                System.out.println(bytes);

//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(serverSocket.accept().getInputStream()));
//                String msg;
//                while ((msg = bufferedReader.readLine()) != null) {
//                    System.out.println(msg+"2");
//                }


            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null)
                serverSocket.close();
        }

    }

    @Test
    @SneakyThrows
    public void test2() {




        Socket socket = new Socket(InetAddress.getLocalHost(),8189);
        while (true) {
            socket.getOutputStream().write(100);
            Thread.sleep(1000);
        }


    }


}
