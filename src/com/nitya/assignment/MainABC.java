package com.nitya.assignment;

public class MainABC {
	public static void main(String args[]) {
		A a = new A();

		C c = new C();

		try {
			a.b.c = c.b.a;
			System.out.println("MainABC Successfully Running.");
		} catch (Exception e) {
			System.out.println("Exception");
		}

	}
}
