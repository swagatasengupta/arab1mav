package rnd;

import java.util.Base64;

import lib.UtilLib;

public class EncodeDecodeDemo {

	public static void main(String[] args) {
		String decodedPassword = new String(Base64.getDecoder().decode("cGFzc3dvcmQ="));
		System.out.println(decodedPassword);
		
		String encodedPassword = new String(Base64.getEncoder().encode(new String("password").getBytes()));
		System.out.println(encodedPassword);
		
		System.out.println("encoded password for 12345 is " + UtilLib.encodeString("12345"));
		System.out.println("encoded password for onestar is " + UtilLib.encodeString("onestar"));
		
	}

}
