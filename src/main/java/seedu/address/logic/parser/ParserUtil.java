package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.item.ItemName;
import seedu.address.model.item.Price;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;
import seedu.address.model.stall.Location;
import seedu.address.model.stall.Name;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    /**
     * Error message for invalid index format.
     */
    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_STALL_INDEX = "Stall index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_ITEM_INDEX = "Item index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_ITEM_PRICE = "Item price is not a non-zero unsigned double with 2 decimal places.";


    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @param oneBasedIndex The one-based index string.
     * @return The parsed index.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param name The name string.
     * @return The parsed name.
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String location} into a {@code Location}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param location The location string.
     * @return The parsed location.
     * @throws ParseException if the given {@code location} is invalid.
     */
    public static Location parseLocation(String location) throws ParseException {
        requireNonNull(location);
        String trimmedLocation = location.trim();
        if (!Location.isValidLocation(trimmedLocation)) {
            throw new ParseException(Location.MESSAGE_CONSTRAINTS);
        }
        return new Location(trimmedLocation);
    }

    /**
     * Parses a {@code String itemName} into an {@code ItemName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param itemName The item name string.
     * @return The parsed item name.
     * @throws ParseException if the given {@code itemName} is invalid.
     */
    public static ItemName parseItemName(String itemName) throws ParseException {
        requireNonNull(itemName);
        String trimmedItemName = itemName.trim();
        if (!ItemName.isValidItemName(trimmedItemName)) {
            throw new ParseException(ItemName.MESSAGE_CONSTRAINTS);
        }
        return new ItemName(trimmedItemName);
    }

    /**
     * Parses a {@code String stallIndex} into an {@code Index}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param oneBasedIndex The one-based index string.
     * @return The parsed stall index.
     * @throws ParseException if the given {@code stallIndex} is invalid.
     */
    public static Index parseStallIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_STALL_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

  /**
   * Parses a {@code String stallIndex} into an {@code Index}.
   * Leading and trailing whitespaces will be trimmed.
   *
   * @param price The price of the item.
   * @return The parsed price.
   * @throws ParseException if the given {@code price} is invalid.
   */
  public static Price parsePrice(String price) throws ParseException {
    String trimmedPrice = price.trim();
    double value = Double.parseDouble(trimmedPrice);
    if (!StringUtil.isNonZeroUnsignedDouble(trimmedPrice)) {
      throw new ParseException(MESSAGE_INVALID_ITEM_PRICE);
    }
    return new Price(value);
  }

    /**
     * Parses a {@code String itemIndex} into an {@code Index}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @param oneBasedIndex The one-based index string.
     * @return The parsed item index.
     * @throws ParseException if the given {@code itemIndex} is invalid.
     */
    public static Index parseItemIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_ITEM_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String rating} into a {@code Rating}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code rating} is invalid.
     */
    public static Rating parseRating(String rating) throws ParseException {
        requireNonNull(rating);
        String trimmedRating = rating.trim();
        if (!Rating.isValidRating(trimmedRating)) {
            throw new ParseException(Rating.MESSAGE_CONSTRAINTS);
        }
        return new Rating(trimmedRating);
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);

    }
}
