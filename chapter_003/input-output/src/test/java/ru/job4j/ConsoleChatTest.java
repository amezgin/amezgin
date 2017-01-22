package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class ConsoleChatTest.
 */
public class ConsoleChatTest {

    /**
     * Test chat with command "закончить".
     *
     * @throws IOException IOException
     */
    @Test
    public void whenUserInputEndThenExit() throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        ByteArrayInputStream bais = new ByteArrayInputStream((String.format("%s",
                "закончить").getBytes()));
        System.setIn(bais);
        consoleChat.init();
        Scanner sc = new Scanner(new FileReader("./log.txt"));
        String result = "";
        while (sc.hasNextLine()) {
            result = sc.nextLine();
        }
        assertThat(result, is("user: закончить"));
    }

    /**
     * Test chat with command "стоп".
     *
     * @throws IOException IOException
     */
    @Test
    public void whenUserInputStopThenReturnTrue() throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        String separator = System.getProperty("line.separator");
        ByteArrayInputStream bais = new ByteArrayInputStream((String.format("%s%s%s%s%s%s%s",
                "вап", separator,
                "стоп", separator,
                "sdg", separator,
                "закончить").getBytes()));
        System.setIn(bais);
        consoleChat.init();
        assertThat(consoleChat.isStop(), is(true));
    }

    /**
     * Test chat with command "продолжить".
     *
     * @throws IOException IOException
     */
    @Test
    public void whenUserInputContinueThenReturnFalse() throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        String separator = System.getProperty("line.separator");
        ByteArrayInputStream bais = new ByteArrayInputStream((String.format("%s%s%s%s%s%s%s",
                "вап", separator,
                "стоп", separator,
                "продолжить", separator,
                "закончить").getBytes()));
        System.setIn(bais);
        consoleChat.init();
        assertThat(consoleChat.isStop(), is(false));
    }

    /**
     * Test chat.
     *
     * @throws IOException IOException
     */
    @Test
    public void whenUserInputTextThenReturnLog() throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        String separator = System.getProperty("line.separator");
        ByteArrayInputStream bais = new ByteArrayInputStream((String.format("%s%s%s%s%s%s%s",
                "стоп", separator,
                "стоп", separator,
                "стоп", separator,
                "закончить").getBytes()));
        System.setIn(bais);
        consoleChat.init();
        Scanner sc = new Scanner(new FileReader("./log.txt"));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(String.format("%s%s", sc.nextLine(), separator));
        }
        String result = sb.toString();
        String checked = String.format("user: стоп%suser: стоп%suser: стоп%suser: закончить%s", separator, separator,
                separator, separator);
        assertThat(result, is(checked));
    }
}