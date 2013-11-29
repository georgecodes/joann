package com.elevenware.joann

import com.elevenware.joann.JodaRule
import org.joda.time.DateTimeUtils
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.assertTrue

class TestJodaAwareRule {

    @Rule public JodaRule rule = new JodaRule();

    @Test
    void shouldNotHaveJodaTimeSet() {

        long nowSystem = System.currentTimeMillis()
        long now = DateTimeUtils.currentTimeMillis()
        assertTrue((now >= nowSystem))
        assertTrue((now - nowSystem) < 10000L)

    }

    @Test
    @Joda(1385554748577L)
    void annotationSetsTime() {

        long seed = 1385554748577L
        long now = DateTimeUtils.currentTimeMillis()
        assertTrue((now >= seed))
        assertTrue((now - seed) < 10000L)

    }

}
