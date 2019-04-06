package com.training.kata;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.training.kata.HarryPotterBooks.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PotterBookStoreTest {

    public static final BigDecimal UNITARY_BOOK = BigDecimal.valueOf(8);
    public static final BigDecimal TWO_BOOK_BUNDLE = UNITARY_BOOK
            .multiply(BigDecimal.valueOf(2))
            .multiply(BigDecimal.valueOf(0.95));
    public static final BigDecimal FULL_COLLECTION_BUNDLE = UNITARY_BOOK
            .multiply(BigDecimal.valueOf(5))
            .multiply(BigDecimal.valueOf(0.75));
    public static final BigDecimal THREE_BOOK_BUNDLE = UNITARY_BOOK
            .multiply(BigDecimal.valueOf(3))
            .multiply(BigDecimal.valueOf(0.90));
    public static final BigDecimal FOUR_BOOK_BUNDLE = UNITARY_BOOK
            .multiply(BigDecimal.valueOf(4))
            .multiply(BigDecimal.valueOf(0.80));

    @Test
    public void should_charge_0_for_empty_cart(){
        assertThat(calculateCartTotal(new Book[]{})).isEqualTo(
                BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_unitary_price_for_first_book(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_unitary_price_for_second_book(){
        Book bookArray[] = {THE_CHAMBER_OF_SECRETS};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_unitary_price_for_third_book(){
        Book bookArray[] = {THE_PRISONER_OF_AZKABAN};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_unitary_price_for_fourth_book(){
        Book bookArray[] = {THE_GOBLET_OF_FIRE};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_unitary_price_for_fifth_book(){
        Book bookArray[] = {THE_ORDER_OF_THE_PHOENIX};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_charge_three_times_the_unitary_price_if_we_purchase_the_same_book_three_times(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE, THE_PHILOSOPHER_S_STONE, THE_PHILOSOPHER_S_STONE};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK.multiply(BigDecimal.valueOf(3)))
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_a_5_percent_discount_when_buying_two_different_books(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE, THE_CHAMBER_OF_SECRETS};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(TWO_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_a_10_percent_discount_when_buying_three_different_books(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE, THE_CHAMBER_OF_SECRETS, THE_PRISONER_OF_AZKABAN};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(THREE_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_a_20_percent_discount_when_buying_four_different_books(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE, THE_CHAMBER_OF_SECRETS, THE_PRISONER_OF_AZKABAN, THE_GOBLET_OF_FIRE};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(FOUR_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_a_25_percent_discount_when_buying_all_five_books(){
        Book bookArray[] = {THE_PHILOSOPHER_S_STONE, THE_CHAMBER_OF_SECRETS, THE_PRISONER_OF_AZKABAN, THE_GOBLET_OF_FIRE, THE_ORDER_OF_THE_PHOENIX};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                FULL_COLLECTION_BUNDLE
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_appropriate_discount_when_buying_three_books_with_two_identical_ones(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(TWO_BOOK_BUNDLE)
                        .add(UNITARY_BOOK)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_appropriate_discount_when_buying_two_times_same_two_book_bundle(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(TWO_BOOK_BUNDLE)
                        .add(TWO_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_appropriate_discount_when_buying_four_book_bundle_and_two_book_bundle(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS,
                THE_PRISONER_OF_AZKABAN,
                THE_PRISONER_OF_AZKABAN,
                THE_ORDER_OF_THE_PHOENIX};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(TWO_BOOK_BUNDLE)
                        .add(FOUR_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    private BigDecimal calculateCartTotal(Book[] books) {
        BigDecimal cartTotal = BigDecimal.ZERO;

        if (books.length == 1){
            cartTotal = BigDecimal.valueOf(8.00);
        }

        if (books.length > 1) {
            List<BookPack> bookPacks = new ArrayList<BookPack>();
            for (int i = 0; i < books.length; i++) {
                Book currentBook = books[i];

                if (bookPacks.isEmpty()){
                    BookPack bookPack = new BookPack();
                    bookPack.addToPack(currentBook);
                    bookPacks.add(bookPack);
                } else {
                    boolean hasBeenAdded = false;
                    for (BookPack b : bookPacks){
                        if (b.doesNotContain(currentBook)){
                            b.addToPack(currentBook);
                            hasBeenAdded = true;
                            break;
                        }
                    }
                    if (!hasBeenAdded){
                        BookPack bookPack = new BookPack();
                        bookPack.addToPack(currentBook);
                        bookPacks.add(bookPack);
                    }
                }
            }
            for (int i = 0; i < bookPacks.size(); i++) {
                cartTotal = cartTotal.add(bookPacks.get(i).getPackPrice());
            }
        }

        return cartTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
