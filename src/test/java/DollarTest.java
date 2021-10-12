import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;

public class DollarTest {

  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
//    five.times(2);
//    assertEquals(10, five.amount);
//    five.times(3);
//    assertEquals(15, five.amount);
    Dollar product = five.times(2);
    assertEquals(10, product.amount);
    product = five.times(3);
    assertEquals(15, product.amount);
  }

  @Test
  public void testEquality() {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
  }
}

class Dollar {

  int amount;

  public Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    Dollar dollar = (Dollar) o;
    return dollar.amount == this.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
