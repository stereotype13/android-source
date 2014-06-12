package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		ToyBox toyBox = new ToyBox();
		/*
		 * Put a bunch of Toys in toyBox!
		 */
		
		Toy<Book> myBook = new Toy<Book>(new Book());
		toyBox.addToy(myBook);

		Toy<Spoon> mySpoon = new Toy<Spoon>(new Spoon());
		toyBox.addToy(mySpoon);

		Toy<ActionFigure> myActionFigure = new Toy<ActionFigure>(new ActionFigure());
		toyBox.addToy(myActionFigure);

		Toy<Thing> myThing = new Toy<Thing>(new Thing("Some thing"));
		toyBox.addToy(myThing);

		if (toyBox.getToyCount() == 0) {
			System.out.println("Let's get some toys in that box!");
			System.exit(1);
		} else {
			System.out.println("Inside your toybox you've got:");
			for (int i = 0; i < toyBox.getToyCount(); i++) {
				System.out.println("- " + toyBox.getToyAtIndex(i).get());
			}
			System.out.println("Sounds like fun!\n");
		}

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
