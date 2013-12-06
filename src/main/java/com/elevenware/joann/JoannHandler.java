package com.elevenware.joann;

public interface JoannHandler {

    void handle(Joda joda);
    boolean canHandle(Joda joda);
    void setTime(Joda joda);

}
