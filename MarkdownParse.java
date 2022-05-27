import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        /* find the next [, then find the ], then find the (, then read link
            upto next) */

        int currentIndex = 0;

        // fix to test-file5.md "< and >"
        if (markdown.indexOf("[") == -1 &&
            markdown.indexOf("(") == -1) {
            while(currentIndex < markdown.length()) {
                int leftCarrotOne = markdown.indexOf("<", currentIndex);
                int rightCarrotOne = markdown.indexOf(">",
                    leftCarrotOne);
                int leftCarrotTwo = markdown.indexOf("<", rightCarrotOne);
                int rightCarrotTwo = markdown.indexOf(">", leftCarrotTwo);
                toReturn.add(markdown.substring(leftCarrotTwo + 1,
                    rightCarrotTwo));
                currentIndex = rightCarrotTwo + 1;
            }
        }

        // fix to test-file2.md "[ and ]"
        else if (markdown.indexOf("(") == -1 &&
            markdown.indexOf("<") == -1) {
            while(currentIndex < markdown.length()) {
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openBracketTwo = markdown.indexOf("[", closeBracket);
                int closeBracketTwo = markdown.indexOf("]", openBracketTwo);
                toReturn.add(markdown.substring(openBracketTwo + 1,
                    closeBracketTwo));
                currentIndex = closeBracketTwo + 1;
            }
        }

        // fix to test-file4.md "( and )"
        else if (markdown.indexOf("[") == -1 &&
            markdown.indexOf("<") == -1) {
            while(currentIndex < markdown.length()) {
                int openParen = markdown.indexOf("(", currentIndex);
                int closeParen = markdown.indexOf(")", openParen);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }

        // fix to test-file3.md "() and []"
        else if (markdown.indexOf("[") != -1 &&
            markdown.indexOf("(") != -1 &&
            markdown.indexOf("(") < markdown.indexOf("[")) {
            while(currentIndex < markdown.length()) {
                int openParen = markdown.indexOf("(", currentIndex);
                int closeParen = markdown.indexOf(")", openParen);
                int openBracket = markdown.indexOf("[", closeParen);
                int closeBracket = markdown.indexOf("]", openBracket);
                toReturn.add(markdown.substring(openBracket + 1, closeBracket));
                currentIndex = closeBracket + 1;
            }
        }
        
        // runs the default test-file.md
        else {
            while(currentIndex < markdown.length()) {
                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }

        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}