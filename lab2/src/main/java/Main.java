import org.exyfi.simpleparser.Parser;

import java.io.ByteArrayInputStream;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Parser parser = new Parser();
        parser.parse(new ByteArrayInputStream("!!(a&b)".getBytes())).visualize(0);

    }
}
