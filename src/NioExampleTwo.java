import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {

    public static void main(String[] args) throws IOException {

        //Input files
        String[] inputFiles = {"Resources/file1.txt", "Resources/file2.txt"};

        //files content will be written in this file
        String outputFile = "Resources/outputExampleTwo.txt";

        //Get Channel for output file
        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();

        for(int i = 0; i < inputFiles.length; i++) {

            //Get channel for input file
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            //Trab=nsfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fis.close();
        }
        //finally close the output channel
        targetChannel.close();
        fos.close();
    }

}
