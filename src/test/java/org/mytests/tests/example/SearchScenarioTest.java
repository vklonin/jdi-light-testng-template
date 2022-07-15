package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.tests.testng.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mytests.tests.states.States.shouldBeOnSite;
import static org.mytests.uiobjects.example.site.SiteStore.*;
import static org.mytests.uiobjects.example.site.pages.HomePage.searchButton;
import static org.mytests.uiobjects.example.site.pages.HomePage.searchField;

@Listeners(TestNGListener.class)
public class SearchScenarioTest implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeOnSite();
        homePage.shouldBeOpened();
    }

    @Test(invocationCount = 1)
    public void searchShirts() {
        System.out.println("The thread ID for search test is "+ Thread.currentThread().getId());
        searchField.setValue("shirt");
        searchButton.click();
        searchPage.shouldBeOpened();
        searchPage.productGrid.get(2).addToCartButton.click();
        Assert.assertTrue(searchPage.addedToShoppingBagWindow.getText().contains("Added to Your Shopping Bag"));

        String itemName = searchPage.addedToShoppingBagWindow.itemName.getText();
        String itemQty = searchPage.addedToShoppingBagWindow.itemQty.getText();
        String itemSize = searchPage.addedToShoppingBagWindow.itemSize.getText().replace(" ", ": ");
        String itemPrice = searchPage.addedToShoppingBagWindow.itemPrice.getText();

        searchPage.addedToShoppingBagWindow.checkOutButton.click();

        cartPage.shouldBeOpened();
        String cartItemName = cartPage.cartContentList.get(1).find(".item__name").getText();
        String cartItemQty = "Quantity Added " + cartPage.cartContentList.get(1).find(".js-update-entry-quantity-input").getText();
        String cartItemSize = cartPage.cartContentList.get(1).find(".item__stock").getText();
        String cartItemPrice = cartPage.cartContentList.get(1).find(".item__price").getText();

        Assert.assertTrue(cartItemName.contains(itemName), "item name isnt ok");
        Assert.assertTrue(cartItemQty.contains(itemQty));
        Assert.assertTrue(cartItemSize.contains(itemSize));
        Assert.assertTrue(cartItemPrice.contains(itemPrice));

    }


}
