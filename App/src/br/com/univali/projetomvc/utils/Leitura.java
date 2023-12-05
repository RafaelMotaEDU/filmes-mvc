package br.com.univali.projetomvc.utils;

import java.util.Scanner;

public class Leitura {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int LeInt(String msg) {
		System.out.print(msg);
		return sc.nextInt();
	}
	
	public static double LeDouble(String msg) {
		System.out.print(msg);
		return sc.nextDouble();
	}
	
	public static String leStr(String msg) {
		System.out.print(msg);
		sc = new Scanner(System.in);
		return sc.nextLine();
	}

}