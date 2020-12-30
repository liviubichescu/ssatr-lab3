/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs3.ssatr.ia.colectii.retea;

import java.net.*;
import java.io.*;
import java.time.Instant;
import java.util.StringTokenizer;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4050);

        while (true) {
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");

            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

            String line = "";
            while (!line.equals("close connection")) {
                line = fluxIn.readLine();
                System.out.println("Am primti de la client: " + line);
                if (!line.equals("close connection")) {
                    String[] rLine = line.split(" ");

                    int arg1 = Integer.parseInt(rLine[0]);
                    String operation = rLine[1];
                    int arg2 = Integer.parseInt(rLine[2]);

                    int res = 0;

                    switch (operation) {
                        case "+":
                            res = arg1 + arg2;
                            break;
                        case "*":
                            res = arg1 * arg2;
                            break;
                        case "-":
                            res = arg1 - arg2;
                            break;
                        case "/":
                            res = arg1 / arg2;
                            break;
                        default:
                    }
                    line = "Result = " + res;
                    fluxOut.println(line);
                }
            }

            s.close();
        }
    }
}
