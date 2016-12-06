package com.ph.hms.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> cols = new ArrayList<Integer>();
		cols.add(1);
		cols.add(4);
		cols.add(2);
		cols.add(3);
		
		Enc e = new Enc("thanh", cols);
		
		List<Integer> newcols = (ArrayList<Integer>)e.getCols();
		
		Collections.sort(newcols);
		
		e.setCols(newcols);
		
		for(Integer i:e.getCols())
		{
			System.out.println(i);
		}	
		


	}

}
