package com.example;

import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupTest extends BaseTest {
    @Test
    public void shouldReadAndAssertOnAlertText() {
        String popupText = welcomePage.getPopupText();

        Assert.assertEquals("Hello world in an popup box!", popupText);
    }
}
