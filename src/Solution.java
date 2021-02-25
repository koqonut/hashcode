import java.util.List;

public class Solution {

    public static final String[] FILES = {
            "src/input/b.txt",
            "src/input/c.txt",
            "src/input/d.txt",
            "src/input/a.txt",
            "src/input/e.txt",
            "src/input/f.txt"
    };

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        for (String file : FILES) {
            long time = System.currentTimeMillis();
            List<String> lines = FileUtils.readFile(file);

            //TODO: replace ob with relevant classes
            CityMap cityMap= InputReader.createFromFile(lines);


            //This is where the magic happens


            //TODO: replace input with the output object
         //   FileUtils.writeToFile(file+".out",OutputWriter.convertToOutput("a"));
            long endTime = System.currentTimeMillis();
            System.out.println("Time to process file: "+file+" is " + (endTime-time)+ "ms");
        }
    }
}
