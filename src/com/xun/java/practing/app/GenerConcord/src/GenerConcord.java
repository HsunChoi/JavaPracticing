import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuixun on 5/13/15.
 * the output will be words followed by several digits, the first digit will be the numbers that the word's occurrence
 * the following digits will be the line numbers where the word occurs.
 */
public class GenerConcord {
    public static void main(String[]args){
        /**
         * Please change the text path here;
         */
        final String filePath = "/Users/cuixun/IdeaProjects/JavaPracticing/src/com/xun/java/practing/app/GenerConcord/Doc/text";
        File file = new File(filePath);
        ConcordGenerator c = new ConcordGenerator(file);
        HashMap<String, List<Integer>> map = c.generateFile(c.file);
        HashMap<String, List<Integer>> map1 = c.generateFile();
        c.out(map1);
        c.write(map);
    }


}
