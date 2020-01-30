package org.dominisoft.scrumdev.claro2020.domain;

import org.dominisoft.scrumdev.claro2020.domain.DopNationalIdentificationNumber;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public final class DopNationalIdentificationNumberTests {
	
	/*
	 * 4. "68876gjg565" -> IllegalArgumentException
	 * 5. "012345678910" -> IllegalArgumentException
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
	
	@Test(expected = IllegalArgumentException.class)
	public void rejects_has_letters() {
		String letters = "1234sdf8901";
		new DopNationalIdentificationNumber(letters);
	}
	
	/*012345678910*/
	
	@Test(expected = IllegalArgumentException.class)
	public void rejects_pattern_invalid() {
		String pattern = "012345678910";
		new DopNationalIdentificationNumber(pattern);
	}
	
	
	
  }
}
