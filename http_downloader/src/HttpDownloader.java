import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {
    private static final int BUFFER_SIZE=4096;
    public static void downloadFile(String fileUrl,String saveDir) throws IOException {
        URL url=new URL(fileUrl);
        HttpURLConnection httpURLConnection= (HttpURLConnection)  url.openConnection();
        int responseCode=httpURLConnection.getResponseCode();
        if (responseCode==HttpURLConnection.HTTP_OK){
            String filename="";
            System.out.println("test 1");
            String disposition=httpURLConnection.getHeaderField("Content-Disposition");
            System.out.println(disposition);
            String content= httpURLConnection.getContent().toString();
            int contentLength = httpURLConnection.getContentLength();
            if (disposition!=null){
                System.out.println("test2");
                int index=disposition.indexOf("filename=");
                if (index > 0) {
                    filename=disposition.substring(index+10,disposition.length()-1);
                }else{
                    filename=fileUrl.substring(filename.lastIndexOf("/")+1,fileUrl.length());
                }
                System.out.println("Content_type"+ content);
                System.out.println("Content_Disposition"+ disposition);
                System.out.println("Content_Length"+contentLength);
                System.out.println("fileName"+ filename);
                InputStream inputStream=httpURLConnection.getInputStream();
                String saveFilePath=saveDir+ File.separator+ filename;
                FileOutputStream outputStream=new FileOutputStream(saveFilePath);
                int bytesRead=-1;
                byte[] buffer=new byte[BUFFER_SIZE];
                while((bytesRead=inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,bytesRead);
                }
            }
        }


    }
}
