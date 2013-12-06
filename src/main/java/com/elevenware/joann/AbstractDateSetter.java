package com.elevenware.joann;

public abstract class AbstractDateSetter implements JoannHandler {

    private JoannHandler next;

    public AbstractDateSetter() {}

    public AbstractDateSetter(AbstractDateSetter next) {
        this.next = next;
    }

    public void handle(Joda joda) {
        if(canHandle(joda)) {
            setTime(joda);
        } else {
            next.handle(joda);
        }
    }

}
