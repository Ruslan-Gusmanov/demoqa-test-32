package utils;
import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    public String setFirstName = faker.name().firstName(),
            setLastName = faker.name().lastName(),
            setUserEmail = faker.internet().emailAddress(),
            setUserGender = faker.options().option("Male", "Female", "Other"),
            setUserNumber = faker.phoneNumber().subscriberNumber(10),
            userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            userBirthYear = String.format("%s", faker.number().numberBetween(1920, 2024)),
            setSubject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                    "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                    "Civics"),
            setHobbies = faker.options().option("Sports", "Reading", "Music"),
            setPicture = faker.options().option("og_og_148879361322373683.jpg", "scale_1200.png"),
            setAddress = faker.address().fullAddress(),
            setState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            setCity = getRandomCity(setState);

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }
}
