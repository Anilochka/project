package tests;

import org.junit.Test;
import pages.GooglePage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    public void userCanSearch() {
        open("https://google.com");
        new GooglePage().searchFor("github");

        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("GitHub: Where the world builds software"));
    }
}
