package pages;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPages {

    public RegistrationPages openPage(){
        String BaseUrl = "/automation-practice-form"; //создали переменную для страницы которую будем тестирвоать
        open(BaseUrl); //открываем станицу которую будем тестировать через переменную
        executeJavaScript("$('#fixedban').remove()"); //убираем футер
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPages setFirstName(String value){
        $("#firstName").setValue(value); //Заполянем Имя
        return this;
    }
    public RegistrationPages setLastName(String value){
        $("#lastName").setValue(value); //Заполянем Фамилию
        return this;
    }

    public RegistrationPages setEmail(String value){
        $("#userEmail").setValue(value); //Заполянем емейл
        return this;
    }
    public RegistrationPages setGender(String value){
        $("#genterWrapper").$(byText(value)).click(); //Кликаем на пол
        return this;
    }
    public RegistrationPages setPhone(String value){
        $("#userNumber").setValue(value); //заполняем моб
        return this;
    }
    public RegistrationPages setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click(); //кликаем на поле чтобы открыть календарь
        new CalendarComponent().setDate(day,month,year);
        return this;
    }

}
