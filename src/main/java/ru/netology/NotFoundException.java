package ru.netology;

import java.util.Objects;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }

}
