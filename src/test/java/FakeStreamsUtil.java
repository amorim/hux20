import model.TestCase;
import org.apache.commons.io.FileUtils;

import java.io.*;

class FakeStreamsUtil {

    static TestCase loadTestCase(int testCaseNumber, int problemNumber) {
        try {
            String[] in = FileUtils.readFileToString(new File("src/test/resources/testCases/" + problemNumber + "/test" + testCaseNumber + ".in"), "utf-8").split("\r\n|\r|\n");
            String[] out = FileUtils.readFileToString(new File("src/test/resources/testCases/" + problemNumber + "/test" + testCaseNumber + ".out"), "utf-8").split("\r\n|\r|\n");
            return new TestCase(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static InputStream testCaseInstance(int testCaseNumber, int problemNumber) {
        try {
            return new FileInputStream(new File("src/test/resources/testCases/" + problemNumber + "/test" + testCaseNumber + ".in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static ByteArrayOutputStream byteArrayInstance() {
        return new ByteArrayOutputStream();
    }

}
