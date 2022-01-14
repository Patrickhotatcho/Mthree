package com.JavaBasic.HealthyHearts;

import java.io.IOException;
import java.util.Scanner;

public class HealthyHearts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your age?");
		
		try {
			int age = input.nextInt();
			int maxHR = 220-age;
			System.out.println("Your maximum heart rate should be "+maxHR+" beats per minute");
			System.out.println("Your target HR Zone is "+(int)(maxHR*0.5)+" - "+(int)(maxHR*0.85)+" beats per minute");
		}catch(RuntimeException e) {
			System.out.println("Invalid Input");
		}
	}

}
