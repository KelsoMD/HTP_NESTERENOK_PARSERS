package by.htp.parseProject.SAXparser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.parseProject.beans.Abonent;
import by.htp.parseProject.beans.Book;

public class MyParse extends DefaultHandler{
	
	private List<Book> books = new ArrayList<>();
	private List<Abonent> abonents = new ArrayList<>();
	private Book book;
	private Abonent abonent;
	StringBuilder text;
	
//	String thisElement = "";
	
	public List<Book> getResultsBook(){
		return books;
	}
	
	public List<Abonent> getResultsAbonent(){
		return abonents;
	}
	
	

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing!");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		
		text = new StringBuilder();
		TagName tagName =
				TagName.valueOf(qName.toUpperCase().replace("-", "_"));
				switch(tagName){
				case BOOK:
					book = new Book();
					break;
				case ABONENT:
					abonent = new  Abonent();
				}
		
//		thisElement = qName;
//		if (qName.equals("book")) {
//			book = new Book();
//		}
//		if (qName.equals("abonent")) {
//			abonent = new Abonent();
//		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		TagName tagName =
				TagName.valueOf(qName.toUpperCase().replace("-", "_").trim());
				switch(tagName){
				case BOOK:
					books.add(book);
					break;
				case ABONENT:
					abonents.add(abonent);
				case B_ID:
					book.setId(Integer.parseInt(text.toString().trim()));
				break;
				case TITLE:
					book.setTitle(text.toString());
				break;
				case A_ID:
					abonent.setId(Integer.parseInt(text.toString().trim()));
				break;
				case NAME:
					abonent.setName(text.toString().trim());
				break;
				case SURNAME:
					abonent.setSurname(text.toString().trim());
				break;
				case BOOK_READ:
					abonent.getBooksRead().add(Integer.parseInt(text.toString().trim()));
				break;
				}
//		if(qName.equals("book")) {
//			books.add(book);
//		}
//		if(qName.equals("abonent")) {
//			abonents.add(abonent);
//		}
//		thisElement="";
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("XML parsed!");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		
		text.append(ch, start, length);
		
//		if (thisElement.equals("b-id")) {
//			book.setId(Integer.parseInt(new String(ch, start, length)));
//		}
//		if (thisElement.equals("title")){
//			book.setTitle(new String(ch, start, length));
//		}
//		if (thisElement.equals("a-id")){
//			abonent.setId(Integer.parseInt(new String(ch, start, length)));
//		}
//		if (thisElement.equals("name")){
//			abonent.setName(new String(ch, start, length));
//		}
//		if (thisElement.equals("surname")){
//			abonent.setSurname(new String(ch, start, length));
//		}
//		if (thisElement.equals("book-read")){
//			abonent.getBooksRead().add(Integer.parseInt(new String(ch, start, length)));
//		}
//		
		
	}
	
}
