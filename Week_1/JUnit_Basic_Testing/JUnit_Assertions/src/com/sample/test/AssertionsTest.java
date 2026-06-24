package com.sample.test;
import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(6, 4 + 2);
        assertTrue(19 > 12);
        assertFalse(11 <4 );
        assertNull(null);
        assertNotNull(new Object());
    }
}