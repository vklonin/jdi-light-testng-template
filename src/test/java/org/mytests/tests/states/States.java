package org.mytests.tests.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static org.mytests.uiobjects.example.site.SiteStore.homePage;

public class States {

    private static void onSite() {
        if (!WebPage.getUrl().contains("https://apparel-uk.local:9002/ucstorefront/en"))
            homePage.open();
    }
    @Step
    public static void shouldBeOnSite() {
        System.out.println("The thread ID for test is "+ Thread.currentThread().getId());
        onSite();
    }

}
