package com.test;

import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		String str=UUID.randomUUID().toString().replace("-", "").toUpperCase();
		
		System.out.println(str);
	}
}
