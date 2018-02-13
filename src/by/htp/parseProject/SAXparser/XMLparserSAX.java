package by.htp.parseProject.SAXparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import by.htp.parseProject.beans.Abonent;
import by.htp.parseProject.beans.Book;

public class XMLparserSAX {

	public static void main(String[] args) throws IOException {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("D:\\JavaJedi\\ParsProject\\resouces\\library.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Book> books = MyStaxParser.processBooks(reader);

			input = new FileInputStream("D:\\JavaJedi\\ParsProject\\resouces\\library.xml");
			reader = inputFactory.createXMLStreamReader(input);
			List<Abonent> abonents = MyStaxParser.processAbonents(reader);

			for (Book book : books) {
				System.out.println(book);
			}

			for (Abonent abonent : abonents) {
				System.out.println(abonent);
			}

		} catch (XMLStreamException e) {

		}

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyParse handler = new MyParse();
			saxParser.parse(new File("D:\\JavaJedi\\ParsProject\\resouces\\library.xml"), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
