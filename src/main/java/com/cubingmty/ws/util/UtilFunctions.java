package com.cubingmty.ws.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UtilFunctions {
 
	public static <T> List<T> getListFromIteralbe(Iterable<T> itr) { 
		// Create an empty Collection to hold the result 
		List<T> cltn = new ArrayList<T>(); 

		// Use iterable.forEach() to 
		// Iterate through the iterable and 
		// add each element into the collection 
		itr.forEach(cltn::add); 

		// Return the converted collection 
		return cltn; 
	} 
	
	public static String hash(String message){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			md = null;
			e.printStackTrace();
		}
		md.update(message.getBytes());

		byte byteData[] = md.digest();


		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
