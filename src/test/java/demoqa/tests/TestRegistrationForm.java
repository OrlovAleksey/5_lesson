package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm {

    RegistrationPages registrationPages = new RegistrationPages();

    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true; //Делаем чтобы браузер оставался открытым
        Configuration.baseUrl = "https://demoqa.com"; //Добавляем настройку стандартного урла
    }
    @Test

    void simpleTest(){
        registrationPages.openPage()
                        .setFirstName("Орлов")
                        .setLastName("Алексей")
                        .setEmail("aorlov@site.com")
                        .setGender("Male");

        $("#userNumber").setValue("9777742959"); //заполняем моб

        registrationPages.setBirthDate("12","October","1996");
        $("#subjectsInput").setValue("Hindi").pressEnter(); // выбираем навык
        $("#hobbiesWrapper").$(byText("Music")).click(); //выбираем увлечение
        $("#currentAddress").setValue("Moskva, Krasnopresnenskaya nab., 12-17"); //заполняем адресс

        File file = new File("src/test/resources/CKtO-Q6I1ks.jpg");//создаем переменную для файла
        $("#uploadPicture").uploadFile(file);//загружаем файл

        $("#react-select-3-input").setValue("NCR").pressEnter(); //выбираем штат
        $("#react-select-4-input").setValue("Noida").pressEnter(); //выбираем город

        $("#submit").click(); //Кликаем на подтвержение формы

        //Проверяем поля
        $(".table-responsive").shouldHave(text("Орлов"));
        $(".table-responsive").shouldHave(text("Алексей"));
        $(".table-responsive").shouldHave(text("aorlov@site.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9777742959"));
        $(".table-responsive").shouldHave(text("Hindi"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("12 October,1996"));
        $(".table-responsive").shouldHave(text("CKtO-Q6I1ks.jpg"));
        $(".table-responsive").shouldHave(text("Moskva, Krasnopresnenskaya nab., 12-17"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}