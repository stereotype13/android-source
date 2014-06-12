package com.bloc.securitypackage.apples;

import com.bloc.securitypackages.colors.*;
import com.bloc.securitypackage.*;
import com.bloc.securitypackages.*;

public abstract class Apple extends Fruit {

  public Apple(String name, int calories, Color color, double weight) {
    super(name, calories, color, weight);
  }

	abstract void bite();

}