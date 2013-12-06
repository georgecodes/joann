package com.elevenware.joann.setters;

import com.elevenware.joann.AbstractDateSetter;
import com.elevenware.joann.JoannException;
import com.elevenware.joann.Joda;

public class DefaultDateSetter extends AbstractDateSetter {

    @Override
    public boolean canHandle(Joda joda) {
        return true;
    }

    @Override
    public void setTime(Joda joda) {
        throw new JoannException("No way of setting time");
    }
}
