package com.zavadimka;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@DisplayName("Тесты с использованием лямба- и веб- степов")
public class StepsTest {

    String url = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @DisplayName("Тест с лямбда-степами")
    @Test
    public void testLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу GitHub", () ->{
            open(url);
        });
        step("Ищем репозиторий " + REPOSITORY, () ->{
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $(".QueryBuilder-InputWrapper").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () ->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () ->{
            $(withText("#" + ISSUE)).shouldBe(exist);
        });

    }

    @DisplayName("Тест с веб-степами")
    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openManePage(url);
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
