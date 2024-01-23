package com.ssafy.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenericWildCardTest {

	public static void main(String[] args) {

		String s;
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("토토"));
		dogs.add(new Dog("아롱이"));
		
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat("샤밍"));
		cats.add(new Cat("지니"));
		
		ArrayList<Tiger> tigers = new ArrayList<Tiger>();
		tigers.add(new Tiger());
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("동물1"));
		animals.add(new Animal("동물2"));
	
		ArrayList<Object> objects = new ArrayList<Object>();
		objects.add(new Object());
		
		
		
//		print0(dogs);
//		print0(cats);
//		print0(tigers);
//		print0(animals);
//		print0(objects);
		
//		print1(dogs);
//		print1(cats);
//		print1(tigers);
//		print1(animals);
//		print1(objects); // error
		
//		print(dogs);// error
		print(cats);
//		print(tigers);// error
		print(animals);
		print(objects); 
		
		System.out.println(dogs);
		Collections.sort(dogs, new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		System.out.println(dogs);
		
	}
	
	static void print0(ArrayList<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}
	
	static void print1(ArrayList<? extends Animal> list) {
		for (Animal animal : list) {
			System.out.println(animal);
			animal.speak();
		}
	}
	
	static void print(ArrayList<? super Cat> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

}







