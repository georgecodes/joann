package com.elevenware.joann;

/*
 * #%L
 * Joann - Joda Annotation
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 Elevenware Limited
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

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.runners.model.Statement;

/**
 * A wrapper around JUnit statements, which optionally set/reset Joda time
 *
 * @author George McIntosh
 * @since 1.0
 */
import java.util.logging.Logger;

public class JodaAwareStatement extends Statement {

    private static final Logger LOG = Logger.getLogger(JodaAwareStatement.class.getName());
    private final Statement base;
    private final Joda joda;
    private final String testName;

    public JodaAwareStatement(Statement base, Joda joda, String testName) {
        this.testName = testName;
        this.base = base;
        this.joda = joda;
    }

    @Override
    public void evaluate() throws Throwable {
        if ( joda == null ) {
            LOG.fine(String.format("Did not find a Joda annotation on '%s'", testName));
            base.evaluate();
            return;

        }
        switch(joda.format()) {
            case USE_MILLIS:
                long value = joda.value();
                LOG.fine(String.format("Found Joda annotation on %s, setting Joda time to %s", testName, String.valueOf(value)));
                setByMillis();
                break;
            case ISO:
                setToIso();
                break;
            case YYYYMMDD:
            case YYYYMMDD_HHMMSS:
                setToFormat();
                break;
            default: {
                if (joda.value() == -1L && !joda.timestamp().equals("")) {
                   setToIso();
                }
                if ( joda.value() > 01L) {
                    setByMillis();
                }
            }
                break;


        }

        base.evaluate();

        LOG.fine(String.format("Re-setting Joda time to system time for %s", testName));
        DateTimeUtils.setCurrentMillisSystem();
    }

    private void setToFormat() {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(joda.format().pattern());
        DateTime dt = fmt.parseDateTime(joda.timestamp());
        DateTimeUtils.setCurrentMillisFixed(dt.getMillis());

    }

    private void setToIso() {
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        DateTime dt = fmt.parseDateTime(joda.timestamp());
        DateTimeUtils.setCurrentMillisFixed(dt.getMillis());
    }

    private void setByMillis() {
        DateTimeUtils.setCurrentMillisFixed(joda.value());
    }

}
