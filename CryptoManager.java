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

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {

	private static final char LOWER_RANGE = ' '; //32
	private static final char UPPER_RANGE = '_'; //95
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_RANGE and UPPER_RANGE characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean isStringInBounds(String plainText) 
	{

		boolean inBounds = true;
			for (int i = 0; i < plainText.length(); i++) 
			{

				int charValue = plainText.charAt(i);
			
				if (charValue > UPPER_RANGE || charValue < LOWER_RANGE) 
					{  // Checks if current character is within bounds of chars for encryption
						inBounds = false;
					}
			}
		
		return inBounds;

	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
	
		String encryptedPlainText = "";  //Holds encrypted string
		int encryptedCharValue = 0;
		
		if (isStringInBounds(plainText)) 
			{			
			
				for (int i = 0; i < plainText.length(); i++) 
				{	
					encryptedCharValue = (int) plainText.charAt(i) + key; 
					//Shift char value using key integer
					
					while ((int)encryptedCharValue > UPPER_RANGE) 
					{
						encryptedCharValue -= RANGE;
					}
					
					encryptedPlainText += (char)encryptedCharValue;
					
				
							
				}		
			
		
			}	else 
				{
					encryptedPlainText = "The selected string is not in bounds, Try again.";
				}
	

		return encryptedPlainText;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) 
	{
		String encryptedPlainText = "";
		int bellasoStrRepeat = 0;
		int encryptionSum;
	
			
			if (isStringInBounds(plainText)) 
			{
				//First loop to create repeated bellasoStr cipher text
				for(int i = 0; i < plainText.length(); i++)
				{	
					while (bellasoStrRepeat > bellasoStr.length() - 1)
						{
							bellasoStrRepeat = 0;
						}
					
				encryptionSum = plainText.charAt(i) + bellasoStr.charAt(bellasoStrRepeat);
					while (encryptionSum > UPPER_RANGE)
						{
							encryptionSum -= RANGE;	
						}
				encryptedPlainText += ((char)encryptionSum);
				bellasoStrRepeat += 1;
				}
				
			}else 
				{
					encryptedPlainText = "The selected string is not in bounds, Try again.";
				}
	

		return encryptedPlainText;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		
		
		String plainText ="";
		int decryptedCharValue = 0;
		for (int i = 0; i < encryptedText.length(); i++) 
		{	
			decryptedCharValue = (int)encryptedText.charAt(i) - key; 
			//Shift char value using key integer
			System.out.println(decryptedCharValue);
			while ((int)decryptedCharValue < LOWER_RANGE) 
			{
				decryptedCharValue += RANGE;
			}
			
			plainText += (char)decryptedCharValue;
			
		
					
		}	
		
		
		
		
		
		return plainText;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	
		int bellasoStrRepeat = 0;
		int encryptionSum;
		String decryptedPlainText = "";
		
		for(int i = 0; i < encryptedText.length(); i++)
		{	
			while (bellasoStrRepeat > bellasoStr.length() - 1)
				{
					bellasoStrRepeat = 0;
				}
			
		encryptionSum = encryptedText.charAt(i) - bellasoStr.charAt(bellasoStrRepeat);
			while (encryptionSum < LOWER_RANGE)
				{
					encryptionSum += RANGE;	
				}
		decryptedPlainText += ((char)encryptionSum);
		bellasoStrRepeat += 1;
	}
		
		return decryptedPlainText;
	}
}