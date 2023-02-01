package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;

public class Maintext {
    @Test
    public void text(){
        Main res = new Main();
        String d=res.sap("maven");
        Assert.assertEquals("hello! my first maven",d);
    }
}
