import java.io.*;
import java.net.*;
public class client {
    public static void main(String args[]){
        //if (args.length != 2) {
            //System.err.println("Usage: java EchoClient <host name> <port number>");
            //System.exit(1);
        //}

        String hostName = "localhost";
        int portNumber = 6000;

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            System.out.println("Type JOKE to receive a joke");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("here1");
                System.out.println("here2");
                StringBuilder finalInput = new StringBuilder();
                finalInput.append(in.readLine());
                finalInput.append(in.readLine());
                String s = finalInput.toString();
                System.out.println("echo: " + s);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
