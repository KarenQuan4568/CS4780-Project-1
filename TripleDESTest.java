package project1;

import java.util.Arrays;

public class TripleDESTest {

	public static void main(String[] args) {

		byte[] rk = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		byte[] rk1 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte[] rk2 = new byte[] { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 };
		byte[] rk3 = new byte[] { 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		byte[] rk4 = new byte[] { 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };

		byte[] ct = new byte[] { 1, 0, 0, 1, 0, 0, 1, 0 }; // use with rk
		byte[] ct1 = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0 }; // use with rk1
		byte[] ct2 = new byte[] { 0, 1, 0, 1, 0, 0, 0, 0 }; // use with rk2, rk3
		byte[] ct3 = new byte[] { 1, 1, 1, 0, 0, 1, 1, 0 }; // use with rk4, rk3

		byte[] pt1 = new byte[] { 1, 0, 1, 0, 1, 0, 1, 0 }; // use with rk, use with rk4, rk3
		byte[] pt2 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 }; // use with rk1 
		byte[] pt3 = new byte[] { 1, 1, 0, 1, 0, 1, 1, 1 }; // use with rk4, rk3
		
		System.out.println(Arrays.toString(TripleSDES.Encrypt(rk1, rk1, pt2))); // 11110000
		System.out.println(Arrays.toString(TripleSDES.Encrypt(rk4, rk3, pt3))); // 10111001
		System.out.println(Arrays.toString(TripleSDES.Encrypt(rk4, rk3, pt1))); // 11100100
		System.out.println(Arrays.toString(TripleSDES.Encrypt(rk, rk, pt1)));   // 00000100
		System.out.println(Arrays.toString(TripleSDES.Decrypt(rk4, rk3, ct3))); // 11111101
		System.out.println(Arrays.toString(TripleSDES.Decrypt(rk2, rk3, ct2))); // 01001111
		System.out.println(Arrays.toString(TripleSDES.Decrypt(rk1, rk1, ct1))); // 01010010
		System.out.println(Arrays.toString(TripleSDES.Decrypt(rk, rk, ct)));	// 00100101


	}
}
