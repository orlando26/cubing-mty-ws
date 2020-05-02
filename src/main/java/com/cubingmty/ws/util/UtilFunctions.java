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

	public static String parseTimeToString(Integer time){
		double seconds = Math.floor((time/1000) % 60);
		double minutes = Math.floor((time/1000/60) % 60);
		double ms = Math.floor(time % 1000);

		System.out.println(minutes);

		String secondsStr = seconds < 10 ? ("0" + seconds) : String.valueOf(seconds);
		String minutesStr = minutes < 10 ? ("0" + minutes) : String.valueOf(minutes);
		String msStr = ms < 100 ? (ms < 10 ? ("00" + ms) : ("0" + ms))  : String.valueOf(ms);
		System.out.println(minutesStr);
      return minutesStr.replace(".0", "") + ':' + secondsStr.replace(".0", "") + '.' + msStr.replace(".0", "").substring(0, 2);
	}

	public static String hash(String message) {
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
