package com.trendyol.seleniumCase;

import com.trendyol.seleniumCase.pages.BasketPage;
import com.trendyol.seleniumCase.pages.HomePage;
import com.trendyol.seleniumCase.pages.ItemPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ItemTest extends BaseTest {
    String realItemText = "";

    @Test
    public void shouldGoTvPage(){
        HomePage homePage = new HomePage(webDriver);
        ItemPage itemPage = homePage.clickItemPage();

        String getResultText = itemPage.getResultText() ;
        assertEquals(getResultText, "TV Görüntü Ses Sistemleri");
    }
    @Test
    public void shouldItemInfoBeSame(){

        ItemPage itemPage = new ItemPage(webDriver);

        itemPage.goThirdPage();

        realItemText = itemPage.getItemText();

        itemPage.clickItem();
        itemPage.goSecondTab();

        String itemText = itemPage.getSpanText();

        assertTrue(realItemText.contains(itemText));

    }
    @Test
    public void shouldCorrectItemAddedBasket(){
        ItemPage itemPage = new ItemPage(webDriver);

        itemPage.addItemToBasket();
        BasketPage basketPage = itemPage.getBasketPage();

        String itemText = basketPage.getItemText();

        assertTrue(realItemText.contains(itemText));
    }
    @Test
    public void wholeTest(){
        shouldGoTvPage();
        shouldItemInfoBeSame();
        shouldCorrectItemAddedBasket();
    }
}
