package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author liviu.bichescu
 */
public class StaticOperationClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");

        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
                
        fluxOut.println("35 + 39");
        String response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("50 - 20");
        response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("10 * 10");
        response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("30 / 10");
        response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);
        
        
        s.close();
    }
}
