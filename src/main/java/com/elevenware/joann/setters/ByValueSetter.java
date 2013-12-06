package com.elevenware.joann.setters;

import com.elevenware.joann.AbstractDateSetter;
import com.elevenware.joann.Joda;

public class ByValueSetter extends AbstractDateSetter {

    @Override
    public boolean canHandle(Joda joda) {
        return false;
    }

    @Override
    public void setTime(Joda joda) {

    }

}
