package com.bloc.singletons;

import java.util.*;

/*
 * This is a singleton class which maintains communication
 * between classes and Listeners
 */
public class Speakerphone extends Object {
	

	private static Speakerphone mSpeakerphone;
	private List<Listener> mListeners; 

	private Speakerphone() {
		mListeners = new ArrayList<Listener>();
	}

	/*
	 * get
	 * @return the singleton instance of Speakerphone
	 */
	public static Speakerphone get() {
		if(mSpeakerphone == null) {
			mSpeakerphone = new Speakerphone();
		}
		return mSpeakerphone;
	}

	/*
	 * addListener
	 * Add a listener to Speakerphone's list
	 * @param listener an instance of the Listener interface
	 */
	public void addListener(Listener listener) {
		mListeners.add(listener);
		return;
	}

	/*
	 * removeListener
	 * Remove a Listener from the Speakerphone's list
	 * @param listener the Listener to remove
	 */
	public void removeListener(Listener listener) {
		mListeners.remove(listener);
		return;
	}

	/*
	 * shoutMessage
	 * Sends the message to all of the Listeners tracked by Speakerphone
	 * @param talker a Talker whose message will be sent
	 */
	public void shoutMessage(Talker talker) {
		for(Listener listener: mListeners) {
			listener.onMessageReceived(talker.getMessage());
		}
		return;
	}

	/*
	 * shoutMessage
	 * Sends the message to all of the Listeners which are instances of
	 * the class parameter
	 * @param talker a Talker whose message will be sent
	 * @param cls a Class object representing the type which the Listener
	 *			  should extend from in order to receive the message
	 *
	 * HINT: see Class.isAssignableFrom()
	 *		 http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#isAssignableFrom(java.lang.Class)
	 */
	public void shoutMessage(Talker talker, java.lang.Class cls) {
		for(Listener listener: mListeners) {
			if(listener.class.isAssignableFrom(cls)) {
				listener.onMessageReceived(talker.getMessage());
			}
			
		}
		return;
	}

	/*
	 * removeAll
	 * Removes all Listeners from Speakerphone
	 */
	public void removeAll() {
		mListeners = new ArrayList<Listener>(0);
		return;
	}

}