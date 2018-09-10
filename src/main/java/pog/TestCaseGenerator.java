package pog;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestCaseGenerator {
    public static Long get(int problemId) {
        try (Stream<Path> files = Files.list(Paths.get("src/test/resources/testCases/" + problemId))) {
            return files.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }
    public static void main(String[] args) throws IOException {
        String test = FileUtils.readFileToString(new File("src/test/java/_138Test.java"), "utf-8");
        int[] problems = new int[]{1021};
        for (int i : problems) {
            String k = test.replace("138", String.valueOf(i)).replace("value = 2", "value = " + String.valueOf(get(i) / 2));
            FileUtils.writeStringToFile(new File("src/test/java/_" + i + "Test.java"), k, "utf-8");
        }
    }
}
