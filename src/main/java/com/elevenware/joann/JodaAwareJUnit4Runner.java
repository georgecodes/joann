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

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * The JodaAwareJUnit4Runner can be used to run tests which use the
 * {@link com.elevenware.joann.Joda} annotation
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
        Joda joda = method.getAnnotation(Joda.class);
        return ( joda == null ) ? statement : new JodaAwareStatement(statement, joda, method.getName());
    }

}
