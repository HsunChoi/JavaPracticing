import java.io.*;
import java.util.*;

/**
 * Created by cuixun on 5/13/15.
 */
public class ConcordGenerator {
    File file;

    public ConcordGenerator() {

    }

    public ConcordGenerator(File file) {
        this.file = file;
    }


    /**
     * not use regular expression
     * @param file
     * @return
     */
    HashMap generateFile(File file) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        int lineCount = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            String s;
            while ((s = reader.readLine()) != null) {
                int i = 0;
                int j;
                for (j = 0; j < s.length(); j++) {
                    if (j > 0 && j < s.length() - 1 && s.charAt(j) == '.' && Character.isDigit(s.charAt(j - 1))
                            && Character.isDigit(s.charAt(j + 1))) {

                    } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                        String tmp = s.substring(i, j);
                        if (tmp != "" && !tmp.isEmpty()) {
                            if (map.containsKey(tmp)) {
                                List<Integer> list = map.get(tmp);
                                list.set(0, list.get(0) + 1); // add one if we find the same word
                                list.add(lineCount);// add the line which we find the word
                                map.put(tmp, list); // put the list back
                            } else {
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(1);
                                list.add(lineCount);
                                map.put(tmp, list);
                            }
                        }
                        i = j + 1;
                    }
                }
                //add the last word in the map
                if (i < j) {
                    String tmp = s.substring(i, j);
                    if (map.containsKey(tmp)) {
                        List<Integer> list = map.get(tmp);
                        list.set(0, list.get(0) + 1); // add one if we find the same word
                        list.add(lineCount);// add the line which we find the word
                        map.put(tmp, list); // put the list back
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(1);
                        list.add(lineCount);
                        map.put(tmp, list);
                    }
                }
                lineCount++;
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("No such file was founded, Please check the path of the file is correct");
        }
        return map;
    }


    /**
     * Use regular expression
     * @return
     */
    HashMap generateFile() {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        if (file == null) {
            return null;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            String s = reader.readLine();
            String[] arr;
            int line = 1;
            while (s != null) {
                arr = s.split("[ ,.:<>\\[\\]!?\"@#$%^&*()]");
                putIntoMap(map, arr, line);
                line++;
                s = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    void putIntoMap(Map<String, List<Integer>> map, String[] a, int line) {
        for (String s : a) {
            if (s != null && s.length() != 0) {
                if (map.containsKey(s)) {
                    List<Integer> list = map.get(s);
                    list.set(0, list.get(0) + 1);
                    list.add(line);
                    map.put(s, list);
                } else {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(1);
                    list.add(line);
                    map.put(s, list);
                }
            }
        }
    }


    /**
     * print the result directly
     *
     * @param map
     */
    void out(HashMap<String, List<Integer>> map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            List<Integer> list = map.get(s);
            System.out.print(s + ": ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    /**
     * write the .txt file
     */
    void write(HashMap<String, List<Integer>> map) {
        Iterator iterator = map.keySet().iterator();
        /**
         *         change the path where you want the result txt located
         */
        String outputPath = "/Users/cuixun/IdeaProjects/JavaPracticing/src/com/xun/java/practing/app/GenerConcord/Doc/result";
        FileWriter writer = null;
        try {
            File f = new File(outputPath);
            f.delete();
            if (!f.exists()) {
                f.createNewFile();
            }
            writer = new FileWriter(f, true);
            while (iterator.hasNext()) {
                String s = (String) iterator.next();
                List<Integer> list = map.get(s);
                writer.write(s + ": ");
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i) + ", ");
                }
                writer.write("\r");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not write");
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException("Close Failed");
                }
        }
    }
}
