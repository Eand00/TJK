package com.tjk.exceptions;

public class DeckNotFoundException extends RuntimeException {
    public DeckNotFoundException(String message) {
        super(message);
    }
}
