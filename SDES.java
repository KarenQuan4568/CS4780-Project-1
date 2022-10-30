package project1;

import java.util.Arrays;

public class SDES {
	static int[] p10 = new int[] { 2, 4, 1, 6, 3, 9, 0, 8, 7, 5 };
	static int[] ls1 = new int[] { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 };
	static int[] p8 = new int[] { 5, 2, 6, 3, 7, 4, 9, 8 };
	static int[] ls2 = new int[] { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 };
	static int[] ip = new int[] { 1, 5, 2, 0, 3, 7, 4, 6 };
	static int[] ipInverse = new int[] { 3, 0, 2, 4, 6, 1, 7, 5 };
	static int[] ep = new int[] { 7, 4, 5, 6, 5, 6, 7, 4 };
	static int[][] s0 = { { 1, 0, 3, 2 }, { 3, 2, 1, 0 }, { 0, 2, 1, 3 }, { 3, 1, 3, 2 } };
	static int[][] s1 = { { 0, 1, 2, 3 }, { 2, 0, 1, 3 }, { 3, 0, 1, 0 }, { 2, 1, 0, 3 } };
	static byte[][] intToByte = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public SDES() {
	};

	public static byte[] generateKey1(byte[] rawKey) {
		byte[] temp = new byte[10];
		byte[] rawCopy = new byte[10];
		byte[] key = new byte[8];

		for (int i = 0; i < 10; i++) {
			rawCopy[i] = rawKey[i];
		}

		// p10
		for (int i = 0; i < 10; i++) {
			int index = p10[i];
			temp[i] = rawCopy[index];
		}

		// ls1
		for (int i = 0; i < 10; i++) {
			int index = ls1[i];
			rawCopy[i] = temp[index];
		}

		// p8
		for (int i = 0; i < 8; i++) {
			int index = p8[i];
			key[i] = rawCopy[index];
		}

		//System.out.println("key1: " + Arrays.toString(key));

		return key;
	};

	public static byte[] generateKey2(byte[] rawKey) {
		byte[] temp = new byte[10];
		byte[] key = new byte[8];
		byte[] rawCopy = new byte[10];

		for (int i = 0; i < 10; i++) {
			rawCopy[i] = rawKey[i];
		}

		// p10
		for (int i = 0; i < 10; i++) {
			int index = p10[i];
			temp[i] = rawCopy[index];
		}

		// ls1
		for (int i = 0; i < 10; i++) {
			int index = ls1[i];
			rawCopy[i] = temp[index];
		}

		// ls2
		for (int i = 0; i < 10; i++) {
			int index = ls2[i];
			temp[i] = rawCopy[index];
		}

		// p8
		for (int i = 0; i < 8; i++) {
			int index = p8[i];
			key[i] = temp[index];
		}

		//System.out.println("key2: " + Arrays.toString(key));

		return key;

	}

	public static byte[] ip(byte[] pt) {
		byte[] temp = new byte[8];

		for (int i = 0; i < 8; i++) {
			int index = ip[i];
			temp[i] = pt[index];
		}

		return temp;
	}

	public static byte[] ep(byte[] ip) {
		// done with 4 right most bits after ip
		// 4 bits in 8 bits out; expand and permutate
		byte[] temp = new byte[8];
		for (int i = 0; i < 8; i++) {
			int index = ep[i];
			temp[i] = ip[index];
		}

		return temp;

	}

	public static byte[] xor(byte[] ep, byte[] k1) {
		byte[] temp = new byte[8];

		for (int i = 0; i < 8; i++) {
			temp[i] = (byte) (ep[i] ^ k1[i]);
		}

		return temp;

	}

	public static byte[] sbox(byte[] xor) {
		byte[] temp = new byte[4];

		// leftmost bits, s0
		int r1 = xor[0];
		int r2 = xor[3];

		int c1 = xor[1];
		int c2 = xor[2];

		// rightmost bits, s1
		int r3 = xor[4];
		int r4 = xor[7];

		int c3 = xor[5];
		int c4 = xor[6];

		// leftmost bits
		String row1 = Integer.toString(r1);
		String row2 = Integer.toString(r2);

		String col1 = Integer.toString(c1);
		String col2 = Integer.toString(c2);

		int rowNum = Integer.parseInt(row1 + row2, 2);
		int colNum = Integer.parseInt(col1 + col2, 2);

		// rightmost bits
		String row3 = Integer.toString(r3);
		String row4 = Integer.toString(r4);

		String col3 = Integer.toString(c3);
		String col4 = Integer.toString(c4);

		int rowNum2 = Integer.parseInt(row3 + row4, 2);
		int colNum2 = Integer.parseInt(col3 + col4, 2);

		// int to byte
		int index1 = s0[rowNum][colNum];
		int index2 = s1[rowNum2][colNum2];

		temp[0] = intToByte[index1][0];
		temp[1] = intToByte[index1][1];
		temp[2] = intToByte[index2][0];
		temp[3] = intToByte[index2][1];

		//System.out.println(Arrays.toString(temp));
		return temp;
	}

	public static byte[] p4(byte[] sbox) {
		byte[] temp = new byte[4];
		temp[0] = sbox[1];
		temp[1] = sbox[3];
		temp[2] = sbox[2];
		temp[3] = sbox[0];
		return temp;

	}

	public static byte[] xor2(byte[] p4, byte[] ipLeft) {
		byte[] temp = new byte[4];
		for (int i = 0; i < 4; i++) {
			temp[i] = (byte) (p4[i] ^ ipLeft[i]);
		}
		return temp;

	}

	public static byte[] swap(byte[] xor2, byte[] ipRight) {
		// xor2 ipRight -> ipRight xor2
		byte[] temp = new byte[8];

		for (int i = 0; i < 4; i++) {
			temp[i] = ipRight[i];
		}
		for (int i = 0; i < 4; i++) {
			temp[i+4] = xor2[i];
		}
		return temp;
	}
	
	public static byte[] inverseIP(byte[] xor2) {
		byte[] temp = new byte[8];
		
		for (int i = 0; i<8; i++) {
			int index = ipInverse[i];
			temp[i] = xor2[index];
		}
		return temp;

	}
	
	public static byte[] getLeft(byte[] ip) {
		byte[] temp = new byte[4];
		for (int i = 0; i<4; i++) {
			temp[i] = ip[i];
		}
		return temp;
	}
	
	public static byte[] getRight(byte[] ip) {
		byte[] temp = new byte[4];
		for (int i = 4; i<8; i++) {
			temp[i-4] = ip[i];
		}
		return temp;
	}
	
	public static byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		byte[] ciphertext = ip(plaintext);
		byte[] temp = new byte[8];
		
		//byte[] ip = ip(plaintext);
		
		byte[] key1 = generateKey1(rawkey);
		byte[] key2 = generateKey2(rawkey);
		
		//Round 1
		ciphertext = ep(ciphertext);
		ciphertext = xor(ciphertext, key1);
		ciphertext = sbox(ciphertext);
		ciphertext = p4(ciphertext);
		ciphertext = xor2(getLeft(ip(plaintext)), ciphertext);
		
		
		for (int i = 0; i<4; i++) {
			temp[i+4] = ciphertext[i];
		}
		

		ciphertext = swap(ciphertext, getRight(ip(plaintext)));
		
		//Round 2
		ciphertext = ep(ciphertext);
		ciphertext = xor(ciphertext, key2);
		ciphertext = sbox(ciphertext);
		ciphertext = p4(ciphertext);
		ciphertext = xor2(ciphertext, getRight(ip(plaintext)));
		
		for (int i = 0; i<4; i++) {
			temp[i] = ciphertext[i];
		}
		
		ciphertext = inverseIP(temp);
		
		System.out.println(Arrays.toString(ciphertext));
		
		return ciphertext;
	}
	
	public static byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		byte[] plaintext = ip(ciphertext);
		byte[] temp = new byte[8];
		byte[] forXor2 = new byte[4];
		
		
		byte[] key1 = generateKey1(rawkey);
		byte[] key2 = generateKey2(rawkey);
		
		//Round 1
		plaintext = ep(plaintext);
		plaintext = xor(plaintext, key2);
		plaintext = sbox(plaintext);
		plaintext = p4(plaintext);
		plaintext = xor2(getLeft(ip(ciphertext)), plaintext);
		
		
		for (int i = 0; i<4; i++) {
			temp[i+4] = plaintext[i];
		}
		

		plaintext = swap( plaintext, getRight(ip(ciphertext)));
		for (int i= 0; i<4; i++) {
			forXor2[i] = plaintext[i];
		}
		
		//Round 2
		plaintext = ep(plaintext);
		plaintext = xor(plaintext, key1);
		plaintext = sbox(plaintext);
		plaintext = p4(plaintext);
		plaintext = xor2(forXor2, plaintext);
		
		for (int i = 0; i<4; i++) {
			temp[i] = plaintext[i];
		}
		
		plaintext = inverseIP(temp);
		
		System.out.println(Arrays.toString(plaintext));
		return plaintext;
	}


}
