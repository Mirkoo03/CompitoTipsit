package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import javax.lang.model.type.MirroredTypesException;

public class Client2 {

    Socket mySocket;
    BufferedReader inputTastiera;
    BufferedReader inputDalServer;
    String getStringaDigitata;
    String getStringaDigitataDalServer;
    DataOutputStream outputVersoServer;
    ArrayList < String > elencoMessaggi = new ArrayList<>();


    public Socket connettiClientConServer()
    {
        try {
            
            inputTastiera = new BufferedReader(new InputStreamReader(System.in));

            mySocket = new Socket("LocalHost", 6789);

            outputVersoServer = new DataOutputStream(mySocket.getOutputStream());
            inputDalServer = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

        } catch (Exception e) {

            e.getMessage();
            
        }

        return mySocket;

    }


    public void comunica()
    {
        for(;;)
        {

            try {
            
                System.out.println("Inserisci un messaggio da mandare al SERVER --> ");                
                getStringaDigitata = inputTastiera.readLine();  //input dell'utente
                if(getStringaDigitata.equals("lista") || getStringaDigitata.equals("LISTA"))
                {

                    outputVersoServer.writeBytes(getStringaDigitata); //invio messaggio al server
                    mySocket.close();//chiudo il canale di comunicazione appena inserisco lista

                }
    
                System.out.println("Ok, ho ricevuto il messaggio, lo inoltro al SERVER.....");
                outputVersoServer.writeBytes(getStringaDigitata + "\n");
    
               
                System.out.println("Il SERVER risponde ---> " + " ok, aggiunto!");
                
                
                
    
    
            } catch (Exception e) {
               
                e.getMessage();
    
            }



        }

        


    }
    
}
