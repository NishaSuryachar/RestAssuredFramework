package com.backend.testing;

public class A1 {

	public static A1 a()
	{
		System.out.println("executed mtd a");
		return new A1();
	}
	
	public static A1 b()
	{
		System.out.println("executed mtd b");
		return new A1();
	}
	
	public static B1 c()
	{
		System.out.println("executed mtd c");
		return new B1();
	}
	
}
