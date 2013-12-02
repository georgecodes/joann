#JoAnn

[![Build Status](https://travis-ci.org/georgecodes/joann.png?branch=master)](https://travis-ci.org/georgecodes/joann)

JoAnn - Joda Annotation - makes the use of [Joda time](http://http://www.joda.org/joda-time/) in your tests
easier, and gets boilerplate out of the way.

Writing some tests recently, as is often the case, I found myself reaching for [Joda Time](http://joda.org/joda-time). This library,
as most Java devs know, is less painful to deal with than the date utilities that the JDK ships with. The other neat thing about it is,
you can set the system time - well, Joda's view of it - to whatever you want. Very handy for testing code that might at some point create dates.

Anyways, a typical way of using Joda time in a test looks something like this
```java
class TestSomething {

    @Test
    void testthings() {
        DateTimeUtils.setCurrentMillisFixed(1385554748577L)
        // do some things
    }

    @After
    void reset() {
        DateTimeutils.setCurrentMillisSystem()
    }
}
```

A few things wrong here. First, it's tedious having to work in milliseconds. Second it's not especially legible, and thirdly you have to remember to reset the time to the real time *in a teardown method* in case your test fails.

So I came up with [JoAnn](https://github.com/georgecodes/joann), which makes things a bit simpler. JoAnn is so called because it's a **Jo**da **Ann**otation. It looks a bit like this
```java
@Test
@Joda(1385554748577L)
void testthings() {
    // do some things
}
```

That's (almost) it. No time fiddling bleeding into your tests, no need to remember to tear it down. Just the annotation. Oh, and a way of getting it invoked. You can use either a JUnit runner, or a JUnit rule, it makes no difference. I've provided both

## With a rule
```java
class MyTests {
    @Rule public JodaRule rule = new JodaRule()
}
```

## With a runner
```java
@RunWith(JodaAwareJUnit4Runner)
class MyTests {

}
```

It gets even less tedious.

You don't have to use milliseconds to set the time. Set a timestamp instead, and JoAnn will assume you meant an ISO8601 format
```java
@Test
@Joda(timestamp = "2013-11-29T10:13:22.192Z")
void testTheThings() {}
```

Or there are a few more out of the box:
```java
@Test
@Joda(timestamp = "2013-12-25", format = Format.YYYYMMDD)
void testMoreStuff() {}

@Test
@Joda(timestamp = "2012-11-19 13:03:22", format = Format.YYYYMMDD_HHMMSS)
void keepOnTesting() {}
```

Want to see the code? It's on [GitHub](https://github.com/georgecodes/joann)

Want to use it in a Maven project? It's now in Maven central.

```xml
<dependencies>
    <dependency>
        <groupId>com.elevenware</groupId>
        <artifactId>joann</artifactId>
        <version>1.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Enjoy.
