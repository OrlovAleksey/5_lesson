package pages;

import pages.components.AddressComponent;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

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
    public RegistrationPages setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter(); // выбираем навык
        return this;
    }
    public RegistrationPages setHobbies(String value) {
            $("#hobbiesWrapper").$(byText(value)).click(); //выбираем увлечение
        return this;
    }
    public RegistrationPages setAddress(String value) {
            $("#currentAddress").setValue(value); //заполняем адресс
        return this;
    }
    public RegistrationPages setStateAndCity(String state, String city){
        $("#dateOfBirthInput").click();
        new AddressComponent().setStateAndCity(state,city);
        return this;
    }
    public RegistrationPages uploadFile() {
        File file = new File("src/test/resources/CKtO-Q6I1ks.jpg");//создаем переменную для файла
        $("input#uploadPicture").uploadFile(file);
        return this;
    }
    public RegistrationPages submitForm() {
        $("#submit").click(); //Кликаем на подтвержение формы
        return this;
    }
    public RegistrationPages checkResultsTableVisible() {
        new ResultsTableComponent().checkVisible();
        return this;
    }
    public RegistrationPages checkResultTable(String key, String value) {
        new ResultsTableComponent().checkResult(key, value);
        return this;
    }
}
