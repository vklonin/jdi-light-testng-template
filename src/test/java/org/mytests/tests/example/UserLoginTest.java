package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.tests.testng.TestNGListener;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mytests.tests.states.States.shouldBeOnSite;
import static org.mytests.uiobjects.example.site.SiteStore.homePage;
import static org.mytests.uiobjects.example.site.SiteStore.loginPage;

@Listeners({TestNGListener.class})
public class UserLoginTest implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeOnSite();
        homePage.shouldBeOpened();
    }

    @Test(invocationCount = 1)
    public void login() {
        homePage.checkOpened();
        Assert.assertEquals(HomePage.getTitle(),homePage.title);
        homePage.registerOrLoginLink.click();

        loginPage.shouldBeOpened();
        loginPage.loginUserName.setValue("example@mail.ru");
        loginPage.loginUserPassword.setValue("1234");
        loginPage.loginSubmitButton.click();

        Assert.assertEquals(HomePage.getTitle(),homePage.title);
        homePage.signOutButton.is().displayed();

    }

}
