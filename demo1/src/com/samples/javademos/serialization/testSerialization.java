package com.samples.javademos.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class testSerialization {

	public static void main(String[] args) {
		
//		private static final String filePath = "d:\\eclipse\\javafsd\\out\\testout.txt";

		
		String filePath = "d:\\eclipse\\javafsd\\out\\book1.txt";
		
		serializeBook(filePath);
		
		deserializeBook(filePath);

		
	}

	private static void deserializeBook(String filePath) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			Book book1 = (Book) ois.readObject();
			System.out.println(book1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void serializeBook(String filePath) {
		Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
//		NewBook book2 = new NewBook("Harry Potter", "J.K.Rowling", 1997);
//		NewBook book3 = new NewBook("Business at the speed of thought", "Bill Gates", 1999);
//		NewBook book4 = new NewBook("Effective Java", "Joshua Bloch", 2008);
//		NewBook book5 = new NewBook("Beauty and the Beast", "Disney", 1854);
		
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(book1);
			oos.flush();
			oos.close();
			System.out.println("Done");			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}