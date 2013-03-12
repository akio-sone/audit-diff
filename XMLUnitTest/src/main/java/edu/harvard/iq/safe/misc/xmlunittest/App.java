package edu.harvard.iq.safe.misc.xmlunittest;

import org.custommonkey.xmlunit.XMLUnit;
/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        if (XMLUnit.getIgnoreWhitespace()){
            System.out.println("whitespace is ignored");
        } else {
            System.out.println("whitespace is NOT ignored");
        }
    }
}
