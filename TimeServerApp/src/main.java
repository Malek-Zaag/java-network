import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class main {
    public static  void main (String[] args){
        SocketAddress socket=new InetSocketAddress("127.0.0.1",5000);
        try (SocketChannel socketChannel=SocketChannel.open(socket)){
            System.out.println("socket channel opened");
            ByteBuffer byteBuffer=ByteBuffer.allocate(64);
            int byteRead =socketChannel.read(byteBuffer);
            while(byteRead >0){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.println((char)byteBuffer.get());
                }
                byteRead= socketChannel.read(byteBuffer);
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
