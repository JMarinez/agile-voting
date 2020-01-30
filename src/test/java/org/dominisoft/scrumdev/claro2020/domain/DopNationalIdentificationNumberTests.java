package org.dominisoft.scrumdev.claro2020.domain;

import org.dominisoft.scrumdev.claro2020.domain.DopNationalIdentificationNumber;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public final class DopNationalIdentificationNumberTests {
	
	/*
	 * 1. null -> NullPointerException
	 * 2. "   "-> IllegalArgumentException
	 * 3. 12 digits -> IllegalArgumentException
	 * 4. "68876gjg565" -> IllegalArgumentException
	 * 5. "012345678910" -> IllegalArgumentException
	 * 6. 10 digits -> IllegalArgumentException
	 * */

  public static class ConstructorMessageTests {

    @Test(expected = NullPointerException.class)
    public void rejects_null() {
    	new DopNationalIdentificationNumber(null);
    }

	@Test(expected = IllegalArgumentException.class)
	public void rejects_white_space_only() {
		new DopNationalIdentificationNumber("           ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void rejects_more_than_eleven() {
		String twelve = "123456789101";
		new DopNationalIdentificationNumber(twelve);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void rejects_less_than_eleven() {
		String ten = "1234567890";
		new DopNationalIdentificationNumber(ten);
	}
	
	
  }
}
