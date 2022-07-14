package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class GoodPage extends WebPage {

    @Css(".name")
    public UIElement goodsName;
    @Css(".price")
    public UIElement goodsPrice;
    @Css("#tabreview")
    public UIElement reviewButton;
    @Css(".js-review-write-toggle")
    public UIElement writeReviewButton;
    @Css("#reviewForm")
    public UIElement reviewForm;



}
