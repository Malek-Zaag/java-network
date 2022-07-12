import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class main {
    public static  void main (String [] args){
        if (args.length <1){
            return;
        }
        String domainName=args[0];
        int port=43;
        String hostname="whois.internic.net";
        try(Socket sck = new Socket(hostname,port)){
            OutputStream outputStream=sck.getOutputStream();
            InputStream inputStream=sck.getInputStream();
            PrintWriter printWriter=new PrintWriter(outputStream,true);
            printWriter.println(domainName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line= reader.readLine())!= null){
                System.out.println(line);
            }
        }catch(UnknownHostException unknownHostException){
            System.out.println("ERROR"+ unknownHostException.getMessage());
        }catch (IOException exception){
            System.out.println("ERROR"+ exception.getMessage());
        }
    }
}
