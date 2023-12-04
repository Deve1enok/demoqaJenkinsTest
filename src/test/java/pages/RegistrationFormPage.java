package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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
    @Step("Открыть страницу practice-form")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Отключить баннеры")
    public RegistrationFormPage disableBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввести в поле имя {value}")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Ввести в поле фамилию {value}")
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Ввести в поле e-mail {value}")
    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбрать пол {value}")
    public RegistrationFormPage setGenderInput(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    @Step("Ввести номер телефона {value}")
    public RegistrationFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    @Step("Выбрать дату рождения {day,month,year}")
    public RegistrationFormPage setDateBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setValue(day, month, year);
        return this;
    }
    @Step("Выбрать subject {value}")
    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Выбрать хобби {value}")
    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    @Step("Загрузить картинку {value}")
    public RegistrationFormPage choosePicture(String value) {
        pictureLoad.uploadFromClasspath(value);
        return this;
    }
    @Step("Ввести в поле address {value}")
    public RegistrationFormPage setAddress(String value) {
        addressField.setValue(value);
        return this;
    }
    @Step("Выбрать штат {getState}")
    public RegistrationFormPage setState(String getState) {
        stateInput.setValue(getState).pressEnter();
        return this;
    }
    @Step("Выбрать город {getCity}")
    public RegistrationFormPage setCity(String getCity) {
        cityInput.setValue(getCity).pressEnter();
        return this;
    }
    @Step("Нажать submit")
    public RegistrationFormPage setSubmit() {
        submitInput.click();
        return this;
    }
    @Step("Проверка поля имя на пустое значение и цвет поля")
    public RegistrationFormPage checkNameInputIsEmptyAndRedBordered() {
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
    @Step("Проверка таблицы с введенными данными")
    public RegistrationFormPage checkForm(String key, String value) {
        tableComponent.checkResult(key, value);
        return this;
    }
    @Step("Проверка на видимость таблицы с результатами")
    public RegistrationFormPage checkTableNotAppeared() {
        tableResult.shouldNotBe(visible);
        return this;
    }
    @Step("Проверка на корректное введенное имя {value}")
    public RegistrationFormPage checkLastNameField(String value) {
        lastNameInput.shouldHave(value(value));
        return this;
    }
    @Step("Проверка на корректный выбор пола {value}")
    public RegistrationFormPage checkGenderField(String value) {
        genderInput.shouldHave(text(value));
        return this;
    }
    @Step("Проверка на корректный введенный номер {value}")
    public RegistrationFormPage checkNumberField(String value) {
        userNumber.shouldHave(value(value));
        return this;
    }
}

