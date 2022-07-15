package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

@Url("/login") @Title("Login | Apparel Site UK")
public class LoginPage extends WebPage {

    @Css("#j_username")
    public TextField loginUserName;
    @Css("#j_password")
    public TextField loginUserPassword;
    @WithText("Log In")
    public Button loginSubmitButton;


}
