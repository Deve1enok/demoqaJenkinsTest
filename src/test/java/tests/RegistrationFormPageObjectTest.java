package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectTest extends BaseTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    @Test
    void registrationForm() {
        registrationPage.openPage()
                .disableBanner()
                .setFirstName("Din")
                .setLastName("Dinov")
                .setUserEmail("DinDinov@gmail.com")
                .setGenderInput("Male")
                .setUserNumber("8777987654")
                .setDateBirthday("4","July","1997")
                .setSubject("Physics")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setHobbies("Music")
                .choosePicture("img/CssNEO.jpg")
                .setAddress("Challenger Ionia")
                .setState("NCR")
                .setCity("Noida")
                .setSubmit()

                .checkForm("Student Name", "Din Dinov")
                .checkForm("Student Email","DinDinov@gmail.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "8777987654")
                .checkForm("Date of Birth", "04 July,1997")
                .checkForm("Subjects", "Physics, Maths")
                .checkForm("Hobbies", "Sports, Music")
                .checkForm("Picture", "CssNEO.jpg")
                .checkForm("Address", "Challenger Ionia")
                .checkForm("State and City", "NCR Noida");
    }
    @Test
    void minimalFieldsData() {
        registrationPage.openPage()
                .setFirstName("1")
                .setLastName("2")
                .setGenderInput("Male")
                .setUserNumber("1234567891")
                .setSubmit()

                .checkForm("Student Name", "1 2")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "1234567891");
    }
    @Test
    void negativeTestData() {
        registrationPage.openPage()
                .setLastName("")
                .setLastName("Ramble")
                .setGenderInput("Male")
                .setUserNumber("1234567891")
                .setSubmit()

                .checkNameInputIsEmptyAndRedBordered()
                .checkLastNameField("Ramble")
                .checkGenderField("Male")
                .checkNumberField("1234567891")
                .checkTableNotAppeared();
    }
}
