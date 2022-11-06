package project1;

import java.util.ArrayList;
import java.util.Arrays;

public class Encode {

	public static void main(String[] args) {
		//------------------------ Question 3 part 1 ------------------------------------

		String s = "CRYPTOGRAPHY";
		byte[] key = { 0, 1, 1, 1, 0, 0, 1, 1, 0, 1 };
		ArrayList<byte[]> msg = new ArrayList<byte[]>();

		// string to CASCII -> encrypt with key
		byte[] b = CASCII.Convert(s);
		byte[] encrypted = new byte[b.length];
		
		System.out.println("Original CASCII message: ");
		System.out.println(Arrays.toString(b));

		// split into 8-bit arrays to encrypt
		for (int i = 0; i < b.length; i += 8) {
			byte[] temp = Arrays.copyOfRange(b, i, i + 8);
			temp = SDES.Encrypt(key, temp);
			msg.add(temp);
			for (int j = 0; j < temp.length; j++) {
				encrypted[i + j] = temp[j];
			}

		}
		
		System.out.println("\nEncrypted with SDES: ");
		System.out.println(Arrays.toString(encrypted));

		//---------check output-----------------------------------
		byte[] decrypted = new byte[b.length];
		int k = 0;

		// decrypt and combine back into one array
		for (int i = 0; i < 8; i++) {
			byte[] d = SDES.Decrypt(key, msg.get(i));
			for (int j = 0; j < d.length; j++) {
				decrypted[k] = d[j];
				k += 1;
			}
		}
		System.out.println("\nDecrypted with SDES: ");
		System.out.println(Arrays.toString(decrypted));
		System.out.println("\nDecrypted CASCII message: " + CASCII.toString(decrypted));
		

	}
}
