package com.bloc.singletons;

import com.bloc.singletons.listeners.*;
import com.bloc.singletons.talkers.*;

public class Main extends Object {

	public static void main(String [] args) {
		// Instantiate some talkers and some listeners
		// Register listeners
		// Send messages!
		
		AudienceMember am = new AudienceMember();
		Child child = new Child();
		Pet pet = new Pet();

		Parent parent = new Parent();
		PetOwner petOwner = new PetOwner();
		Singer singer = new Singer();

		Speakerphone mSpeakerPhone = Speakerphone.get();
		mSpeakerPhone.addListener(am);
		mSpeakerPhone.addListener(child);
		mSpeakerPhone.addListener(pet);

		mSpeakerPhone.shoutMessage(parent);
		mSpeakerPhone.shoutMessage(petOwner, pet.getClass());

		return;
	}
}
