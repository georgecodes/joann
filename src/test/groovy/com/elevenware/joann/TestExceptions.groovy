package com.elevenware.joann

import org.joda.time.IllegalFieldValueException
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JodaAwareJUnit4Runner)
class TestExceptions {

    @Rule public InspectingRule rule = new InspectingRule()

    @Test(expected = IllegalArgumentException)
    @Joda(timestamp =  '2003-11-23 13:03:22', pattern = 'yyyy-MM-dd hh:mm:ss')
    void annotatingWithInvalidPatternGivesMeaningfulException() {

        rule.rule.evaluate()

    }

    @Test(expected = AssertionError)
    @Joda(timestamp =  '2003-11-23 13:03:22', format = Format.YYYYMMDD_HHMMSS)//pattern = 'yyyy-MM-dd HH:mm:ss')
    void genuinelyFailingTestFailsProperly() {

        org.junit.Assert.fail()

    }

}