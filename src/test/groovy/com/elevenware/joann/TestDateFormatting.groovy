package com.elevenware.joann

import org.joda.time.DateTime
import org.joda.time.DateTimeUtils
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(JodaAwareJUnit4Runner)
class TestDateFormatting {

//    @Rule public JodaRule rule = new JodaRule();

/*
 * #%L
 * Joann - Joda Annotation
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 elevenware
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

    @Test
    @Joda(timestamp = '2012-11-19 13:03:22', format = Format.YYYYMMDD_HHMMSS)
    void setDateAndTime() {

        DateTime now = new DateTime()

        assertEquals 2012, now.year
        assertEquals 11, now.monthOfYear
        assertEquals 19, now.dayOfMonth

        assertEquals 13, now.hourOfDay
        assertEquals 3, now.minuteOfHour
        assertEquals 22, now.secondOfMinute

    }

    @Test
    @Joda(timestamp = '2012-11-19 13:03:22', pattern = 'yyyy-MM-dd HH:mm:ss')
    void setUsingMyOwnPattern() {

        DateTime now = new DateTime()

        assertEquals 2012, now.year
        assertEquals 11, now.monthOfYear
        assertEquals 19, now.dayOfMonth

        assertEquals 13, now.hourOfDay
        assertEquals 3, now.minuteOfHour
        assertEquals 22, now.secondOfMinute

    }

}
