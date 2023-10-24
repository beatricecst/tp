package seedu.address.model.stall.review;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;

/**
 * Represents a review of a stall in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class StallReview {
    public static final String MESSAGE_CONSTRAINTS =
            "Review should only contain alphanumeric characters, punctuations and spaces, and it should not be BLANK!";
    private final Rating rating;
    private final Description description;

    /**
     * Constructs a StallReview object.
     *
     * @param description A valid review.
     * @param rating   A rating representing the star rating.
     */
    public StallReview(Description description, Rating rating) {
        this.rating = rating;
        this.description = description;
    }

  /**
   * Constructs a StallReview object that does not contain ratings and descriptions.
   *
   */
  public StallReview() {
    this.rating = null;
    this.description = null;
  }

    public Rating getRating() {
        return rating;
    }

    public Description getDescription() {
        return description;
    }

    public String stallReviewString() {
      if (this.rating == null && this.description == null) {
        String str = "This stall has no reviews yet";
        return str;
      }
      if (this.rating == null) {
        String str = this.getDescription().toString();
        return str;
      }
      if (this.description == null) {
        String str = this.getRating().toString();
        return str;
      }
      String str = this.getRating().toString() + this.getDescription().toString();
      return str;
    }

    /**
     * Returns the string representation of the StallReview.
     *
     * @return The formatted string representation of the StallReview.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("rating", rating)
                .add("description", description)
                .toString();
    }

    /**
     * Generates a hash code for the StallReview object.
     *
     * @return The hash code of the StallReview object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rating, description);
    }
}
