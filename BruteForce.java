package project1;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {

	public static boolean punctuation(String s) {
		char[] chars = { '.', ';', ':', '!', '?', ',' };

		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			for (int j = 0; j < chars.length; j++) {
				if (c == chars[j] && s.charAt(i + 1) != ' ')
					return false;
			}
		}

		return true;
	}

	public static byte[] getKey(int k) {

		String s = Integer.toBinaryString(k);
		byte[] returnKey = new byte[10];
		int start = 10 - s.length();

		if (s.length() < 10) {
			for (int i = 0; i < start; i++) {
				returnKey[i] = 0;
			}
		}
		int sIndex = 0;

		while (sIndex < s.length()) {
			returnKey[start] = (byte) s.charAt(sIndex);
			returnKey[start] = (byte) (returnKey[start] - 48);
			start += 1;
			sIndex += 1;

		}

		return returnKey;
	}

	public static void main(String[] args) {

		// ------------------------------------------------- Question 3 Part 2 ---------------------------------------------------------
		// convert from string to arrays of length 8
//		String s = "1011011001111001001011101111110000111110100000000001110111010001111011111101101100010011000000101101011010101000101111100011101011010111100011101001010111101100101110000010010101110001110111011111010101010100001100011000011010101111011111010011110111001001011100101101001000011011111011000010010001011101100011011110000000110010111111010000011100011111111000010111010100001100001010011001010101010000110101101111111010010110001001000001111000000011110000011110110010010101010100001000011010000100011010101100000010111000000010101110100001000111010010010101110111010010111100011111010101111011101111000101001010001101100101100111001110111001100101100011111001100000110100001001100010000100011100000000001001010011101011100101000111011100010001111101011111100000010111110101010000000100110110111111000000111110111010100110000010110000111010001111000101011111101011101101010010100010111100011100000001010101110111111101101100101010011100111011110101011011";
//		byte[] b = new byte[s.length()];
//		ArrayList<byte[]> msg = new ArrayList<byte[]>();
//
//		// convert string to byte[]
//		for (int i = 0; i < s.length(); i++) {
//			b[i] = (byte) s.charAt(i);
//			b[i] = (byte) (b[i] - 48);
//		}
//		// split into arrays of length 8
//		for (int i = 0; i < b.length; i += 8) {
//			byte[] temp = Arrays.copyOfRange(b, i, i + 8);
//			msg.add(temp);
//
//		}
//
//		// number of iterations
//		int count = 0;
//
//		// decryption
//		for (int z = 0; z < 1024; z++) {
//			ArrayList<byte[]> decrypted = new ArrayList<byte[]>();
//			byte[] dArray = new byte[b.length];
//			int k = 0;
//			byte[] rawKey = getKey(z);
//
//			// sdes decrypt
//			for (int i = 0; i < msg.size(); i++) {
//				byte[] temp = SDES.Decrypt(rawKey, msg.get(i));
//				decrypted.add(temp);
//			}
//			// combine back into one array
//			for (int i = 0; i < decrypted.size(); i++) {
//				byte[] temp = decrypted.get(i);
//				for (int j = 0; j < temp.length; j++) {
//					dArray[k] = temp[j];
//					k += 1;
//				}
//			}
//
//			// convert CASCII to string
//			String r = CASCII.toString(dArray);
//			System.out.println(r);
//			System.out.println(Arrays.toString(rawKey));
//			count += 1;
//
//			// check conditions
//			if (punctuation(r) && r.contains("THE")) {
//				break;
//
//			}
//		}
//		System.out.println(count);
	
	//--------------------------------------------------- Question 3 Part 2 END ---------------------------------------------------------------
	
	//--------------------------------------------------- Question 3 Part 3 -------------------------------------------------------------------
	String txt = "00011111100111111110011111101100111000000011001011110010101010110001011101001101000000110011010111111110000000001010111111000001010010111001111001010101100000110111100011111101011100100100010101000011001100101000000101111011000010011010111100010001001000100001111100100000001000000001101101000000001010111010000001000010011100101111001101111011001001010001100010100000";
	
	byte[] bArray = new byte[txt.length()];
	ArrayList<byte[]> msgList = new ArrayList<byte[]>(); // original msg split into arrays of 8 bit
	boolean check = false;

	// convert string to byte[]
	for (int i = 0; i < txt.length(); i++) {
		bArray[i] = (byte) txt.charAt(i);
		bArray[i] = (byte) (bArray[i] - 48);
	}
	// split into arrays of length 8
	for (int i = 0; i < bArray.length; i += 8) {
		byte[] temp = Arrays.copyOfRange(bArray, i, i + 8);
		msgList.add(temp);
	}
	
	// -------------------decryption------------------
	//number of iterations
	int count2 = 0;
	
	// 2 for loops for 2 rawkeys
	for (int i=0; i<1024; i++) {
		if (check == true) break;
		byte[] rawKey1 = getKey(i);

		for (int j=0; j<1024; j++) {
			ArrayList<byte[]> decrypted = new ArrayList<byte[]>();
			byte[] dArray = new byte[bArray.length];
			int k = 0;
			byte[] rawKey2 = getKey(j);

			// decrypt put into arraylist
			for (int x = 0; x < msgList.size(); x++) {
				byte[] temp = TripleSDES.Decrypt(rawKey1,rawKey2, msgList.get(x));
				decrypted.add(temp);
			}
			
			// combine into one array
			for (int y = 0; y < decrypted.size(); y++) {
				byte[] temp = decrypted.get(y);
				for (int z = 0; z < temp.length; z++) {
					dArray[k] = temp[z];
					k += 1;
				}
			}

			// convert CASCII to string
			String r = CASCII.toString(dArray);
			System.out.println(r);
			System.out.println(Arrays.toString(rawKey1));
			System.out.println(Arrays.toString(rawKey2));
			count2 += 1;

			
			// check conditions
			if (punctuation(r) && r.contains("THE")) {
				check = true;
				break;

			}
		}
		System.out.println(count2);
		}
	//---------------------------------------------------- Question 3 Part 3 END ----------------------------------------------------------------
	}

}
