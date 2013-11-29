package com.elevenware.joann;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * The JodaAwareJUnit4Runner can be used to run tests which use the
 * {@link com.elevenware.testutils.joda.Joda} annotation
 * <p>
 * Use the JUnit @RunWith annotation with this class, and any tests
 * annotated with @Joda will have Jodatime set at the start, and re-set
 * to system time at the end.
 * </p>
 * @author George McIntosh
 * @since 1.0
 */
public class JodaAwareJUnit4Runner extends BlockJUnit4ClassRunner {

    public JodaAwareJUnit4Runner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        Statement statement = super.methodInvoker(method, test);
        return new JodaAwareStatement(statement, method.getAnnotation(Joda.class), method.getName());
    }

}
