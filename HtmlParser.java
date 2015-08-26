package com.ilit.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("D:/ilyazidi012113/issam/Ordered/quran_morattab.html");
		BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		StringBuffer textBrut = new StringBuffer();
		while(reader.ready()){
			textBrut.append(reader.readLine());
		}
		Document doc = Jsoup.parse(textBrut.toString());
		Elements elements = doc.getAllElements();
		StringBuffer rubuContent = new StringBuffer();
		int rubuNumber = 0;
		Path path_rubu; 
		for(Element element:elements){
			
			if ("num-hizb".equals(element.attributes().get("class"))
					|| "num-nisf".equals(element.attributes().get("class"))
					|| "num-rubu".equals(element.attributes().get("class"))
					){
//				System.out.println(element.html());
				rubuNumber++;
				path_rubu= Paths.get("D:/ilyazidi012113/issam/Ordered/Partitions/rubu_"+rubuNumber+ ".html");
				BufferedWriter writer = Files.newBufferedWriter(path_rubu, StandardCharsets.UTF_16);//Charset.defaultCharset()
				writer.write(rubuContent.toString());
				rubuContent = new StringBuffer();
			}
			rubuContent.append(element.html());
		}
		
//		BufferedWriter writer = Files.newBufferedWriter(fichier, charset);
//		writer.write(contenu, 0, contenu.length());
	}

}
