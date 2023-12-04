package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataUser {

    private final Faker ruFaker = new Faker(new Locale("ru"));
    private final Faker enFaker = new Faker(new Locale("en"));

    public String firstName = ruFaker.name().firstName();
    public String lastName = ruFaker.name().lastName();
    public String userEmail = enFaker.internet().emailAddress();
    public String number = ruFaker.phoneNumber().subscriberNumber(10);
    public String gender = ruFaker.options().option("Male", "Female", "Other");
    public String monthBirth = ruFaker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public String yearBirth = String.valueOf(ruFaker.number().numberBetween(1900, 2100));
    public String subject = ruFaker.options().option("Math", "English", "Chemistry", "Physics", "Computer Science", "Economics", "Arts",
            "Social Studies", "History", "Civics", "Hindi", "Biology", "Accounting", "Commerce");
    public String hobbies = ruFaker.options().option("Sports", "Reading", "Music");
    public String pic = "CssNEO.jpg";
    public String picPath = "img/";
    public String picWithPath = picPath + pic;
    public String currentAddress = ruFaker.address().fullAddress();
    public String getState = ruFaker.options().option("NCR", "Utta Pradesh", "Haryana", "Rajasthan");
    public String getCity = randomCity(getState);
    public String minFirstName = ruFaker.letterify("?");
    public String minLastName = ruFaker.letterify("?");
    public String randomDayOnMonth = randomDayOnMonth(monthBirth);
    public String fieldStudentName = "Student Name";
    public String fieldStudentEmail = "Student Email";
    public String fieldGender = "Gender";
    public String fieldNumber = "Mobile";
    public String fieldDateOfBirth = "Date of Birth";
    public String fieldSubjects = "Subjects";
    public String fieldHobbies = "Hobbies";
    public String fieldPicture = "Picture";
    public String fieldAddress = "Address";
    public String fieldStateAndCity = "State and City";

    public static String randomCity(String state) {
        Faker faker = new Faker();
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Utta Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");


            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
        }
        return state;
    }

    public static String randomDayOnMonth(String month) {
        Faker faker = new Faker();
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                return String.valueOf(faker.number().numberBetween(1, 31));

            case "November":
            case "September":
            case "April":
            case "June":
                return String.valueOf(faker.number().numberBetween(1, 30));

            case "February":
                return String.valueOf(faker.number().numberBetween(1, 28));
        }
        return month;
    }
}

