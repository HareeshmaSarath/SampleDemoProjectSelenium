package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomDataGeneration {

	static Faker faker;
	static String gname;
	static int price;

	public static String getGivenName() {
		faker = new Faker(new Locale("en-IND"));
		gname=faker.name().fullName();
		price=faker.number().numberBetween(500, 2000);
		return gname;
	}
}