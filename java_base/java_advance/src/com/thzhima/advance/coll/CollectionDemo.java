package com.thzhima.advance.coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<>();
		Collection<String> coll2 = new ArrayList<>();
		
		coll.add("java");// add�������򼯺������Ԫ��
		coll.add("c");
		coll.add("c--");
		coll.add("c#");
		System.out.println(coll);//toString()
		for(String s : coll) {
			System.out.println(s);
		}
		
		System.out.println("-------------------");
		coll2.add("java");
		coll2.add("c++");
		coll2.forEach(a->System.out.println(a));
		System.out.println("-------after add coll2 to coll-----------");
		coll.addAll(coll2);
		System.out.println(coll);
		
		coll2.add("python");
		
		// �жϼ������Ƿ����ĳһ��Ԫ��
		System.out.println("coll ���� java?"+(coll.contains("java")));
		// �жϸ����ļ����Ƿ��ǵ�ǰ���ϵ����Ӽ���
		System.out.println("coll ����coll2?"+(coll.containsAll(coll2)));
		Object c = ((ArrayList)coll).clone();
		
		// �Ƚϼ���������Ԫ���Ƿ�һ��
		System.out.println("coll equals c?"+coll.equals(c));
		
		System.out.println("hashCode:"+coll.hashCode());
		
		// �жϵ�ǰ�����Ƿ��ǿյġ�
		System.out.println("isEmpty?"+coll.isEmpty());
		
		// Collection�̳е�Iterable�ӿڷ���
		Iterator<String> iter = coll.iterator();
		while(iter.hasNext()) {
			String e = iter.next();
			System.out.println("Ԫ���ǣ�"+e);
		}
		
		// ���ϵĴ�С
		System.out.println("���ϴ�СΪ��"+coll.size());
		
		// ɾ��һ��Ԫ��
		coll.remove("c");
		System.out.println("ɾ��C�󣬴�СΪ��"+coll.size());
		
		// �ӵ�ǰ������ɾ�������а�����Ԫ��
		coll.removeAll(coll2);
		System.out.println(coll);
		
		((Collection)c).retainAll(coll2);
		System.out.println(c);
		
		Object[] array = coll.toArray();
		String[] a = coll.toArray(new String[coll.size()]);
		//���Ԫ��clear()
		coll.clear();
		System.out.println(coll.isEmpty());
		System.out.println(coll.size());
		
	}
	
}
