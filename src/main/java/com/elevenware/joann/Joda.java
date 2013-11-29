package com.elevenware.joann;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The Joda annotation can be used in tests to set Joda time
 * <p>
 * The annotation can be attached to JUnit4 test methods, and along with either
 * {@link JodaAwareJUnit4Runner} or {@link JodaRule} will cause the Joda
 * time to be set accordingly. Either mechanism also re-sets Joda time to system
 * time when each annotated test finishes.
 * </p>
 * @author George McIntosh
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Joda {

    /**
     *
     * value:
     * The time in milliseconds to set Joda time to for the duration of the test
     */
    long value();
}
