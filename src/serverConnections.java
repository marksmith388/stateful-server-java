import java.io.*;
import java.net.*;
public class serverConnections extends Thread{
    private Socket socket = null;
    public serverConnections(Socket s){
        this.socket = s;
    }
    @Override
    public void run() {
        //if (args.length != 1) {
        //System.err.println("Usage: java EchoServer <port number>");
        //System.exit(1);
        //}

        int portNumber = 5000;

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server received: "+ inputLine);
                if(inputLine.equals("JOKE")) {
                    out.println("Help I'm turning into a cat! \nDon't ask meow");
                    System.out.println("Help I'm turning into a cat! \nDon't ask meow");
                }else{
                    out.println("Please type JOKE to request a joke");
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber
                    + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
