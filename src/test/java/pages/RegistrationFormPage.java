package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureLoad = $("#uploadPicture"),
            addressField = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit"),
            tableResult = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage disableBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGenderInput(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setValue(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage choosePicture(String picture) {
        pictureLoad.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setSubmit() {
        submitInput.click();
        return this;
    }
    public RegistrationFormPage checkNameInputIsEmptyAndRedBordered() {
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationFormPage checkForm(String key, String value) {
        tableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationFormPage checkTableNotAppeared() {
        tableResult.shouldNotBe(visible);
        return this;
    }
    public RegistrationFormPage checkLastNameField(String value) {
        lastNameInput.shouldHave(value(value));
        return this;
    }
    public RegistrationFormPage checkGenderField(String value) {
        genderInput.shouldHave(text(value));
        return this;
    }
    public RegistrationFormPage checkNumberField(String value) {
        userNumber.shouldHave(value(value));
        return this;
    }
}

