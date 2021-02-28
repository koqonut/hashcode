package process;

import io.FileUtils;
import io.InputReader;
import util.OutputFile;

import java.util.List;

public class Solution {

    public static final String[] FILES_TEST = {
            //   "src/input/b.txt",
            //    "src/input/c.txt",
            //    "src/input/d.txt",
            "input/e.txt",
            //    "src/input/e.txt",
            //    "src/input/f.txt"
    };

    public static final String[] FILES = {
            "input/a.txt",
            "input/b.txt",
            "input/c.txt",
            "input/d.txt",
            "input/e.txt",
            "input/f.txt"
    };

    public static final String[] FILES_OUT = {
            "output/a.txt",
            "output/b.txt",
            "output/c.txt",
            "output/d.txt",
            "output/e.txt",
            "output/f.txt"
    };

    public static final String[] FILES_OUT_TEST = {
            "output/e.txt",
            /** "output/c.txt",
            "output/d.txt",
            "output/a.txt",
            "output/e.txt",
            "output/f.txt"
            */
    };

    public static void main(String[] args) {


        String[] files = FILES;
        String[] files_out = FILES_OUT;

/*
        String[] files = FILES_TEST;
        String[] files_out = FILES_OUT_TEST;
 */

        System.out.println(System.getProperty("user.dir"));
        for (int i = 0; i < files.length; i++) {
            System.out.println("-------------------------------------------");
            String file = files[i];
            long time = System.currentTimeMillis();
            List<String> lines = FileUtils.readFile(file);

            CityMap cityMap = InputReader.createFromFile(lines);

            BruteForce bf = new BruteForce();
            OutputFile of = bf.solve(cityMap);

            FileUtils.writeToFile(files_out[i], of.toString());
            long endTime = System.currentTimeMillis();
            System.out.println("Time to process file: " + file + " is " + (endTime - time) + "ms");
        }
    }
}
