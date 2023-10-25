package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;
import seedu.address.model.stall.review.StallReview;

/**
 * Jackson-friendly version of {@link StallReview}.
 */
public class JsonAdaptedStallReview {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Stall Review's %s field is missing!";
    private String description;
    private String rating;

    /**
     * Constructs a {@code JsonAdaptedStallReview} with the given stall review details.
     */
    @JsonCreator
    public JsonAdaptedStallReview(@JsonProperty("description") String description,
                                  @JsonProperty("rating") String rating) {
        this.description = description;
        this.rating = rating;
    }

    /**
     * Converts a given {@code StallReview} into this class for Jackson use.
     */
    public JsonAdaptedStallReview(StallReview source) {
        if (source == null) {
            return;
        }
        description = source.getDescription().description;
        rating = source.getRating().rating;
    }

    /**
     * Converts this Jackson-friendly adapted stall review object into the model's {@code StallReview} object.
     */
    public StallReview toModelType() throws IllegalArgumentException {
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
        return new StallReview(modelRating, modelDescription);
    }

}
