package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomDataGeneration {

	static Faker faker;
	static String gname;

	public static String getGivenName() {
		faker = new Faker(new Locale("en-IND"));
		gname=faker.name().fullName();
		return gname;
	}
}