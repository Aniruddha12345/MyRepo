package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.LibraryModel;
import service.BookService;
import service.BookServiceImpl;

class JsonReader {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();

		// convert json file into object
		Object obj = parser.parse(new FileReader("C:\\Users\\aniruddha.karuley\\Desktop\\books.json"));

		// convert object into json object
		JSONObject jsonObject = (JSONObject) obj;

		// get jsonarray of Library
		JSONArray Library = (JSONArray) jsonObject.get("Library");

		// create arraylist storing objects
		ArrayList<LibraryModel> booklist = new ArrayList<LibraryModel>();

		// for iterating the arraylist
		for (Object book : Library) {
			JSONObject jsonObject1 = (JSONObject) book;
			LibraryModel obj1 = new LibraryModel();

			// get the values from json and get it
			String section = (String) jsonObject1.get("section");
			String bk_name = (String) jsonObject1.get("bk_Name");
			String author = (String) jsonObject1.get("author");
			java.util.Date published_date = (java.util.Date) jsonObject1.get("published_date");

			// set the values to our pojo and make book object
			obj1.setSection(section);
			obj1.setBk_name(bk_name);
			obj1.setAuthor(author);
			obj1.setPublished_date(published_date);

			// Add objects one by one to arraylist
			booklist.add(obj1);
		}

		// Iterating the Arraylist
		// 4 book objects are created
		Iterator itr = booklist.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// for saving the list in db
		BookServiceImpl bookserviceimpl = new BookServiceImpl();
		for (int i = 0; i < booklist.size(); i++) {
			bookserviceimpl.save(booklist.get(i));
		}
	}
}
