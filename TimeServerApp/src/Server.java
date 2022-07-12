import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Server {
    public static  void main(String [] args){
        System.out.println("Server side started");
        try{
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(5000));
            while(true){
                System.out.println("waiting for request!!!");
                SocketChannel socketChannel=serverSocketChannel.accept();
                if (socketChannel!= null){
                    String dateMessage = new Date(System.currentTimeMillis()).toString();
                    ByteBuffer byteBuffer=ByteBuffer.allocate(64);
                    byteBuffer.put(dateMessage.getBytes());
                    byteBuffer.flip();
                    while(byteBuffer.hasRemaining()){
                        socketChannel.write(byteBuffer);
                    }
                    System.out.println("sent date and time"+ dateMessage);
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
