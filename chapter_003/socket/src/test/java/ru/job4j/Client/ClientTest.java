package ru.job4j.Client;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class ClientTest.
 */
public class ClientTest {

    /**
     * Test method loadProperties().
     *
     * @throws IOException IOException
     */
    @Test
    public void whenLoadPropertiesThenSetPort() throws IOException {
        Client client = new Client();
        client.loadProperties();
        int result = client.getPort();
        int checked = 8189;
        assertThat(result, is(checked));
    }

    /**
     * Test method loadProperties().
     *
     * @throws IOException IOException
     */
    @Test
    public void whenLoadPropertiesThenSetHost() throws IOException {
        Client client = new Client();
        client.loadProperties();
        String result = client.getHost();
        String checked = "127.0.0.1";
        assertThat(result, is(checked));
    }

    /**
     * Test method loadProperties().
     *
     * @throws IOException IOException
     */
    @Test
    public void whenLoadPropertiesThenSetCurrentDirectory() throws IOException {
        Client client = new Client();
        client.loadProperties();
        String result = client.getCurrentDirectory().getAbsolutePath();
        String checked = "d:\\testClient";
        assertThat(result, is(checked));
    }
}