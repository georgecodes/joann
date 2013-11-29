package com.elevenware.joann;

import com.elevenware.joann.JodaAwareStatement;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A JUnit rule which allows tests annotated with {@link com.elevenware.joann.Joda}
 * to set/re-set Joda time
 */
public class JodaRule implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {

        return new JodaAwareStatement(base, description.getAnnotation(Joda.class), description.getDisplayName());

    }

}
