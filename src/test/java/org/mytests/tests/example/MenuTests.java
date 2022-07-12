package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.tests.states.States;
import org.mytests.tests.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class MenuTests implements TestsInit {
    @BeforeMethod
    public void openPerformancePage() {
        System.out.println("debugging");
        States.shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }
    @Test
    public void menuTest() {
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
    @Test
    public void customMenuTest() {
        menu.select(ContactForm);
        assertEquals(menu.selected(), ContactForm.value);
        menu.select(Service, Dates);
        menu.is().selected(Dates.value);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}
