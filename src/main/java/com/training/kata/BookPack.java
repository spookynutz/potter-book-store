package com.training.kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class BookPack {

    private Set<Book> bookPack = new HashSet<Book>();


    public void addToPack(Book book) {
        bookPack.add(book);
    }

    public BigDecimal getPackPrice() {
        return BigDecimal.valueOf(8.00)
                .multiply(BigDecimal.valueOf(bookPack.size()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean doesNotContain(Book currentBook) {
        return !bookPack.contains(currentBook);
    }
}
