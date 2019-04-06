import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PotterBookStoreTest {

    @Test
    public void should_bill_8_euros_for_a_single_book(){
        addBookToCart(HarryPotterBooks.THE_PHILOSOPHER_S_STONE);
        assertThat(calculateCartTotal()).isEqualTo(BigDecimal.valueOf(8.00));
    }

    private void addBookToCart(HarryPotterBooks bookname) {

    }

    private BigDecimal calculateCartTotal() {
        return BigDecimal.valueOf(8.00);
    }
}
