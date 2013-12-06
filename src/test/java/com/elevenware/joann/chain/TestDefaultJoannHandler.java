package com.elevenware.joann.chain;

import com.elevenware.joann.*;
import com.elevenware.joann.setters.DefaultDateSetter;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDefaultJoannHandler {

    @Rule
    public InspectingRule rule = new InspectingRule();

    @Test(expected = JoannException.class)
    @Joda
    public void shouldAcceptEmptyJoda() {

       assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda(39384959L)
    public void shouldHandleJodaWithValue() {

        assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda(timestamp = "2013-02-11 12:33:11")
    public void shouldHandleJodaWithTimestamp() {

        assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda( format = Format.DEFAULT)
    public void shouldHandleJodaWithFormat() {

        assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda(timestamp = "2013-02-11 12:33:11", format = Format.DEFAULT)
    public void shouldHandleJodaWithTimestampAndFormat() {

        assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda(pattern = "YYYY-MM-dd hh:mm:ss")
    public void shouldHandleJodaWithPattern() {

        assertHandler();

    }

    @Test(expected = JoannException.class)
    @Joda(timestamp = "2013-02-11 12:33:11", pattern = "YYYY-MM-dd hh:mm:ss")
    public void shouldHandleJodaWithTimestampAndPattern() {

        assertHandler();

    }

    private void assertHandler() {

        Joda joda = rule.getJoda();
        JoannHandler setter = new DefaultDateSetter();

        assertTrue(setter.canHandle(joda));
        setter.handle(joda);

    }

}
