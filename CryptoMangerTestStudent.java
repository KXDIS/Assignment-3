/*
 * Class: CMSC203 
 * Instructor:Ahmed Tarek
 * Description: Encryption and decryption software for bellaso
 * and Ceasar ciphers using an ASCII uppercase scale
 * Due: 10/10/23
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Hendrick Nguyen___
*/


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoMangerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HENDRICK"));
		assertTrue(CryptoManager.isStringInBounds("[I HATE THIS]"));
		assertFalse(CryptoManager.isStringInBounds("hendrick"));
		assertFalse(CryptoManager.isStringInBounds("{BELLASO"));
		assertFalse(CryptoManager.isStringInBounds("INVALID CHARACTER IN THE MIDDLE { TEST"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("this is out of bounds", 4));
		assertEquals("JGPFTKEM", CryptoManager.caesarEncryption("HENDRICK", 2));
		assertEquals("1201I4.BI?*5>.I=.<=", CryptoManager.caesarEncryption("HIGH KEY VALUE TEST", 105));
		assertEquals("POF!LFZ!UFTU", CryptoManager.caesarEncryption("ONE KEY TEST", 1));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HENDRICK", CryptoManager.caesarDecryption("JGPFTKEM", 2));
		assertEquals("HIGH KEY VALUE TEST", CryptoManager.caesarDecryption("1201I4.BI?*5>.I=.<=", 105));
		assertEquals("ONE KEY TEST", CryptoManager.caesarDecryption("POF!LFZ!UFTU", 1));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("SJ'$[\\#W", CryptoManager.bellasoEncryption("HENDRICK", "KEY IS LONGER THAN PLAINTEXT"));
		assertEquals("'PX%4\"F,3ZTS W^9[I!V", CryptoManager.bellasoEncryption("THIS WAS REALLY HARD", "SHORTKEY"));


	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("HENDRICK", CryptoManager.bellasoDecryption("SJ'$[\\#W", "KEY IS LONGER THAN PLAINTEXT"));
		assertEquals("THIS WAS REALLY HARD", CryptoManager.bellasoDecryption("'PX%4\"F,3ZTS W^9[I!V", "SHORTKEY"));

	}

}