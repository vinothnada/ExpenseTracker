package com.expense.application.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class UserTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( com.expense.application.models.UserTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        User user = new User("testuser");
        assertEquals("testuser", user.getUserName());
    }
}
