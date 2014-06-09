package com.bloc.inherit;

class GreatDane extends Dog {
  @Override
  int getSizeIndex(String size) {   

    if(size == "huge") {
      return 4;
    }
    else {
      return super.getSizeIndex(size);
    }
  }

  @Override
  String fromSizeIndex(int index) {

    if(index == 4) {
      return "huge";
    }
    else {
      return super.fromSizeIndex(index);
    }
  }

  @Override
  void changeSize(boolean grow) {
    int sizeIndex = getSizeIndex();
    sizeIndex = sizeIndex + (grow ? 1 : -1);
    if (sizeIndex > 4) {
      sizeIndex = 4;
    } else if (sizeIndex < 0) {
      sizeIndex = 0;
    }
    setSize(fromSizeIndex(sizeIndex));
  }
}