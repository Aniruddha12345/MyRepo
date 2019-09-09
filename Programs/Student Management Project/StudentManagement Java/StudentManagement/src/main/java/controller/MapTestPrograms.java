package controller;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MapTestPrograms {

	public static void main(String[] args) {
		Map m  = new IdentityHashMap();
		Integer I1 = new Integer(10);
		Integer I2 = new Integer(10);
		
		Integer i1 = 10;
		Integer i2 = 10;
		m.put(I1, "Aniruddha");
		m.put(I2, "Karuley");
		/*System.out.println(m);	
		System.out.println(I1==i1);*/
		
		Float f1 = new Float(11.11);
		Float f2 = new Float(11.11);
		Float f3 = 11.11F;
		Float f4 =  11.11F;
		
		Long l1 = new Long(10);
		Long l2 = new Long(10);
		Long l3 = 10L;
		Long l4 = 10L;
		
		System.out.println(l1.equals(l3));
		
	}
}

class HashWeakHashTest{
	public static void main(String[] args) {
		
		
		Map m = new WeakHashMap();
		Integer I1 = new Integer(10);
		Integer I2 = new Integer(20);
		m.put(I1, "Hii");
		m.put(I2, "Hello");
		I1 = null;
		System.gc();
		System.out.println(m);
		
		
		
	}
	
}

