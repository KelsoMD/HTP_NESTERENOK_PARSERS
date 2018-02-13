package by.htp.parseProject.SAXparser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.parseProject.beans.Abonent;
import by.htp.parseProject.beans.Book;

public class MyStaxParser {

	public static List<Book> processBooks(XMLStreamReader reader) throws XMLStreamException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		TagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK:
					book = new Book();
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case B_ID:
					book.setId(Integer.parseInt(text));
					break;
				case TITLE:
					book.setTitle(text);
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK:
					books.add(book);
				}
			}
		}
		return books;
	}
	
	public static List<Abonent> processAbonents(XMLStreamReader reader) throws XMLStreamException {
		List<Abonent> abonents = new ArrayList<>();
		Abonent abonent = null;
		TagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case ABONENT:
					abonent = new Abonent();
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case A_ID:
					abonent.setId(Integer.parseInt(text));
					break;
				case NAME:
					abonent.setName(text);
					break;
				case SURNAME:
					abonent.setSurname(text);
					break;
				case BOOK_READ:
					abonent.getBooksRead().add(Integer.parseInt(text));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case ABONENT:
					abonents.add(abonent);
				}
			}
		}
		return abonents;
	}

}
