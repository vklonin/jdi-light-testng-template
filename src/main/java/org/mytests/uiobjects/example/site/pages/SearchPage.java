package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.sections.AddedToShoppingBagWindow;
import org.mytests.uiobjects.example.site.sections.ProductItemCard;

import java.util.List;

@Url("/search") @Title("Search")
public class SearchPage extends WebPage {

    @Css(".product-item")
    public List<ProductItemCard> productGrid;
    @Css("#cboxWrapper")
    public AddedToShoppingBagWindow addedToShoppingBagWindow;
}
