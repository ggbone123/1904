package com.thzhima.base;

import java.util.Date;

public class StringMethod {
	
	public static void main(String[] args) {
		String s = "china";
		String s1 = s.toUpperCase();
		System.out.println(s);
		System.out.println(s1);
		
		System.out.println(s1.toLowerCase());
		System.out.println(s1.charAt(0));
		System.out.println(s.indexOf("h"));
		System.out.println(s.lastIndexOf((int)'c'));
		System.out.println("china is my country.".lastIndexOf(" ",7));
		String ss = "hello ".concat("world");// "hello " + "world"
		System.out.println(ss);
		
		System.out.println(s.contains("ch"));
		System.out.println(s.contentEquals("china1"));
		System.out.println(s.equals("china"));
		System.out.println(s.equalsIgnoreCase("chINa"));
		System.out.println(s.endsWith("a"));
		
		// ��ʽ��%�ڼ�������/����/����
		// ��n���� n$ 
		// 4�������ַ����� 4s
		// ȡ��2��6�������ַ�����%2$6s
		String sss  = String.format("my age is %2$8s. my name is %1$4s.", "20", "wang");
		System.out.println(sss);
		
		Date now = new Date();
		String snow = String.format("������%1$tY��%1$tm��%1$td��,%1$tA������%1$tHʱ%1$tM��", now);
		System.out.println(snow);
		System.out.println("   ds f   ".trim().length());
		System.out.println("   sd f   ".replace(" ", ""));
		
		String[] a = "china is my country".split("\\s");
		for(String i : a) {
			System.out.print(i + ",");
		}
		System.out.println("--------------------------");
		System.out.println(snow.substring(10));
		
		String x = String.valueOf(90);
		System.out.println(x instanceof String);
		
		
		
	}
}
