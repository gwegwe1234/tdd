import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(10), five.times(2));
    assertEquals(new Dollar(15), five.times(3));
  }

  @Test
  public void testFrancMultiplication() {
    Franc five = new Franc(5);
    assertEquals(new Franc(10), five.times(2));
    assertEquals(new Franc(15), five.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
    assertTrue(new Franc(5).equals(new Franc(5)));
    assertFalse(new Franc(5).equals(new Franc(6)));

    assertFalse(new Dollar(5).equals(new Franc(5)));
  }
}

class Dollar extends Money {

  public Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}

class Franc extends Money {

  public Franc(int amount) {
    this.amount = amount;
  }

  Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}

class Money {

  protected int amount;

  @Override
  public boolean equals(Object o) {
    Money money = (Money) o;
    return money.amount == this.amount
        && getClass().equals(money.getClass());
  }
}