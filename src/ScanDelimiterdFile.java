import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanDelimiterdFile {
    public static void main(String[] args) {
        try{
            String location ="Resources/cars.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);

            ArrayList<String[]> data = new ArrayList<String[]>();

//The hasNext() method verifies whether the file has another line, and
// the nextLine() method reads and returns the next line in the file.
            while(input.hasNext()){
                String line = input.nextLine();
                String[] splitLine = line.split(",");
                data.add(splitLine);
            }

            for(String[] line : data){
//                for(String s : line){
//                    System.out.print(s);
                System.out.println("Car Mame: " + line[0]);
                System.out.println("MPG :" + line[1] );
                System.out.println("Cylinder :" + line[2] );
                System.out.println("Displacement :" + line[3]);
                System.out.println("Horsepower :" + line[4]);
                System.out.println("Weight :" + line[5]);
                System.out.println("Acceleration :" + line[6]);
                System.out.println("Model :" + line[7]);
                System.out.println("Origin :" + line[8]);
                System.out.println("===============================");
            }
//                System.out.println();
//            }
        }catch (FileNotFoundException e){
                 System.out.println("File not found");
                 e.printStackTrace();
                }
    }
}
