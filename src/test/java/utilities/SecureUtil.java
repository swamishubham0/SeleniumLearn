package utilities;

import org.apache.commons.codec.binary.Base64;

public class SecureUtil {

	public static String getEncodedString(String text) {
		String encodedString = null;

		byte[] encoded = Base64.encodeBase64(text.getBytes());

		encodedString = new String(encoded);
		return encodedString;
	}

	public static String getDecodedString(String encodedString) {
		String decodedString = null;

		byte[] decoded = Base64.decodeBase64(encodedString);
		decodedString = new String (decoded);
		return decodedString;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getEncodedString("PASSWORD"));
//	}
}
