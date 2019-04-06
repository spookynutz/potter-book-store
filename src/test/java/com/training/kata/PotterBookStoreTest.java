package com.training.kata;

import com.training.kata.Book;
import com.training.kata.HarryPotterBooks;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PotterBookStoreTest {

    public static final BigDecimal UNITARY_BOOK_PRICE = BigDecimal.valueOf(8.00);
    private List<Book> bookCart = new ArrayList<Book>();

    @Test
    public void should_bill_8_euros_for_a_single_book(){
        addBookToCart(HarryPotterBooks.THE_PHILOSOPHER_S_STONE);
        assertThat(calculateCartTotal()).isEqualTo(UNITARY_BOOK_PRICE);
    }

    @Test
    public void should_bill_16_euros_if_we_purchase_the_same_book_twice(){
        addBookToCart(HarryPotterBooks.THE_PHILOSOPHER_S_STONE);
        addBookToCart(HarryPotterBooks.THE_PHILOSOPHER_S_STONE);
        assertThat(calculateCartTotal()).isEqualTo(UNITARY_BOOK_PRICE.multiply(BigDecimal.valueOf(2)));
    }

    private void addBookToCart(Book book) {
        bookCart.add(book);
    }

    private BigDecimal calculateCartTotal() {
        return UNITARY_BOOK_PRICE.multiply(BigDecimal.valueOf(bookCart.size()));
    }
}
