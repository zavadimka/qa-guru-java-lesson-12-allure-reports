package com.zavadimka;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка прикрепления вложений")
public class AttachmentsTest {

    String url = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @DisplayName("Проверка прикрепления исходного кода страницы")
    @Test
    public void testLambdaAttachments() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () ->{
            open(url);
            attachment("Source", webdriver().driver().source());
        });

    }

    @DisplayName("Проверка прикрепления скриншота")
    @Test
    public void testAnnotatedAttachments() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openManePage(url);
        steps.takeScreenshot();
    }
}
