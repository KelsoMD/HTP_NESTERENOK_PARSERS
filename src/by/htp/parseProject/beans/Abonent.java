package by.htp.parseProject.beans;

import java.util.HashSet;
import java.util.Set;

public class Abonent {
	
	int id;
	String name;
	String surname;
	Set<Integer> booksRead = new HashSet<>();
	public Abonent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Abonent(int id, String name, String surname, Set<Integer> booksRead) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.booksRead = booksRead;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Set<Integer> getBooksRead() {
		return booksRead;
	}
	public void setBooksRead(Set<Integer> booksRead) {
		this.booksRead = booksRead;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booksRead == null) ? 0 : booksRead.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonent other = (Abonent) obj;
		if (booksRead == null) {
			if (other.booksRead != null)
				return false;
		} else if (!booksRead.equals(other.booksRead))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Abonent [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	} 
	
	

}
