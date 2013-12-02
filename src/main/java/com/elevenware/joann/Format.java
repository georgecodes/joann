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

/**
 * Format
 * Represents different input formats for setting Joda time
 *
 * @since 1.0
 * @author George McIntosh
 */
public enum Format {

    DEFAULT(""),
    USE_MILLIS(""),
    ISO(""),
    YYYYMMDD("yyyy-MM-dd"),
    YYYYMMDD_HHMMSS("yyyy-MM-dd HH:mm:ss");

    private Format(String pattern) {
        this.pattern = pattern;
    }
    private String pattern;

    public String pattern() {
        return this.pattern;
    }

}
