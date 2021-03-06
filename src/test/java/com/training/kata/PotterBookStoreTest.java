package com.training.kata;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Test
    public void should_apply_appropriate_discount_when_buying_full_bundle_with_one_more_tome(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_PRISONER_OF_AZKABAN,
                THE_ORDER_OF_THE_PHOENIX,
                THE_GOBLET_OF_FIRE};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(UNITARY_BOOK)
                        .add(FULL_COLLECTION_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_appropriate_discount_on_edge_case(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_PRISONER_OF_AZKABAN,
                THE_PRISONER_OF_AZKABAN,
                THE_GOBLET_OF_FIRE,
                THE_ORDER_OF_THE_PHOENIX};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(FOUR_BOOK_BUNDLE)
                        .add(FOUR_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void should_apply_appropriate_discount_on_second_edge_case(){
        Book bookArray[] = {
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_PHILOSOPHER_S_STONE,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_CHAMBER_OF_SECRETS,
                THE_PRISONER_OF_AZKABAN,
                THE_PRISONER_OF_AZKABAN,
                THE_PRISONER_OF_AZKABAN,
                THE_PRISONER_OF_AZKABAN,
                THE_GOBLET_OF_FIRE,
                THE_GOBLET_OF_FIRE,
                THE_GOBLET_OF_FIRE,
                THE_GOBLET_OF_FIRE,
                THE_GOBLET_OF_FIRE,
                THE_ORDER_OF_THE_PHOENIX,
                THE_ORDER_OF_THE_PHOENIX,
                THE_ORDER_OF_THE_PHOENIX,
                THE_ORDER_OF_THE_PHOENIX};
        assertThat(calculateCartTotal(bookArray)).isEqualTo(
                BigDecimal.ZERO
                        .add(FULL_COLLECTION_BUNDLE)
                        .add(FULL_COLLECTION_BUNDLE)
                        .add(FULL_COLLECTION_BUNDLE)
                        .add(FOUR_BOOK_BUNDLE)
                        .add(FOUR_BOOK_BUNDLE)
                        .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    private BigDecimal calculateCartTotal(Book[] books) {
        BigDecimal cartTotal = BigDecimal.ZERO;

        if (books.length == 1){
            cartTotal = UNITARY_BOOK;
        }

        if (books.length > 1) {

            cartTotal = getBookPackPrice(getBookPacks(books));
        }

        return cartTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal getBookPackPrice(List<BookPack> bookPacks) {
        BigDecimal bookPacksPrice = BigDecimal.ZERO;

        for (int i = 0; i < bookPacks.size(); i++) {
            bookPacksPrice = bookPacksPrice.add(bookPacks.get(i).price());
        }

        bookPacksPrice = handleEdgeCase(bookPacks, bookPacksPrice);

        return bookPacksPrice;
    }

    private BigDecimal handleEdgeCase(List<BookPack> bookPacks, BigDecimal bookPacksPrice) {
        int numberOfBundlesOfThree = 0;
        int numberOfFullBundles = 0;
        for (int i = 0; i < bookPacks.size(); i++) {
            if (bookPacks.get(i).size() == 3){
                numberOfBundlesOfThree++;
            } else if (bookPacks.get(i).size() == 5){
                numberOfFullBundles++;
            }
        }
        int numbersToSwitch = Math.min(numberOfBundlesOfThree, numberOfFullBundles);
        bookPacksPrice = bookPacksPrice
                .subtract(
                        UNITARY_BOOK
                                .multiply(BigDecimal.valueOf(5))
                                .multiply(BigDecimal.valueOf(0.75))
                                .multiply(BigDecimal.valueOf(numbersToSwitch)))
                .subtract(
                        UNITARY_BOOK
                                .multiply(BigDecimal.valueOf(3))
                                .multiply(BigDecimal.valueOf(0.90))
                                .multiply(BigDecimal.valueOf(numbersToSwitch))
                )
                .add(
                        UNITARY_BOOK
                                .multiply(BigDecimal.valueOf(4))
                                .multiply(BigDecimal.valueOf(0.80))
                                .multiply(BigDecimal.valueOf(numbersToSwitch * 2))
                )
                .setScale(2, RoundingMode.HALF_UP);
        return bookPacksPrice;
    }

    private List<BookPack> getBookPacks(Book[] books) {
        List<BookPack> bookPacks = new ArrayList<BookPack>();
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];

            if (bookPacks.isEmpty()){
                BookPack bookPack = new BookPack();
                bookPack.addToPack(currentBook);
                bookPacks.add(bookPack);
            } else {
                boolean hasBeenAdded = false;
                for (int j = 0; j < bookPacks.size(); j++) {
                    BookPack bookPack = bookPacks.get(j);
                    if (!hasBeenAdded && bookPack.doesNotContain(currentBook)) {
                        bookPack.addToPack(currentBook);
                        hasBeenAdded = true;
                    }
                }
                if (!hasBeenAdded){
                    BookPack bookPack = new BookPack();
                    bookPack.addToPack(currentBook);
                    bookPacks.add(bookPack);
                }
            }
        }
        return bookPacks;
    }
}
