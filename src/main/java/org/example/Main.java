package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        // Creating server
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080.....");



        while (true){


            //Getting connect info
            Socket clientSoceket = server.accept();
            InputStreamReader inputStreamReade = new InputStreamReader(clientSoceket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReade);
            String line  = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }


            try (Socket socket = server.accept()) {



                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n\r\n";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));}



        }


    }


}