package com.elevenware.joann

import org.joda.time.DateTime
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class TestFromPropertiesFile {

    @Rule public JodaRule rule = new JodaRule()

//    @Test
    @Joda(timestamp = 'yyyy-MM-dd HH:mm:ss')
    void shouldReadFormatFromPropertiesFile() {

        DateTime now = new DateTime()

        assertEquals 2013, now.year
        assertEquals 11, now.monthOfYear
        assertEquals 29, now.dayOfMonth

        assertEquals 10, now.hourOfDay
        assertEquals 13, now.minuteOfHour
        assertTrue now.secondOfMinute >= 22
        assertTrue now.secondOfMinute < 24
    }

}
