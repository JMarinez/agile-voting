package org.dominisoft.scrumdev.claro2020.domain;

import org.junit.Test;

public class AdminTest {
	/*
	 * 1. userName = ""  && password = "" ->  IllegalArgumentException
	 * 2. userName doesn't exit -> IllegalArgumentException
	 * 3. userName exits, but password is incorrect -> IllegalArgumentException
	 * 4. userName "     " and password "      " -> IllegalArgumentException
	 * */
	@Test(expected = IllegalArgumentException.class)
	    public void rejects_string_empty() {
	    	new Admin("", "");
	    }
	
	
	
}
