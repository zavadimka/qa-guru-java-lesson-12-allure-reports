package com.zavadimka;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты с использованием меток (labels)")
public class LabelsTest {

    // Статическая разметка (аннотации) используется начинающими автоматизаторами
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("zavadimka")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com/")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {
    }

    // Динамическая разметка используется опытными автоматизаторами
    // Например, при создании расширения для фреймворка JUnit5 с помощью точек расширения
    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        // В динамической разметке можно использовать все возможности языка программирования
//        if (true){
//            Allure.feature("Issue в репозитории");
//        } else {
//            Allure.feature("Issue не в репозитории");
//        }
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "zavadimka");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com/");
    }
}
