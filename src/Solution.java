import java.util.List;

public class Solution {

    public static final String[] FILES = {
            //   "src/input/a_example.txt",
            //     "src/input/b_read_on.txt",
            //    "src/input/c_incunabula.txt",
            "src/input/d_tough_choices.txt"
            //    "src/input/e_so_many_books.txt",
            //    "src/input/f_libraries_of_the_world.txt"
    };

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        for (String file : FILES) {
            long time = System.currentTimeMillis();
            List<String> lines = FileUtils.readFile(file);

            //TODO: replace ob with relevant classes
            Object ob = InputReader.createFromFile(lines);


            //This is where the magic happens


            //TODO: replace input with the output object
            FileUtils.writeToFile(file+"out",OutputWriter.convertToOutput("a"));
            long endTime = System.currentTimeMillis();
            System.out.println("Time to process file: "+file+" is " + (endTime-time)+ "ms");
        }
    }
}
