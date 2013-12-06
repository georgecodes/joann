package com.elevenware.joann

import org.junit.Rule
import org.junit.Test

class TestExceptions {

    @Rule public InspectingRule rule = new InspectingRule()

    @Test(expected = JoannException)
    @Joda(timestamp =  '2003-11-23 13:03:22', pattern = 'yyyy-MM-dd hh:mm:ss')
    void annotatingWithInvalidPatternGivesMeaningfulException() {

        rule.rule.evaluate()

    }

}
