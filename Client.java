package com.example;

import java.io.*;
import java.net.*;


public class Client {

    DataInputStream input;
    DataOutputStream output;

    

    protected Socket connettiClient() throws IOException
    {
        Socket socket = new Socket("LocalHost", 6789);

        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());

        return socket;

    }


}

