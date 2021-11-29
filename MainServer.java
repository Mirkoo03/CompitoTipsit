package com.example;

public class MainServer {

    public static void main(String[] args) {
        

        Server server = new Server();
        server.attendiConnessione();
        server.comunicaConClient();

    }
    
}
