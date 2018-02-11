package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .chooseRoll(new Roll(Roll.SESAME))
                .chooseBurgers(new Burgers(Burgers.TRIPPLE))
                .chooseSauce(new Sauce(Sauce.THOUSANDISLAND))
                .chooseIngredients(new Ingredients(Ingredients.ONION, Ingredients.BACON, Ingredients.CHILI))
                .build();
        //when
        int howManyIngredients = bigmac.getIngredients().getIngredients().size();

        boolean rollType = false;
        if (bigmac.getRoll().getRoll().equals("SESAME")) {
            rollType = true;
        }
        //then
        System.out.println(bigmac);
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertTrue(rollType);
    }

}
