package com.bloc.objects;

class Song extends Object {
	// The ensemble which produced it
	Ensemble mEnsemble;
	// Title of the song
	String mTitle;
	// The year it was released
	int mYearReleased;

	/*
	 * Basic Constructor
	 * Side-effects: Assigns some default ensemble, title and
	 *				 and year of your choosing
	 */
	Song() {
		Artist defaultArtist = new Artist("firstName", "lastName");
		Artist[] defaultArtists = new Artist[1];
		defaultArtists[0] = defaultArtist;
		Ensemble defaultEnsemble = new Ensemble(defaultArtists);
		this.mEnsemble = defaultEnsemble;
		this.mTitle = "Default Title";
		this.mYearReleased = 0;
	}

	/*
	 * Partial Constructor
	 * Side-effects: Sets the year of release to 0
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 */
	Song(Ensemble ensemble, String title) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = 0;
	}

	/*
	 * Full Constructor
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 * @param yearReleased the year the song was released
	 */
	Song(Ensemble ensemble, String title, int yearReleased) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = yearReleased;
	}
}