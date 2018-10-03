package stringformattingandregularexpressions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner("}, {", "{", "}");
        stringJoiner.setEmptyValue("EMPTY");
        System.out.println(stringJoiner.toString());
        stringJoiner.add("alpha").add("theta").add("gamma");
        System.out.println(stringJoiner.toString());


        //Can use formatter class to write to classes that implement the Appendable interface

        //String format %[argument index][flag][width][precision]conversion
        //Can call objects with it that have a Formattable interface on it, if it doesn't
        //it will call the toString()

        /*

        Flags:
            # = shows the base (base of the number)
            0 = zero-padding (fills in extra width with 0s)
            - = left justify (left justify within its width)
            , = group separator (add the commas for currency)
            space " " = set a spot for where the +/- would go if it is displayed
            + = show positive
            ( = show negative in parenthesis

        Width:
            Integer number after the %

        Argument Index:
            You can specify a specific index

            index$ = specify the specific index
            < = use the previous index value


        Regular Expressions

            \b (or \\b in a string) = word break
            \w+ (or \\w+ in a string) = word character + 1 or more occurrences of word characters

            Dedicated Regular Expression Classes

                Pattern class
                 - creates a Matcher class based on it

            https://regex101.com/

         */

        String values = "apple, banana, and orange please";

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(values);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
