package com.bloc.threads;



public class Main extends Object {

	public static void main(String [] args) {

		// Extract content beneath to ImageGetter

		ImageGetter imageGetter = new ImageGetter();

		imageGetter.run();


		// ^^^ Extract the above to ImageGetter

		// This shouldn't exist yet, therefore we should be able to print 
		if (imageGetter.fileExists() == false) {
			System.out.println("/************************/");
			System.out.println("/*                      */");
			System.out.println("/*                      */");
			System.out.println("/*   If you see this,   */");
			System.out.println("/*   congratulations!   */");
			System.out.println("/*                      */");
			System.out.println("/*                      */");
			System.out.println("/************************/");	
		}
	}
}
