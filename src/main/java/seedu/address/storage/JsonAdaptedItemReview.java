package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.item.review.ItemReview;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;

/**
 * Jackson-friendly version of {@link ItemReview}.
 */
public class JsonAdaptedItemReview {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Item Review's %s field is missing!";
    private String description;
    private String rating;

    /**
     * Constructs a {@code JsonAdaptedItemReview} with the given Item review details.
     */
    @JsonCreator
    public JsonAdaptedItemReview(@JsonProperty("description") String description,
                                  @JsonProperty("rating") String rating) {
        this.description = description;
        this.rating = rating;
    }

    /**
     * Converts a given {@code ItemReview} into this class for Jackson use.
     */
    public JsonAdaptedItemReview(ItemReview source) {
        if (source == null) {
            return;
        }
        description = source.getDescription().description;
        rating = source.getRating().rating;
    }

    /**
     * Converts this Jackson-friendly adapted Item review object into the model's {@code ItemReview} object.
     */
    public ItemReview toModelType() throws IllegalArgumentException {
        if (description != null && rating == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Description.class.getSimpleName()));
        } else if (description == null && rating != null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Rating.class.getSimpleName()));
        } else if (description == null) {
            return null;
        }

        final Description modelDescription = new Description(description);
        final Rating modelRating = new Rating(rating);
        return new ItemReview(modelRating, modelDescription);
    }

}
