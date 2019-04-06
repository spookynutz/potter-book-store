package com.training.kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookPack {

    private Set<Book> bookPack = new HashSet<Book>();


    public void addToPack(Book book) {
        bookPack.add(book);
    }

    public BigDecimal getPackPrice() {

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
        }};
        return promotionMap.get(size);
    }

    public boolean doesNotContain(Book currentBook) {
        return !bookPack.contains(currentBook);
    }
}
