package seedu.address.model.item.review;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;


/**
 * Represents a ItemReview in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class ItemReview {
    private final Rating rating;
    private final Description description;

    /**
     * Constructs a {@code ItemReview}.
     */
    public ItemReview(Rating rating, Description description) {
        requireAllNonNull(rating, description);
        this.rating = rating;
        this.description = description;
    }

    public Rating getRating() {
        return rating;
    }

    public String getRatingString() {
        return rating.starRating;
    }

    public String getDescriptionString() {
        return description.toString();
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(rating, description);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("rating", rating)
                .add("description", description)
                .toString();
    }
}
