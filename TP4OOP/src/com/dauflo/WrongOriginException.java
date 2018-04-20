package com.dauflo;
/*Alan GOBIN 1A FIP TIS*/

public class WrongOriginException extends Exception {

	public WrongOriginException(){
		System.out.println("Donnez des coordonnées positives.");
	}
}
