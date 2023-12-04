package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final static SelenideElement chooseMonth = $(".react-datepicker__month-select"),
            chooseYear = $(".react-datepicker__year-select"),
            chooseDay = $(".react-datepicker__month:not(.react-datepicker__day--outside-month)");
        public void setValue(String day,String month,String year) {
            chooseMonth.selectOption(month);
            chooseYear.selectOption(year);
            chooseDay.$(byText(day)).click();

        }
}
