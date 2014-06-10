package com.bloc.objects;

class PopSong extends Song {
	// The number of weeks this song stayed on Billboard's top 100
	int mWeeksOnBillboard;

	/*
	 * Basic Constructor
	 * Side-effects: Assigns some default ensemble, title,
	 *				 year and weeks on billboard
	 */
	PopSong() {
		//super(ensemble, title, year);
		//this.mWeeksOnBillboard = weeksOnBillboard;
	}

	/*
	 * Partial Constructor
	 * Side-effects: Sets the year of release to 0
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 */
	PopSong(Ensemble ensemble, String title) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = 0;
	}

	/*
	 * Full Song Constructor
	 * Side-effects: Sets the weeks on billboard to 0
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 * @param yearReleased the year the song was released
	 */
	PopSong(Ensemble ensemble, String title, int yearReleased) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = yearReleased;
		this.mWeeksOnBillboard = 0;
	}

	/*
	 * Full PopSong Constructor
	 * @param ensemble the ensemble responsible
	 * @param title the song title
	 * @param yearReleased the year the song was released
	 * @param weeksOnBillboard number of weeks this song lasted on the
	 *		  				   Billboard's top 100
	 */
	PopSong(Ensemble ensemble, String title, int yearReleased, int weeksOnBillboard) {
		this.mEnsemble = ensemble;
		this.mTitle = title;
		this.mYearReleased = yearReleased;
		this.mWeeksOnBillboard = 0;
		this.mWeeksOnBillboard = weeksOnBillboard;
	}
}