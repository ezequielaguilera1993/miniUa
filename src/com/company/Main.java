package com.company;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        int port = 8081;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Serer running on: "+port);

        while (true) {
            Socket client=serverSocket.accept();
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            StringBuilder request = new StringBuilder();

            String line;
            line = br.readLine();
            while (!line.isBlank()) {
                request.append(line+"\r\n");
                line = br.readLine();
            }
            System.out.println("message");
            String firstLine= request.toString().split("\n")[0];

            String verbe = firstLine.split(" ")[0];

            System.out.println(verbe);

            OutputStream clientOuput = client.getOutputStream();
            clientOuput.write("HTTP/1.1 200 OK \r\n".getBytes());
            clientOuput.write("\r\n".getBytes());
            clientOuput.write("Welcome babe".getBytes());
            clientOuput.flush();
            clientOuput.close();
        }


    }
}

