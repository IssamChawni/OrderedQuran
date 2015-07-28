package main.java.ilit.quran;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class QuranHandler extends DefaultHandler {
	
	int count = 0;
	int rubu = 0;
	
	public void startDocument() throws SAXException {
		System.out.println("Counting letters: \n ----------");
    }

    public void endDocument() throws SAXException {
    	System.out.println("rubu " + rubu + " : " + count);
        System.out.println("------------ \n end Counting.");
    }

    public void startElement(String uri, String localName,
        String qName, Attributes attributes)
    throws SAXException {

        if("aya".equals(qName)){
        	count = count + attributes.getValue("text").length();
        }
        
        if("hizb".equals(qName) || "rubu".equals(qName) || "nisf".equals(qName)){
        	if( rubu >0){
        	System.out.println("rubu " + rubu + " : " + count);
        	count = 0;
        	rubu = rubu +1;
        	}
        	else { rubu = rubu +1;}
        }
    }

}    
