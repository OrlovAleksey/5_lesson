package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month); //Выбираем месяц через selectOption
        $(".react-datepicker__year-select").selectOption(year); //Выбираем год через selectOption
        $(".react-datepicker__day--0" + day).click(); //Выбираем дату
    return this;
    }
}
