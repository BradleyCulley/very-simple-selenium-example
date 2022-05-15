package com.example;

import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CraigslistTest extends BaseTest {
    @Test
    public void shouldValidateMainHeading() {
        String titleWelcome = welcomePage.getMainHeading();
        Assert.assertEquals(titleWelcome, "south florida");
    }
}
