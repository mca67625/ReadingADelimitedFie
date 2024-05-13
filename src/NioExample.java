import java.io.FileOutputStream;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args) throws Exception, IOException, FileNotFoundException {

        // initializing two fies in Arrays
        String[] inputFiles = {"Resources/file1.txt","Resources/file2.txt"};

        // Specify out file with path location
        //Files contents will be written in these files
        String outputFile = "Resources/nioOutput.txt";

        //Get Channel for destination or outputFile
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        for (int i = 0; i < inputFiles.length; i++) {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();
            long size = inputChannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int) size);
            System.out.println((char)buf.get());
            while (inputChannel.read(buf)>0){
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.print((char)buf.get());
                    targetChannel.write(buf);
                }
            }

        }
    }
}
