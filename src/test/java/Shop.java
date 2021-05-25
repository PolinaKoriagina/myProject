
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Shop {
    static Logger logger = LoggerFactory.getLogger(Shop.class);
    @BeforeAll
    static void setUp() {
        logger.info("@BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }
    @AfterAll
    static void tearDown() {
        logger.info("@AfterAll method");
        logger.info("We added a lipstick:)");
    }
    @Test
    void addLipstick(){
        open("https://www.zara.com/pl/");
        $("#onetrust-accept-btn-handler").click();
        $("[aria-label=\"Otworzyć menu\"]").click();
        $("[aria-label=\"BEAUTY, Rozwiń kategorie pomocnicze\"]").click();
        $("[aria-label=\"KOLEKCJA, Rozwiń kategorie pomocnicze\"]").click();
        $("[alt=\"STILETTO DEMI-MATTE LIPSTICK – WKŁAD\"]").scrollIntoView(true).click();
        $("#product-78478936").shouldHave(text("Dodaj do koszyka"));


    }
}
