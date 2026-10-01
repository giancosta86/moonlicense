package info.gianlucacosta.moonlicense;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopyrightYearsBuilderTest {

    @Test
    public void testGet_withInceptionYearEqualToCurrentYear() throws Exception {
        assertEquals(
                "2014",

                new CopyrightYearsBuilder()
                        .setInceptionYear(2014)
                        .setCurrentYear(2014)
                        .toString()
        );
    }


    @Test
    public void testGet_withInceptionYearBeforeCurrentYear() throws Exception {
        assertEquals(
                "2011-2014",

                new CopyrightYearsBuilder()
                        .setInceptionYear(2011)
                        .setCurrentYear(2014)
                        .toString()
        );
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGet_withInceptionYearAfterCurrentYear() throws Exception {
        assertEquals(
                "2014",

                new CopyrightYearsBuilder()
                        .setInceptionYear(2014)
                        .setCurrentYear(2001)
        );
    }
}