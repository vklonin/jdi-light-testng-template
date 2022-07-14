package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.sections.ProductItemCard;

import java.util.List;

@Url("/cart") @Title("Your Shopping Bag")
public class CartPage extends WebPage {
    @Css(".item__list--item")
    public List<UIElement> cartContentList;
}
