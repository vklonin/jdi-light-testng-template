package org.mytests.tests.example;

import com.epam.jdi.light.elements.composite.WebPage;
import org.mytests.tests.TestsInit;

import static org.mytests.uiobjects.example.site.SiteStore.homePage;

public class BaseTestClass implements TestsInit {

    public void checkPage(WebPage homePage) {
        if (homePage != null && homePage.driver() != null) {
            System.out.println(homePage.driver().toString());
            setUp();}
    }

}
