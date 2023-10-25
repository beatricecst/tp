package seedu.address.model.item;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Price {
  public static final String MESSAGE_CONSTRAINTS =
    "Price should not be blank";

  private double price;

  /**
   * Constructs a {@code Price}.
   *
   * @param price A valid name.
   */
  public Price(double price) {
    requireNonNull(price);
    this.price = price;
  }

  @Override
  public String toString() {
    return String.valueOf(price);
  }

}
