import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//TCP-Server
public class TCPS {

    public static void main(String[] args) throws IOException {
        
        try {
            
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("Server starts successfully.\n");
            
            while(true) {
                
                // new socket created for request
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connecting to this server.");
                // input stream, attached to socket
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // output stream, attached to socket
                OutputStreamWriter outToClient = new OutputStreamWriter(socket.getOutputStream());
                
                String line = null;
                while((line = inFromClient.readLine()) != null) {
                    System.out.println("The server get the message from the clinet: " + line);
                    // change message to uppercase
                    line = line.toUpperCase();
                    System.out.println("The clinet will receive the message: " + line + "\n");
                    outToClient.write(line + "\r\n");
                    outToClient.flush();
                }
                socket.close();
                System.out.println("The current client is disconnected.\n");
            }
            
        } catch (Exception e) {
            
            System.out.println("Can not listen from:" + e);
        
        }
    
    }
    
}
