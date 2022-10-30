
package CS4780.project1;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
/**-------------------------------------(Part 1)----------------------------------------------------------------------------------------------**/
/**	
		//Creating the 10-bit raw keys
		byte[] rk1 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };		
		byte[] rk2 = new byte[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 }; 		
		byte[] rk3 = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };		
		
		// Initializing our 8-bit plain text
		byte[] pt1 = new byte[] { 1, 0, 1, 0, 1, 0, 1, 0 }; 
		byte[] pt2 = new byte[] { 0, 1, 0, 1, 0, 1, 0, 1 }; 		
		
		//Initializing cipher text to get plain text
		byte[] ct1 = new byte[] { 0, 0, 0, 1, 0, 0, 0, 1 };
		byte[] ct2 = new byte[] { 1, 1, 0, 0, 1, 0, 1, 0 };
		byte[] ct3 = new byte[] { 0, 1, 1, 1, 0, 0, 0, 0 }; // 8 bit
		byte[] ct4 = new byte[] { 0, 0, 0, 0, 0, 1, 0, 0 };
		
**/
		
		
/**-------------------------------------(test cases)----------------------------------------------------------------------------------
		SDES.Encrypt(rk1, pt1); // 00010001
		SDES.Decrypt(rk1, ct1); // 10101010
		
		SDES.Encrypt(rk2, pt1); // 11001010
		SDES.Decrypt(rk2, ct2); // 10101010
		
		SDES.Encrypt(rk2, pt2); // 01110000
		SDES.Decrypt(rk2, ct3); // 01010101
		
		SDES.Encrypt(rk3, pt1); // 00000100
		SDES.Decrypt(rk3, ct4); // 10101010
		**/
		
/**-----------------------------------(Part-1,{1,2,3,4})-------------------------------------------------------------------------------**/
/**		byte[] sdes_a = SDES.Encrypt(rk1, new byte[] {0, 0, 0, 0, 0, 0, 0, 0}); // ct = 1111000
		byte[] sdes_b =SDES.Encrypt(rk3, new byte[] {1, 1, 1, 1, 1, 1, 1, 1}); // ct = 00001111
		byte[] sdes_c =SDES.Encrypt(new byte[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },new byte[] {0, 0, 0, 0, 0, 0, 0, 0}); // ct = 01000011
		byte[] sdes_d =SDES.Encrypt(new byte[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[] {1, 1, 1, 1, 1, 1, 1, 1}); // ct = 11100001
		System.out.println("(PART-1,{1,2,3,4})\nCipher Text Results:\n"+Arrays.toString(sdes_a)+"\n"+Arrays.toString(sdes_b)+"\n"+Arrays.toString(sdes_c)+"\n"+Arrays.toString(sdes_d));
**/
	
		
/**-----------------------------------(Part-1,{5,6,7,8})-------------------------------------------------------------------------------**/
/**		byte[] sdes1 = SDES.Decrypt(new byte[] {1, 0, 0, 0, 1, 0, 1, 1, 1, 0}, new byte[] {0, 0, 0, 1, 1, 1, 0, 0});
		// pt = 00111000
		byte[] sdes2 =SDES.Decrypt(new byte[] {1, 0, 0, 0, 1, 0, 1, 1, 1, 0}, new byte[] {1, 1, 0, 1, 1, 1, 1, 0});
		// pt = 00001001
		byte[] sdes3 =SDES.Decrypt(new byte[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 1}, new byte[] {1, 0, 0, 1, 1, 1, 0, 1});
		// pt = 11111100
		byte[] sdes4 =SDES.Decrypt(new byte[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 1}, new byte[] {1, 0, 0, 1, 0, 0, 0, 0});
		// pt = 10100101
	System.out.println("(PART-1,{5,6,7,8})\nPlain Text Results:\n"+Arrays.toString(sdes1)+"\n"+Arrays.toString(sdes2)+"\n"+Arrays.toString(sdes3)+"\n"+Arrays.toString(sdes4)+"\n");		
**/		
	
/**---------------------------------- Part-2.Triple-SDES----------------------------------------------------------------**/
		byte[] rk01 = new byte[] {0,0,0,0,0,0,0,0,0,0};
		byte[] rk02 = new byte[] {1,0,0,0,1,0,1,1,1,0};
		byte[] rk03 = new byte[] {1,1,1,1,1,1,1,1,1,1};
		byte[] rk04 = new byte[] {1,0,1,1,1,0,1,1,1,1};
		byte[] rk05 = new byte[] {0,1,1,0,1,0,1,1,1,0};
		
		byte[] pt01 = new byte[] {0,0,0,0,0,0,0,0};
		byte[] pt02 = new byte[] {1,1,0,1,0,1,1,1};
		byte[] pt03 = new byte[] {1,0,1,0,1,0,1,0};
		

		// (PART-2,{1,2,3,4})
		byte[] tripDES01 = TripleSDES.Encrypt(rk01, rk01, pt01);		// Task(raw key 1,raw key 2, plain text)
		byte[] tripDES02 = TripleSDES.Encrypt(rk02, rk05, pt02);
		byte[] tripDES03 = TripleSDES.Encrypt(rk02, rk05, pt03);
		byte[] tripDES04 = TripleSDES.Encrypt(rk03, rk03, pt01);
		System.out.println("(PART-2,{1,2,3,4}):\n"+"8-bit Cipher Text: "+
				Arrays.toString(tripDES01)+"\n"+"8-bit Cipher Text: "+Arrays.toString(tripDES02)+
				"\n"+"8-bit Cipher Text: "+Arrays.toString(tripDES03)+"\n"+"8-bit Cipher Text: "+Arrays.toString(tripDES04));
		
		
		// (PART-2,{5,6,7,8})
		byte[] tripDES05 = TripleSDES.Decrypt(rk02, rk05, new byte[] {1,1,1,0,0,1,1,0});
		byte[] tripDES06 = TripleSDES.Decrypt(rk04, rk05, new byte[] {0,1,0,1,0,0,0,0});
		byte[] tripDES07 = TripleSDES.Decrypt(rk01, rk01, new byte[] {1,0,0,0,0,0,0,0});
		byte[] tripDES08 = TripleSDES.Decrypt(rk03, rk03, new byte[] {1,1,1,0,0,1,1,0});
		System.out.println("(PART-2,{5,6,7,8}):\n"+"8-bit Plain Text: "+
				Arrays.toString(tripDES05)+"\n"+"8-bit Plain Text: "+Arrays.toString(tripDES06)+
				"\n"+"8-bit Plain Text: "+Arrays.toString(tripDES07)+"\n"+"8-bit Plain Text: "+Arrays.toString(tripDES08));
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/**--------------------------------------------[Test Code]----------------------------------------------------------------------------------------
		byte[] key1 = new byte[8];
		byte[] key2 = new byte[8];

		key1 = SDES.generateKey1(rk);
		key2 = SDES.generateKey2(rk);

		System.out.println("Key1: " + Arrays.toString(key1));
		System.out.println("Key2: " + Arrays.toString(key2));

		byte[] ip = SDES.ip(ct);

		System.out.println("IP: " + Arrays.toString(ip));

		byte[] ep = SDES.ep(ip);

		System.out.println("EP: " + Arrays.toString(ep));

		byte[] xor = SDES.xor(ep, key2);

		System.out.println("XOR: " + Arrays.toString(xor));

		byte[] sbox = SDES.sbox(xor);

		System.out.println("sbox: " + Arrays.toString(sbox));

		byte[] p4 = SDES.p4(sbox);

		System.out.println("P4: " + Arrays.toString(p4));

		byte[] xor2 = SDES.xor2(SDES.getLeft(ip), p4);

		System.out.println("xor2: " + Arrays.toString(xor2));

		byte[] temp = new byte[8];
		for (int i = 0; i < 4; i++) {
			temp[i+4] = xor2[i];
		}

		byte[] swap = SDES.swap( xor2, SDES.getRight(ip));

		System.out.println("Swap: " + Arrays.toString(swap));

		ep = SDES.ep(swap);

		System.out.println("Round 2");
		System.out.println("EP: " + Arrays.toString(ep));

		xor = SDES.xor(ep, key1);

		System.out.println("xor: " + Arrays.toString(xor));
		
		sbox = SDES.sbox(xor);

		System.out.println("sbox: " + Arrays.toString(sbox));
		
		p4 = SDES.p4(sbox);

		System.out.println("P4: " + Arrays.toString(p4));
		
		xor2 = SDES.xor2(p4, SDES.getLeft(ip));

		System.out.println("xor2: " + Arrays.toString(xor2));
		
		for (int i = 0; i<4; i++) {
			temp[i] = xor2[i];
		}
		byte[] inverseIP = SDES.inverseIP(temp);

		System.out.println("inverse IP: " + Arrays.toString(inverseIP));
		
**/

	}

}
