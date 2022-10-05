package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
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
                        .setGender("Male")
                        .setPhone("9777742959")
                        .setBirthDate("12","October","1996")
                        .setSubjects("Hindi")
                        .setHobbies("Music")
                        .uploadFile()
                        .setAddress("Moskva, Krasnopresnenskaya nab., 12-17")
                        .setStateAndCity("NCR","Noida")
                        .submitForm();

        registrationPages.checkResultsTableVisible()
                        .checkResultTable("Student Name", "Орлов Алексей")
                        .checkResultTable("Student Email", "aorlov@site.com")
                        .checkResultTable("Gender", "Male")
                        .checkResultTable("Mobile", "9777742959")
                        .checkResultTable("Date of Birth", "12 October,1996")
                        .checkResultTable("Subjects", "Hindi")
                        .checkResultTable("Hobbies", "Music")
                        .checkResultTable("Picture", "CKtO-Q6I1ks.jpg")
                        .checkResultTable("Address", "Moskva, Krasnopresnenskaya nab., 12-17")
                        .checkResultTable("State and City", "NCR Noida");
    }
}