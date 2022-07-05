package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseWebTest;

import java.util.stream.Stream;

@DisplayName("Навигация")
public class NavigationWebTest extends BaseWebTest {

//    Перейти на сайт https://geekbrains.ru/events
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера
//    Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)

    @AfterEach
    void tearDown() {
        WebElement header = driver.findElement(By.cssSelector("[class*=\"gb-header__content\"]"));
        WebElement footer = driver.findElement(By.cssSelector("[class=\"site-footer__content\"]"));

        wait15second.until(ExpectedConditions.visibilityOf(
                header));
        wait15second.until(ExpectedConditions.visibilityOf(
                footer));
    }

    @DisplayName("Блог")
    @Test
    public void posts() {
        driver.findElement(By.cssSelector("[id=\"nav\"] [href=\"/posts\"]")).click();

        driver.findElement(By.cssSelector("[class=\"gb-empopup-close\"]")).click();
        driver.findElement(By.cssSelector("button [class=\"svg-icon icon-popup-close-button \"]")).click();

        Assertions.assertEquals(
                "Блог",
                driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText()
        );
    }

    @DisplayName("Нажатие на элемент навигации")
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void courses(String namePage, String valueHref) {
        driver.findElement(By.cssSelector("[id=\"nav\"] [href='/" + valueHref + "']")).click();
        Assertions.assertEquals(
                namePage,
                driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText()
        );
    }

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Форум", "topics"),
                Arguments.of("Вебинары", "events"),
                Arguments.of("Тесты", "tests"),
                Arguments.of("Карьера", "career")
//                Arguments.of("Курсы", "courses")
        );
    }


}
