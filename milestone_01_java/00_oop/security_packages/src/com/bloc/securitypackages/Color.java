package com.bloc.securitypackages;

public class Color extends Object {
	// Name of the color
	public String mName;
	// Alpha value
	public int mAlpha;
	// Red value
	public int mRed;
	// Green value
	public int mGreen;
	// Blue value
	public int mBlue;

	public Color(int red, int green, int blue) {
		this(null, red, green, blue);
	}

	public Color(String name, int red, int green, int blue) {
		mName = name;
		mRed = red;
		mGreen = green;
		mBlue = blue;
	}
}