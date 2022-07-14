package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.sections.ProductItemCard;

import java.util.List;

public abstract class CategoriesPage extends WebPage {
    @Css("#sortOptions1")
    public Dropdown sortDropdownUpperPagePart;
    @Css("#sortOptions2")
    public Dropdown sortDropdownLowerPagePart;
    @Css(".product-item")
    public List<ProductItemCard> productGrid;


}
