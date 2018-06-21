import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


//TCP-Client
public class TCPC {

    public static void main(String[] args) throws IOException {
        
        try {
            
            Socket socket = new Socket("127.0.0.1", 10086);
            System.out.println("Client starts successfully.\n");
            // user input stream
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            // output stream attached to socket
            OutputStreamWriter outToServer = new OutputStreamWriter(socket.getOutputStream());
            // input stream attached to socket
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String line = null;
            while (!(line = inFromUser.readLine()).equals("end")) {
                // send to server
                outToServer.write(line + "\r\n");
                outToServer.flush();
                // get from server
                line = inFromServer.readLine();
                System.out.println("The response message from the server is: " + line + "\n");
            }
            socket.close();
            System.out.println("Finish.");
            
        } catch (Exception e) {
            
            System.out.println("Can not listen to:" + e);
        
        }
        
    }
    
}
