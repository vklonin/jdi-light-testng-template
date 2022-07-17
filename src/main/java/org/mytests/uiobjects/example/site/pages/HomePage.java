package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

@Url("/") @Title("Apparel Site UK | Homepage")
public class HomePage extends WebPage {

    @Css("#js-site-search-input")
    public static TextField searchField;
    @Css(".js_search_button")
    public static Button searchButton;

//    @XPath(".//ul[@class='nav__links--products']//li[@class='nav__links--primary']")
    @Css(".nav__links--primary")
    public static List<UIElement> productTypesNavigationMenu;

    @WithText("Sign in / Register")
    public Link registerOrLoginLink;

    @WithText("Sign Out")
    public Link signOutButton;

}
