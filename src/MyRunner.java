import javax.naming.Name;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyRunner {
    public static void main(String[] args) {
        try{
            String location = "Resources/CourseData.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);

            ArrayList <Course> data = new ArrayList<Course>();

            while(input.hasNext()){
                String line = input.nextLine();
                String[] splitLine = line.trim().split(",");
                Course course = new Course(splitLine[0], splitLine[1], splitLine[2]);

//                Course cObj = new Course();
//                cObj.setCode(splitLine[0]);
//                cObj.setCourse_name(splitLine[1]);
//                cObj.setInstructor(splitLine[2]);
//                data.add(cObj);

                data.add(course);
            }

            for(Course course : data){
                System.out.println("Code: "+ course.getCode() +" | "+ "Name: " + course.getCourse_name() +" | "+ " Instructor Name: " + course.getInstructor());
                System.out.println("===============================");
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
