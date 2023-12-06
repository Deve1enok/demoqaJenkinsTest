package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.DataUser;
import pages.RegistrationFormPage;
@Tag("demoqa_simple_test")
@Feature("Форма регистрации студента DemoQa")
@DisplayName("Заполнение формы регистрации студента DemoQa")
public class RegistrationFormPageObjectTest extends BaseTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    DataUser fakerData = new DataUser();

    @Test
    @DisplayName("Регистрация с валидными данными во всех полях")
    @Story("Позитивный тест")
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
    @DisplayName("Регистрация с минимально допустимыми значениями в допустимых полях")
    @Story("Позитивный тест")
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
    @DisplayName("Регистрация с пустым полем \"имя\"")
    @Story("Негативный тест")
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
