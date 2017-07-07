package com.techlabs.dogdoor;

import java.awt.List;
import java.util.Iterator;

public class BarkRecognizer {

	private DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(Bark bark) {
		System.out.println("   BarkRecognizer: Heard a '" + bark.getSound() + "'");
		List allowedBarks = (List) door.getAllowedBarks();
		for (Iterator i = ((java.util.List<Bark>) allowedBarks).iterator(); i.hasNext();) {
			Bark allowedBark = (Bark) i.next();
			if (allowedBark.equals(bark)) {
				door.open();
				return;
			}
		}
		System.out.println("This dog is not allowed.");
	}
}
