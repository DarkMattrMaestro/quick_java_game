package com.darkmattrmaestro;
public class Player extends Unit {
  int health;
  int recoil;

  Player() {
    this.health = Settings.initial.health;
    this.recoil = 10;
  }
}
