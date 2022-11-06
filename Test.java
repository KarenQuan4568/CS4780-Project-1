package project1;

public class Test {

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
		byte[] ct5 = new byte[] { 1, 0, 0, 1, 0, 0, 1, 0 };

		SDES.Encrypt(rk1, new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 });// ct = 1111000

		SDES.Encrypt(rk3, new byte[] { 1, 1, 1, 1, 1, 1, 1, 1 });// ct = 00001111

		SDES.Encrypt(new byte[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 });// ct =
																											// 01000011

		SDES.Encrypt(new byte[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, new byte[] { 1, 1, 1, 1, 1, 1, 1, 1 });// ct =
																											// 11100001

		SDES.Decrypt(new byte[] { 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[] { 0, 0, 0, 1, 1, 1, 0, 0 });// pt =
																											// 00111000

		SDES.Decrypt(new byte[] { 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, new byte[] { 1, 1, 0, 1, 1, 1, 1, 0 });// pt =
																											// 00001001

		SDES.Decrypt(new byte[] { 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[] { 1, 0, 0, 1, 1, 1, 0, 1 });// pt =
																											// 11111100

		SDES.Decrypt(new byte[] { 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, new byte[] { 1, 0, 0, 1, 0, 0, 0, 0 });// pt =
																											// 10100101
	}

}
