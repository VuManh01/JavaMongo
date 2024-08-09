package mongoJava;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class javamongo {

	public static void main(String[] args) {

		// creating a mongodb client
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("MyDB");

		// Get the collection 'news' from the database 'MyDB'
		MongoCollection<Document> collection = db.getCollection("news");
		System.out.println("Below are the documents in the 'news' collection:");

		// Get all documents from the collection and print them
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				// Assuming the documents have fields like "title", "catgoty", and "date"
				String title = doc.getString("title");
				String catgoty = doc.getString("catgoty");
				String date = doc.getString("date");

				System.out.println("Title: " + title);
				System.out.println("Catgoty: " + catgoty);
				System.out.println("Date: " + date);
				System.out.println("--------------------");
			}
		} finally {
			cursor.close();
		}

		// Close the MongoClient
		mongoClient.close();
	}
}
