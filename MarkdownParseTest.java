import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;
import java.nio.file.Path;

import java.nio.file.*;
import java.nio.file.Path.*;
import java.nio.file.Files;
import java.io.IOException;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    

    @Test
    public void getLinksTestThree() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTestFour() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

   
     @Test
    public void testingSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("url.com");
        expected.add("google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(content));
    } 
/*
    @Test
    public void getLinksTestSeven() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("a.com");
        expected.add("b.com");
        expected.add("a.com");
        expected.add("example.com");
        assertEquals(expected, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinksTestEight() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        ArrayList expected = new ArrayList<String>();
        expected.add("https://www.twitter.com");
        expected.add("https://sites.google.com/" + 
            "eng.ucsd.edu/cse-15l-spring-2022/schedule");
        expected.add("https://cse.ucsd.edu/");
        assertEquals(expected, MarkdownParse.getLinks(content));
    } */
}
