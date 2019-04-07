package com.training.kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookPack {

    private Set<Book> bookPack = new HashSet<Book>();
    private int bookPackMaxSize;

    public BookPack(int maxSize) {
        this.bookPackMaxSize = maxSize;
    }


    public void addToPack(Book book) {
        bookPack.add(book);
    }

    public BigDecimal price() {

        if (bookPack.size() == 1){
            return BigDecimal.valueOf(8.00);
        } else {
            return BigDecimal.valueOf(8.00)
                    .multiply(BigDecimal.valueOf(bookPack.size()))
                    .multiply(getPromotion(bookPack.size()))
                    .setScale(2, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getPromotion(int size) {
        HashMap<Integer, BigDecimal> promotionMap = new HashMap<Integer, BigDecimal>(){{
            put(2, BigDecimal.valueOf(0.95));
            put(3, BigDecimal.valueOf(0.90));
            put(4, BigDecimal.valueOf(0.80));
            put(5, BigDecimal.valueOf(0.75));
        }};

        if (promotionMap.containsKey(size)) {
            return promotionMap.get(size);
        } else {
            return BigDecimal.valueOf(90000);
        }
    }

    public boolean doesNotContain(Book currentBook) {
        return !bookPack.contains(currentBook);
    }

    public boolean isNotFull() {
        return bookPack.size() < bookPackMaxSize;
    }

    public int size() {
        return this.bookPack.size();
    }
}
