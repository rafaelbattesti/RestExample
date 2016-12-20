package com.rafaelbattesti.testmodel;
import com.rafaelbattesti.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

public class GreetingTest {
	
	private Greeting cut = null;
	private final long ID = 50;
	private final String CONTENT = "Hello Test!";
	
	@Before
	public void setup() {
        cut = new Greeting(ID, CONTENT);
	}
	
    @Test 
    public void testGetId() {
        assertTrue("getID() should return 50", cut.getId() == ID);
    }
    
    @Test 
    public void testGetContent() {
        assertTrue("getID() should return 'Hello Test'", cut.getContent() == CONTENT);
    }
}
