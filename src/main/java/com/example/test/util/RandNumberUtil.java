package com.example.test.util;

import java.util.Random;

/**
 * 
 * @author laoqiang
 * the util class is use to generate four random number 
 * 
 *
 */
public class RandNumberUtil {
	private static final String source="abcdefghijklmnopqrst1234567890";
	public static String generateNumber() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<8;i++) {
		 sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}
    
}
