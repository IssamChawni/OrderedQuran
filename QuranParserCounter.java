package main.java.ilit.quran;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class QuranParserCounter {

    public static void main (String argv []) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            InputStream    xmlInput  =
                new FileInputStream("//OrderedQuran/quran-muratab.xml");

            SAXParser      saxParser = factory.newSAXParser();

            DefaultHandler handler   = new QuranHandler();
            saxParser.parse(xmlInput, handler);
        } catch (Throwable err) {
            err.printStackTrace ();
        }
    }
}
