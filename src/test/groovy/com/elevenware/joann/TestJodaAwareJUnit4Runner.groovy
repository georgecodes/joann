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
package com.elevenware.joann

import com.elevenware.joann.JodaAwareJUnit4Runner
import org.joda.time.DateTimeUtils
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.assertTrue

@RunWith(JodaAwareJUnit4Runner)
class TestJodaAwareJUnit4Runner {

    @Test
    void shouldNotHaveJodaTimeSet() {

        long nowSystem = System.currentTimeMillis()
        long now = DateTimeUtils.currentTimeMillis()
        assertTrue((now >= nowSystem))
        assertTrue((now - nowSystem) < 10000L)

    }

    @Test
    @Joda(1385554748577L)
    void annotationSetsTime() {

        long seed = 1385554748577L
        long now = DateTimeUtils.currentTimeMillis()
        assertTrue((now >= seed))
        assertTrue((now - seed) < 10000L)

    }

}
