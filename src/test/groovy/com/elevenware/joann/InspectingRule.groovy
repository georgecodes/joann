package com.elevenware.joann

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class InspectingRule implements TestRule {

    def rule

    @Override
    Statement apply(Statement base, Description description) {
        this.rule = new JodaAwareStatement(base, description.getAnnotation(Joda.class), description.displayName)
        base
    }
}
