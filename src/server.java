import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server{
    public static void main(String args[]) throws IOException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        ServerSocket serverSocket = new ServerSocket(6000);
        while(true){
            service.execute(new serverConnections(serverSocket.accept()));
        }
    }
}
