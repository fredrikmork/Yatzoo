package no.hvl.dat109.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.*;

class UnitTestRegler {
	private TerningSett ts = new TerningSett(5);
	private RegelBok regler = new RegelBok();

	
	@Test
	void testDyr() {
		for(Terning t: ts.getTerningSett()) {
			t.setDyr("love");
		}
		assertEquals(regler.dyr(ts, "love"), 5);
		assertFalse(regler.dyr(ts, "love") == 4);
	}
	
	@Test
	void testNLike() {
		for(Terning t: ts.getTerningSett()) {
			t.setDyr("love");
		}
		assertEquals(regler.nLike(ts, 3).equals("love"));
	
	}
	
	@Test
	void testToPar() {
		
	}
	
	@Test
	void testHus() {
		
	}
	
	

}
