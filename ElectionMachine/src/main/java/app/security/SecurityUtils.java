package app.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * This is security layer responsible for hashing the password created and add salt
 * to randomize the password hashing so there won't be similar encryption to similar passwords.
 * 
 * @author team6 (Nori, Jesse, Basil) 
 * version 0.3
 */
public class SecurityUtils {

	/**
	 * @param password encrypts password using digest algorithm (SHA-256) and returns the MessageDigest with a getInstance function
	 * @param salt generates a strong random number (hashing to randomize password encryption)
	 * @return
	 */
	public static String getPasswordHashed(String password, String salt) {

		String result = "";

		try {
			// used hash function given (SHA-256)
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] saltBytes = Base64.getDecoder().decode(salt);
			md.update(saltBytes);
			byte[] bytes = md.digest(password.getBytes());

			// encode bytearray to string
			result = Base64.getEncoder().encodeToString(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String getSalt() {
		String result = "";

		SecureRandom rd = new SecureRandom();// getting random salt
		byte[] salt = new byte[16];
		rd.nextBytes(salt);
		// encode bytearray to string
		result = Base64.getEncoder().encodeToString(salt);
		return result;
	}

	public static boolean isPasswordOk(String storedHash, String password, String storedSalt) {
		// storedHash and storedSalt are found from databasetabe (stored per username)
		// password is given in login form
		if (storedHash.equals(getPasswordHashed(password, storedSalt))) {
			return true;
		}
		return false;
	}

}
