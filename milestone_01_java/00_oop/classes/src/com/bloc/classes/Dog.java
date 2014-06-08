package com.bloc.classes;

class Dog {
    // The length of hair which
    final float HAIR_CUT_LENGTH = 0.15f;
    // Minimum weight that any Dog can be
    final float MIN_WEIGHT = 1.25f;
	// Amount of weight to gain after eating
	final float WEIGHT_GAIN = 0.25f;
	// Amount of weight to lose after playing
	final float WEIGHT_LOSS = 0.2f;
	// Hair length
	float mHairLength;
	// Gender, either "male" or "female"
	String mGender;
	// Size, either "tiny", "small", "average", or "large"
	String mSize;
	// Its age
	int mAge;
	// Its weight in pounds
	float mWeight;
	// The color of its coat
	String mColor;

	int mMealCount = 0;
	int mPlayCount = 0;

	/*
	 * getHairLength
	 * @return this Dog's hair length
	 */
	float getHairLength() {
		return mHairLength;
	}

	/*
	 * setHairLength
	 * Sets the length of the Dog's hair
	 * @param hairLength the new length of the hair, a float
	 * @return nothing
	 */
	void setHairLength(float hairLength) {
		mHairLength = hairLength;
	}

	/*
	 * getGender
	 * @return this Dog's gender
	 */
	String getGender() {
		return mGender;
	}

	/*
	 * setGender
	 * Sets this Dog's gender
	 * @param gender the new gender of the Dog, a String
	 * @return nothing
	 */
	void setGender(String gender) {
		mGender = gender;
	}

	/*
	 * getSize
	 * @return the size of the dog
	 */
	String getSize() {
		return mSize;
	}

	/*
	 * setSize
	 * Sets the size of the Dog
	 * @param size the new size of the Dog, a String
	 * @return nothing
	 */
	void setSize(String size) {
		mSize = size;
	}

	/*
	 * getAge
	 * @return this Dog's age
	 */
	int getAge() {
		return mAge;
	}

	/*
	 * setAge
	 * Sets the age of the Dog
	 * @param age the new age of the Dog, an int
	 * @return nothing
	 */
	void setAge(int age) {
		mAge = age;
	}

	/*
	 * getWeight
	 * @return this Dog's weight
	 */
	float getWeight() {
		return mWeight;
	}

	/*
	 * setWeight
	 * Sets the weight of the Dog
	 * @param weight the new weight of the Dog, a float
	 * @return nothing
	 */
	void setWeight(float weight) {
		mWeight = weight;
	}

	/*
	 * getColor
	 * @return this Dog's color
	 */
	String getColor() {
		return mColor;
	}

	/*
	 * setColor
	 * Sets the color of the Dog
	 * @param color the new color of the Dog's coat, a String
	 * @return nothing
	 */
	void setColor(String color) {
		mColor = color;
	}

	/*
	 * feed
	 * Side-effect: 1. The Dog gains weight, specifically WEIGHT_GAIN
	 *              2. Every 3 meals, the Dog grows to a larger size, if *                 possible
	 *              i.e. "tiny" (3 meals later ->) "small" (3 meals later ->)
	 *                   "average" (3 meals later ->) "large"
	 * @return nothing
	 */
	void feed() {
		mMealCount++;
		mWeight += WEIGHT_GAIN;

		if(mMealCount % 3 == 0) {

			switch(mSize) {
				case "tiny":
					mSize = "small";
					break;

				case "small":
					mSize = "average";
					break;

				case "average":
					mSize = "large";
					break;

				case "large":
					mSize = "large";
					break;

				default:
					mSize = "large";

			}

		}

	}

	/*
	 * play
	 * Side-effect: 1. The Dog loses weight, specifically WEIGHT_LOSS
	 *				2. Every 6 play invocations, the Dog shrinks to a smaller *                 size, if possible
	 *				i.e. "large" (6 plays later->) "average" (6 plays later->) *                   "small" -> "tiny"
     *              3. The Dog cannot shrink to a weight smaller than *                 MIN_WEIGHT
	 * @return nothing
	 */
	void play() {

		mPlayCount++;

		mWeight -= WEIGHT_LOSS;

		if(mWeight < MIN_WEIGHT) {
			mWeight = MIN_WEIGHT;
		}

		if(mPlayCount % 6 == 0) {


			switch(mSize) {

				case "large":
				mSize = "average";
				break;

				case "average":
				mSize = "small";
				break;

				case "small":
				mSize = "tiny";
				break;

				default:
				mSize = "tiny";

			}

		}


	}

	/*
	 * cutHair
	 * Side-effect: the Dog's hair length is reduced by HAIR_CUT_LENGTH
     * The Dog's hair cannot be shorter than 0f
	 * @return nothing
	 */
	void cutHair() {
		mHairLength -= HAIR_CUT_LENGTH;

		if(mHairLength < 0f) {
			mHairLength = 0f;
		}
	}

}