package project1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		byte[] rk1 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte[] rk2 = new byte[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 }; // 10 bit
		byte[] rk3 = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		byte[] pt1 = new byte[] { 1, 0, 1, 0, 1, 0, 1, 0 }; // 8 bit
		byte[] pt2 = new byte[] { 0, 1, 0, 1, 0, 1, 0, 1 }; // 8 bit
		
		byte[] ct1 = new byte[] { 0, 0, 0, 1, 0, 0, 0, 1 };
		byte[] ct2 = new byte[] { 1, 1, 0, 0, 1, 0, 1, 0 };
		byte[] ct3 = new byte[] { 0, 1, 1, 1, 0, 0, 0, 0 }; // 8 bit
		byte[] ct4 = new byte[] { 0, 0, 0, 0, 0, 1, 0, 0 };

		// test cases
//		SDES.Encrypt(rk1, pt1); // 00010001
//		SDES.Decrypt(rk1, ct1); // 10101010
//		
//		SDES.Encrypt(rk2, pt1); // 11001010
//		SDES.Decrypt(rk2, ct2); // 10101010
//		
//		SDES.Encrypt(rk2, pt2); // 01110000
//		SDES.Decrypt(rk2, ct3); // 01010101
//		
//		SDES.Encrypt(rk3, pt1); // 00000100
//		SDES.Decrypt(rk3, ct4); // 10101010
		
		// part 1 questions
		SDES.Encrypt(rk1, new byte[] {0, 0, 0, 0, 0, 0, 0, 0}); // ct = 1111000
		SDES.Encrypt(rk3, new byte[] {1, 1, 1, 1, 1, 1, 1, 1}); // ct = 00001111
		SDES.Encrypt(new byte[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },new byte[] {0, 0, 0, 0, 0, 0, 0, 0}); // ct = 01000011
		SDES.Encrypt(new byte[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[] {1, 1, 1, 1, 1, 1, 1, 1}); // ct = 11100001
		
		SDES.Decrypt(new byte[] {1, 0, 0, 0, 1, 0, 1, 1, 1, 0}, new byte[] {0, 0, 0, 1, 1, 1, 0, 0});
		// pt = 00111000
		SDES.Decrypt(new byte[] {1, 0, 0, 0, 1, 0, 1, 1, 1, 0}, new byte[] {1, 1, 0, 1, 1, 1, 1, 0});
		// pt = 00001001
		SDES.Decrypt(new byte[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 1}, new byte[] {1, 0, 0, 1, 1, 1, 0, 1});
		// pt = 11111100
		SDES.Decrypt(new byte[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 1}, new byte[] {1, 0, 0, 1, 0, 0, 0, 0});
		// pt = 10100101
		
//		byte[] key1 = new byte[8];
//		byte[] key2 = new byte[8];
//
//		key1 = SDES.generateKey1(rk);
//		key2 = SDES.generateKey2(rk);
//
//		System.out.println("Key1: " + Arrays.toString(key1));
//		System.out.println("Key2: " + Arrays.toString(key2));
//
//		byte[] ip = SDES.ip(ct);
//
//		System.out.println("IP: " + Arrays.toString(ip));
//
//		byte[] ep = SDES.ep(ip);
//
//		System.out.println("EP: " + Arrays.toString(ep));
//
//		byte[] xor = SDES.xor(ep, key2);
//
//		System.out.println("XOR: " + Arrays.toString(xor));
//
//		byte[] sbox = SDES.sbox(xor);
//
//		System.out.println("sbox: " + Arrays.toString(sbox));
//
//		byte[] p4 = SDES.p4(sbox);
//
//		System.out.println("P4: " + Arrays.toString(p4));
//
//		byte[] xor2 = SDES.xor2(SDES.getLeft(ip), p4);
//
//		System.out.println("xor2: " + Arrays.toString(xor2));
//
//		byte[] temp = new byte[8];
//		for (int i = 0; i < 4; i++) {
//			temp[i+4] = xor2[i];
//		}
//
//		byte[] swap = SDES.swap( xor2, SDES.getRight(ip));
//
//		System.out.println("Swap: " + Arrays.toString(swap));
//
//		ep = SDES.ep(swap);
//
//		System.out.println("Round 2");
//		System.out.println("EP: " + Arrays.toString(ep));
//
//		xor = SDES.xor(ep, key1);
//
//		System.out.println("xor: " + Arrays.toString(xor));
//		
//		sbox = SDES.sbox(xor);
//
//		System.out.println("sbox: " + Arrays.toString(sbox));
//		
//		p4 = SDES.p4(sbox);
//
//		System.out.println("P4: " + Arrays.toString(p4));
//		
//		xor2 = SDES.xor2(p4, SDES.getLeft(ip));
//
//		System.out.println("xor2: " + Arrays.toString(xor2));
//		
//		for (int i = 0; i<4; i++) {
//			temp[i] = xor2[i];
//		}
//		byte[] inverseIP = SDES.inverseIP(temp);
//
//		System.out.println("inverse IP: " + Arrays.toString(inverseIP));
//		

		
	}

}
