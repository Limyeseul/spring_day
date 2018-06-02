package org.comstudy21.saram.client;

import java.util.ArrayList;
import java.util.Collections;

import org.comstudy21.saram.model.Saram;

public class SaramManager {
	public static void main(String[] args) {
		Saram saram = new Saram("hong", "gildong", 21);
		System.out.println(saram);
		
		Saram[] saramArr = {
				new Saram("aaa", "AAA", 23),
				new Saram("bbb", "BBB", 21),
				new Saram("vvv", "VVV", 22),
				new Saram("ddd", "DDD", 20),
				new Saram("www", "WWW", 27)
		};
		
		// [] -> arrayList
		ArrayList<Saram> list = new ArrayList<>();
		Collections.addAll(list, saramArr);
		
		for(Saram s : list) {
			System.out.println(s);
		}
		
		System.out.println(list);
		
		
		// arrayList -> []
		Saram[] s2 = new Saram[list.size()];
		list.toArray(s2);
		for(Saram m : s2) {
			System.out.println(m);
		}
		
	}
}
