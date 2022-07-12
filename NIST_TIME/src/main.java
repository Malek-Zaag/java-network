import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class main {
    public static  void main (String [] args){
        int port =13;
        String hostname="time.nist.gov";
        try(Socket socket=new Socket(hostname,port)){
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
            int character;
            StringBuilder string = new StringBuilder();
            while((character=inputStreamReader.read()) != -1){
                string.append((char) character);
            }
            System.out.println(string);
        }catch(UnknownHostException unknownHostException){
            System.out.println("ERROR"+ unknownHostException.getMessage());
        }catch (IOException ioException){
            System.out.println("ERROR"+ ioException.getMessage());
        }
    }


}
