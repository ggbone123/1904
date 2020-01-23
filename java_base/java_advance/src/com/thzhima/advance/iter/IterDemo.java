package com.thzhima.advance.iter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterDemo {
	public static void main(String[] args) {
	
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("c");
		list.add("c++");
		list.add("c#");
		
		// ��ȡ��������
		Iterator<String> iter = list.iterator();
		
		// ��ʾ����������
		while(iter.hasNext()) {//�жϵ��������Ƿ�����һ��Ԫ��
			String s = iter.next(); //ȡ����������һ��Ԫ��
			System.out.println(s);
		}
		
		// ��ʽ����,for...eachѭ����ֻ����������͵������ӿ��ϡ�
		for(String s : list) {
			System.out.println(s);
		}
		
		
		
	}
}
