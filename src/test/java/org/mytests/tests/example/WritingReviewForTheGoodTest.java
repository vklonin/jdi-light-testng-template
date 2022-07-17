package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.tests.testng.TestNGListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.mytests.tests.states.States.shouldBeOnSite;
import static org.mytests.uiobjects.example.site.SiteStore.*;
import static org.mytests.uiobjects.example.site.pages.HomePage.productTypesNavigationMenu;

@Listeners(TestNGListener.class)
public class WritingReviewForTheGoodTest implements TestsInit {
    @BeforeMethod
    public void before() {
        System.out.println("The thread ID for test is "+ Thread.currentThread().getId());
        if (homePage != null && homePage.driver() != null) {
            setUp();}
        homePage.driver().get("https://apparel-uk.local:9002/ucstorefront/en");
        homePage.shouldBeOpened();
    }
    @Test(invocationCount = 1)
    public void writingReviewForLowestPriceItem() {
        System.out.println("The thread ID for review test is "+ Thread.currentThread().getId());
        productTypesNavigationMenu.stream().filter(el-> el.getText().contains("Accessories".toUpperCase())).findFirst().orElse(null).click();
        accessoriesCategoryPage.shouldBeOpened();
        accessoriesCategoryPage.sortDropdownUpperPagePart.select("Price (lowest first)");
        String detailsDescriptionText = accessoriesCategoryPage.productGrid.get(1).detailsDescription.getText();
        accessoriesCategoryPage.productGrid.get(1).click();
        goodPage.shouldBeOpened();
        String goodsName = goodPage.goodsName.getAttribute("innerHTML").split("<")[0];
        String goodsPrice = goodPage.goodsPrice.getText();

        Assert.assertTrue(detailsDescriptionText.contains(goodsName),"item name isnt ok");
        Assert.assertTrue(detailsDescriptionText.contains(goodsPrice),"item price isnt ok");

        goodPage.reviewButton.click();
        goodPage.writeReviewButton.click();

        goodPage.reviewForm.find("input[name=headline]").getWebElement().sendKeys("My review");//.setValue("My review");
        goodPage.reviewForm.find("textarea[name=comment]").sendKeys("I’m so excited, I would buy it one more time");
        List<WebElement> elements = goodPage.reviewForm.findElements(new By.ByCssSelector(".glyphicon-star"));
        elements.get(9).click();
        goodPage.reviewForm.find("#alias").setValue("John");
        goodPage.reviewForm.find(".btn").click();

        String alertTextToCheck = goodPage.driver().findElement(new By.ByCssSelector(".getAccAlert")).getText();
        String validationMessage = "Thank you for your review";
        Assert.assertTrue(alertTextToCheck.contains(validationMessage),"message about a review is wrong.expected " + validationMessage + " actual " + alertTextToCheck );
    }

}
