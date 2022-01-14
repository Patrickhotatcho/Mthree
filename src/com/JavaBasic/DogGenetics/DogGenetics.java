package com.JavaBasic.DogGenetics;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
	public static void main(String[] args) {

		String[] dogGens = { "St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman" };
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("What is your dog name?");
		String name = input.next();
		System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.");
		System.out.println();
		
		int GenPercent = rand.nextInt(101);
		int totalPercent = 0;
		for(String gen: dogGens) {
			System.out.println(GenPercent +"% " + gen);
			totalPercent = totalPercent + GenPercent;
			GenPercent = rand.nextInt(101 - totalPercent);
		}
		
		System.out.println("Wow, that's QUITE the dog!");
	}
}
