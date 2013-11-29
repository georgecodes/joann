package com.elevenware.joann;

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
