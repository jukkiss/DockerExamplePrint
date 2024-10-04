import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class JukkaDockerTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void testAskUserName() {
        String input = "Jukka";
        provideInput(input);

        Scanner scanner = new Scanner(System.in);
        String userName = JukkaDocker.askUserName(scanner);

        assertEquals("Jukka", userName);
    }

    @Test
    public void testPrintWelcomeMessage() {
        String userName = "Jukka";
        JukkaDocker.printWelcomeMessage(userName);

        // Normalize both expected and actual outputs
        String expectedOutput = "Your name is Jukka, welcome to Docker!";
        String actualOutput = getOutput().trim();  // Trim the actual output to handle extra line endings

        assertEquals(expectedOutput, actualOutput);
    }
}
