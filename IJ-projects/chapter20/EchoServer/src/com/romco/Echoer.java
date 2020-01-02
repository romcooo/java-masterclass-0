package com.romco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;
    
    public Echoer(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String echoString = input.readLine();
                if (echoString.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Received input: " + echoString);
                output.println(echoString);
            }
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
