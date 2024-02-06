package com.zavadimka;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest{

    String url = "https://github.com/";

    @Test
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(url);

        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $(".QueryBuilder-InputWrapper").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).shouldBe(exist);

    }
}
