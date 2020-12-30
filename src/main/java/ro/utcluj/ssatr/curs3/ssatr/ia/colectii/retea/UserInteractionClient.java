package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author liviu.bichescu
 */

public class UserInteractionClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");
         //...... 
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        
        Scanner in = new Scanner(System.in);
        System.out.println("Doriti o generare random?");
        System.out.println("Introduceti DA sau NU: ");
        String userInput = in.nextLine();
        
        String input = "";
        
        if (userInput.equals("DA")) {
            String selectedOperation = "";
            String[] mathOperations = {"+", "-", "*", "/"};
            
            Random generator = new Random();
            int randomIndex = generator.nextInt(mathOperations.length);
            selectedOperation = mathOperations[randomIndex];
                    
            System.out.println("Introduceti primul numar:");
            String firstNumber = in.next();
            System.out.println("Introduceti al doilea numar:");
            String secondNumber = in.next();
            
            input = firstNumber + " " + selectedOperation + " " + secondNumber;
        } else {
            System.out.println("Introduceti operatia:");
            input = in.nextLine();
        }
        
        fluxOut.println(input);
        String response = fluxIn.readLine();
        System.out.println(response);
                
        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);
        
        
        s.close();
    }
}
