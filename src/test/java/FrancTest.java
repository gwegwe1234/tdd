import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;
import org.junit.jupiter.api.Test;

public class FrancTest {

  @Test
  public void testFrancMultiplication() {
    Franc five = new Franc(5);
    assertEquals(new Franc(10), five.times(2));
    assertEquals(new Franc(15), five.times(3));
  }
}

class Franc {

  private int amount;

  public Franc(int amount) {
    this.amount = amount;
  }

  Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    Franc franc = (Franc) o;
    return franc.amount == this.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
