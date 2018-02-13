package by.htp.parseProject.SAXparser;

public enum TagName {

	LIBRARY, BOOKS, BOOK, B_ID, TITLE, ABONENTS, ABONENT, A_ID, NAME, SURNAME, BOOKS_READ, BOOK_READ;

	public static TagName getElementTagName(String element) {
		switch (element) {
		case "library":
			return LIBRARY;
		case "books":
			return BOOKS;
		case "book":
			return BOOK;
		case "b-id":
			return B_ID;
		case "title":
			return TITLE;
		case "abonents":
			return ABONENTS;
		case "abonent":
			return ABONENT;
		case "a-id":
			return A_ID;
		case "name":
			return NAME;
		case "surname":
			return SURNAME;
		case "books-read":
			return BOOKS_READ;
		case "book-read":
			return BOOK_READ;
		default:
			throw new EnumConstantNotPresentException(TagName.class, element);
		}
	}
}
