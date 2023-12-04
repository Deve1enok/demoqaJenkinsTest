package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.DataUser;
import pages.RegistrationFormPage;
@Tag("demoqa_simple_test")
public class RegistrationFormPageObjectTest extends BaseTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    DataUser fakerData = new DataUser();

    @Test
    @Step("Позитивный тест на заполнение всех форм")
    void registrationForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .disableBanner()
                .setFirstName(fakerData.firstName)
                .setLastName(fakerData.lastName)
                .setUserEmail(fakerData.userEmail)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setDateBirthday(fakerData.randomDayOnMonth, fakerData.monthBirth, fakerData.yearBirth)
                .setSubject(fakerData.subject)
                .setHobbies(fakerData.hobbies)
                .choosePicture(fakerData.picWithPath)
                .setAddress(fakerData.currentAddress)
                .setState(fakerData.getState)
                .setCity(fakerData.getCity)
                .setSubmit()

                .checkForm(fakerData.fieldStudentName, fakerData.firstName)
                .checkForm(fakerData.fieldStudentName, fakerData.lastName)
                .checkForm(fakerData.fieldStudentEmail,fakerData.userEmail)
                .checkForm(fakerData.fieldGender, fakerData.gender)
                .checkForm(fakerData.fieldNumber, fakerData.number)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.randomDayOnMonth)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.monthBirth)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.yearBirth)
                .checkForm(fakerData.fieldSubjects, fakerData.subject)
                .checkForm(fakerData.fieldHobbies, fakerData.hobbies)
                .checkForm(fakerData.fieldPicture, fakerData.pic)
                .checkForm(fakerData.fieldAddress, fakerData.currentAddress)
                .checkForm(fakerData.fieldStateAndCity, fakerData.getState)
                .checkForm(fakerData.fieldStateAndCity, fakerData.getCity);
    }
    @Test
    @Step("Позитивный тест на заполнение форм минимальными значениями")
    void minimalFieldsData() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .disableBanner()
                .setFirstName(fakerData.minFirstName)
                .setLastName(fakerData.minLastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkForm(fakerData.fieldStudentName, fakerData.minFirstName)
                .checkForm(fakerData.fieldStudentName, fakerData.minLastName)
                .checkForm(fakerData.fieldGender, fakerData.gender)
                .checkForm(fakerData.fieldNumber, fakerData.number);

    }
    @Test
    @Step("Негативный тест при пустом поле имя")
    void negativeTestData() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .disableBanner()
                .setLastName(fakerData.lastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkNameInputIsEmptyAndRedBordered()
                .checkLastNameField(fakerData.lastName)
                .checkGenderField(fakerData.gender)
                .checkNumberField(fakerData.number)
                .checkTableNotAppeared();
    }
}
