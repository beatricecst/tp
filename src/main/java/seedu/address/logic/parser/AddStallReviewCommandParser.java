package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STALL;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddStallReviewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.review.Description;
import seedu.address.model.review.Rating;
import seedu.address.model.stall.review.StallReview;

/**
 * Parses input arguments and creates a new AddStallReviewCommand object
 */
public class AddStallReviewCommandParser implements Parser<AddStallReviewCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddStallReviewCommand
     * and returns an AddStallReviewCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddStallReviewCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STALL, PREFIX_RATING, PREFIX_DESCRIPTION);

        if (!arePrefixesPresent(argMultimap, PREFIX_STALL, PREFIX_RATING, PREFIX_DESCRIPTION)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddStallReviewCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STALL, PREFIX_RATING, PREFIX_DESCRIPTION);
        Index stallIndex = ParserUtil.parseStallIndex(argMultimap.getValue(PREFIX_STALL).get());
        Rating rating = ParserUtil.parseRating(argMultimap.getValue(PREFIX_RATING).get());
        Description description = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());

        StallReview stallReview = new StallReview(rating, description);

        return new AddStallReviewCommand(stallReview, stallIndex);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
