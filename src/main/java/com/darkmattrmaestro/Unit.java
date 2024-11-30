package com.darkmattrmaestro;
public class Unit {
  int health;
  int recoil;

  void recoil() {
    health -= recoil;
  }
}
