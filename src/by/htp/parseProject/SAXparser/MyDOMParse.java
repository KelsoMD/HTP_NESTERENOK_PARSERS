package by.htp.parseProject.SAXparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.parseProject.beans.Abonent;
import by.htp.parseProject.beans.Book;

public class MyDOMParse {
	

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		List<Book> bookList = new ArrayList<>();
		List<Abonent> abonentList = new ArrayList<>();
		File xmlFile = new File("D:\\JavaJedi\\ParsProject\\resouces\\library.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);
		Element root = document.getDocumentElement();
		
		
		NodeList bookNodes = root.getElementsByTagName("books");
		Element tempBook = (Element) bookNodes.item(0);
		NodeList booksNodes = tempBook.getElementsByTagName("book");
		
		Book book = null;
		Abonent abonent = null;
		
		for (int i=0;i<booksNodes.getLength();i++) {
			book = new Book();
			Element bookElement = (Element) booksNodes.item(i);
			book.setId(Integer.parseInt(getChildByTagName(bookElement, "b-id").getTextContent().trim()));
			book.setTitle(getChildByTagName(bookElement, "title").getTextContent().trim());
			bookList.add(book);
		}
		
		NodeList abonentNodes = root.getElementsByTagName("abonents");
		Element tempAbonent = (Element) abonentNodes.item(0);
		NodeList abonentsNodes = tempAbonent.getElementsByTagName("abonent");
		
		for (int k=0;k<abonentsNodes.getLength();k++) {
			abonent = new Abonent();
			Element abonentElement = (Element) abonentsNodes.item(k);
			abonent.setId(Integer.parseInt(getChildByTagName(abonentElement, "a-id").getTextContent().trim()));
			abonent.setName(getChildByTagName(abonentElement, "name").getTextContent().trim());
			abonent.setSurname(getChildByTagName(abonentElement, "surname").getTextContent().trim());
			NodeList booksReadList = abonentElement.getElementsByTagName("books-read");
			for (int j=0;j<booksReadList.getLength();j++) {
				Element bookRead = (Element) booksReadList.item(j);
				abonent.getBooksRead().add(Integer.parseInt(getChildByTagName(bookRead, "book-read").getTextContent().trim()));
			}
			abonentList.add(abonent);
		}
		
		
		for (Book b : bookList) {
			System.out.println(b);
		}
		System.out.println();
		
		for (Abonent a : abonentList) {
			System.out.println(a);
		}
		
		
		
		
		
	}
	
	private static Element getChildByTagName(Element element, String tagName) {
		
		NodeList list = element.getElementsByTagName(tagName);
		Element child = (Element) list.item(0);
		return child;
		
	}

}
