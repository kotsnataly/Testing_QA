package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseWebTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Поиск")
public class SearchWebTest extends BaseWebTest {

//    Перейти на сайт https://geekbrains.ru/events
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что на странице:
//    Профессий не менее чем 2
//    Курсов более 15
//    Вебинаров больше чем 180, но меньше 300
//    В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//    Блогов более 300
//    Форумов не 350
//    Тестов не 0

    @DisplayName("Проверка поиска по всем блокам")
    @Test
    void search() {
        WebElement buttonSearch = driver.findElement(By.cssSelector("[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]"));
        buttonSearch.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");


        WebElement professions = driver.findElement(By.cssSelector("[id=\"professions\"] h2"));
        WebElement courses = driver.findElement(By.xpath(".//header/h2[text()='Курсы']"));
        WebElement events = driver.findElement(By.xpath(".//header/h2[text()='Вебинары']"));
        WebElement blogs = driver.findElement(By.xpath(".//header/h2[text()='Блоги']"));
        WebElement forum = driver.findElement(By.xpath(".//header/h2[text()='Форум']"));
        WebElement tests = driver.findElement(By.xpath(".//header/h2[text()='Тесты']"));
        WebElement projectAndCompany = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));

        WebElement professionsCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='professions']/span"));
        WebElement coursesCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='courses']/span"));
        WebElement eventsCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='webinars']/span"));
        WebElement blogsCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='blogs']/span"));
        WebElement forumsCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='forums']/span"));
        WebElement testsCount = driver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='tests']/span"));

        WebElement firstWebinarInList = driver.findElement(By.xpath("//a[@class='event__title h3 search_text']"));

        wait15second.until(ExpectedConditions.textToBePresentInElement(professions, "Профессии"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(courses, "Курсы"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(events, "Вебинары"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(blogs, "Блоги"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(forum, "Форум"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(tests, "Тесты"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(projectAndCompany, "Проекты и компании"));

        assertThat(Integer.parseInt(professionsCount.getText()), greaterThanOrEqualTo(2));
        assertThat(Integer.parseInt(coursesCount.getText()), greaterThan(15));
        assertThat(Integer.parseInt(eventsCount.getText()), allOf(greaterThan(180), lessThan(300)));
        assertThat(Integer.parseInt(blogsCount.getText()), greaterThan(300));
        assertThat(Integer.parseInt(forumsCount.getText()), not(equalTo(350)));
        assertThat(Integer.parseInt(testsCount.getText()), not(equalTo(0)));
        assertThat(firstWebinarInList.getText(), equalTo("Java Junior. Что нужно знать для успешного собеседования?"));

    }
}
