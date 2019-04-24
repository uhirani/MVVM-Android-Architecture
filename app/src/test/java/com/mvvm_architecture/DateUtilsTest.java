package com.mvvm_architecture;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {

    @Test
    public void dateUtilsFormat_isCorrect() throws Exception{
        String actual = "2019-04-23T20:56:00Z";
        String expected = "2019-04-23 20:56:00";
        Assert.assertEquals(expected, com.mvvm_architecture.utility.DateUtils.parseDateTime(actual, "yyyy-MM-dd'T'hh:mm:ss'Z'", "yyyy-MM-dd HH:mm:ss"));
    }
}
