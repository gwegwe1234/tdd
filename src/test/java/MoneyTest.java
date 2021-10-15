import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  @Test
  public void testFrancMultiplication() {
    Money five = Money.franc(5);
    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertTrue(Money.franc(5).equals(Money.franc(5)));
    assertFalse(Money.franc(5).equals(Money.franc(6)));

    assertFalse(Money.dollar(6).equals(Money.franc(5)));
  }
}

class Dollar extends Money {

  public Dollar(int amount) {
    this.amount = amount;
  }

  Money times(int multiplier) {
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

  Money times(int multiplier) {
    return new Franc(amount * multiplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}

abstract class Money {

  abstract Money times(int multiplier);

  protected int amount;

  static Money dollar(int amount) {
    return new Dollar(amount);
  }

  static Money franc(int amount) {
    return new Franc(amount);
  }

  @Override
  public boolean equals(Object o) {
    Money money = (Money) o;
    return money.amount == this.amount
        && getClass().equals(money.getClass());
  }
}