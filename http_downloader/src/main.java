import java.io.IOException;

public class main {
    public  static  void main(String[ ] args){
        String fileurl="https://d3.7-zip.org/a/7z2200-x64.exe";
        String saveDir="C:\\Users\\Malek\\Desktop";
        try{
            HttpDownloader.downloadFile(fileurl,saveDir);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
