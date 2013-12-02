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

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The Joda annotation can be used in tests to set Joda time
 * <p>
 * The annotation can be attached to JUnit4 test methods, and along with either
 * {@link com.elevenware.joann.JodaAwareJUnit4Runner} or {@link com.elevenware.joann.JodaRule} will cause the Joda
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
    long value() default -1L;
    String timestamp() default "";
    Format format() default Format.DEFAULT;
}
