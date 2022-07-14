package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

@Css(".product-item")
public class ProductItemCard extends UIElement {
    @Css(".thumb")
    public UIElement productPicture;
    @Css(".details")
    public UIElement detailsDescription;
    @Css(".SearchResultsGrid-ListPickUpInStoreAction")
    public UIElement picUpInStoreButton;
    @Css(".SearchResultsGrid-ListAddToCartAction")
    public UIElement addToCartButton;
}
