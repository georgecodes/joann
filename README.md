#JoAnn

JoAnn - Joda Annotation - makes the use of [Joda time](http://http://www.joda.org/joda-time/) in your tests
easier, and gets boilerplate out of the way.

## Usage

Any test that needs Joda time set prior to running can be annotated using the annotation
com.elevenware.joann.Joda, giving the required time in milliseconds:

    @Joda(1385554748577L)
    @Test
    public void thisTestNeedsFixedTime() {
        blah();
        assertThingsWork();
    }

To ensure the annoation is picked up, you can either use a JUnit test runner, or a JUnit rule:

### Using the test runner

    @RunWith(JodaAwareJUnit4Runner.class)
    public class TimeDependentTests {}

### Using a rule

    public class TimeDependentTests {

        @Rule public JodaRule rule = new JodaRule();

    }

Note that either way round, you do not need to explicitly re-set Joda time to the system time in a teardown.
Joann takes care of that for you.