package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;


public class AddedToShoppingBagWindow extends UIElement {

    @Css(".add-to-cart-button")
    public Button checkOutButton;

    @Css(".js-mini-cart-close-button")
    public Button continueShoppingButton;

    @Css(".name")
    public UIElement itemName;
    @Css(".qty")
    public UIElement itemQty;
    @Css(".itemSize")
    public UIElement itemSize;
    @Css(".itemColor")
    public UIElement itemColor;
    @Css(".price")
    public UIElement itemPrice;

}
