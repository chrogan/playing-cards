package com.tlglearning.cards.model;

import java.io.ObjectStreamConstants;
import java.util.Comparator;
import java.util.Objects;

public final class Card implements Comparable<Card> {


  private final Rank rank;
  private final Suit suit;
  private final String representation;
  private final int hash;


  //Constructor(s)
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    representation = rank.getSymbol() + suit.getSymbol();
    hash = Objects.hash(rank,suit);

  }


  //Getters and Setters
  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }


//Overrides
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if(this==obj){
      result =true;
    }else if(obj instanceof Card){
      Card other = (Card) obj;
      result = (rank == other.rank && suit == other.suit);
    }else{
      result = false;
    }

    return result;
  }

  @Override
  public String toString() {
    return representation;
  }

  @Override
  public int compareTo(Card other) {
    return Comparator
        .comparing(Card::getSuit)
        .thenComparing(Card::getRank)
        .compare(this, other);
  }
}
