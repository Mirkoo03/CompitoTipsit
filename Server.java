package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ServerSocket server;
    Socket utente;
    //String getString; //arrayList di stringhe per memorizzare cio che manda il client
    ArrayList < String > listaMessaggiClient = new ArrayList<>();
    BufferedReader inputDalClient;
    DataOutputStream outputVersoClient;
    String stringaUtente;
    

    public Socket attendiConnessione()
    {

        try {
            
            System.out.println("Il SERVER attende la connessione");
            server = new ServerSocket(6789);
            utente = server.accept();
            server.close();

            inputDalClient = new BufferedReader(new InputStreamReader(utente.getInputStream()));
            outputVersoClient = new DataOutputStream(utente.getOutputStream());

        } catch (Exception e) {
                
            e.getMessage();


        }

        return utente;
    }


    public void comunicaConClient()
    {
        try {

            System.out.println("Ciao utente! Ben arrivato!, connessione effettuata ");
            
            

            for(;;)
            {
                System.out.println("Inserisci la nota da memorizzare o digita LISTA per visualizzare le note salvate");
               
                stringaUtente = inputDalClient.readLine();
                //stringa aggiunta alla lista 
                
                if(!stringaUtente.equals("lista") || !stringaUtente.equals("LISTA")) //se l'utente NON inserisce lista o LISTA
                {
                    
    
                    listaMessaggiClient.add(stringaUtente); //aggiungo la stringa all'array
                    System.out.println("Messaggio arrivato, nota salvata");
                   
    
    
                }
                else { //se l'utente inserisce lista o LISTA
    
                    for(int i = 0; i < listaMessaggiClient.size(); i++)
                    {
    
                        outputVersoClient.writeBytes(listaMessaggiClient.get(i) + " ");
                        
    
                    }
    
                    outputVersoClient.writeBytes("\n");
                    utente.close(); //chiusura del client
    
                }
    
    
               
            
               
            }   
                
    
        } catch (Exception e){

            e.getMessage();


        }
    
    }
    
}
