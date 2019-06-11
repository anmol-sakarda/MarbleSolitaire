package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Main class to test the method.
 */
public class Main {

  public static void main(String[] args) {
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
            System.out).playGame(new MarbleSolitaireModelImpl());
  }
}
