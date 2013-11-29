package com.elevenware.joann

import org.joda.time.DateTime
import org.joda.time.DateTimeUtils
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.*

class TestDateFormatting {

    @Rule public JodaRule rule = new JodaRule();

    @Test
    @Joda(1385554748577L)
    void annotationSetsTimeByLongValue() {

        long seed = 1385554748577L
        long now = DateTimeUtils.currentTimeMillis()
        assertTrue((now >= seed))
        assertTrue((now - seed) < 10000L)

    }

    @Test
    @Joda(timestamp = "2013-11-29T10:13:22.192Z")
    void settingTimestampAloneUsesISODateFormat() {

        DateTime now = new DateTime()

        assertEquals 2013, now.year
        assertEquals 11, now.monthOfYear
        assertEquals 29, now.dayOfMonth

        assertEquals 10, now.hourOfDay
        assertEquals 13, now.minuteOfHour
        assertTrue now.secondOfMinute >= 22
        assertTrue now.secondOfMinute < 24

    }

    @Test
    @Joda(timestamp = '2013-12-25', format = Format.YYYYMMDD)
    void settingTimestampWithDateOnly() {

        DateTime now = new DateTime()

        assertEquals 2013, now.year
        assertEquals 12, now.monthOfYear
        assertEquals 25, now.dayOfMonth

    }


}
