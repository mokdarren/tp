package seedu.address.model.person;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Client's insurance plan.
 */
public class Policy {
    public static final String NUMBER_MESSAGE_CONSTRAINTS =
            "Policy number should only contain numbers, and it should be at least 1 digit long";
    public static final String INSURER_NAME_MESSAGE_CONSTRAINTS =
            "Policy plans should should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String POLICY_NAME_MESSAGE_CONSTRAINTS =
            "Policy plans should should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String COMMISSION_MESSAGE_CONSTRAINTS =
            "Commission should be a floating point number";

    public static final String COMMISSION_VALIDATION_REGEX = "[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String name;
    public final String insurer;
    public final int number;
    public final Double commission;

    /**
     * Constructs a {@code Policy}.
     *
     * @param insurer A valid insurer
     * @param number A valid number.
     * @param name A valid policy name.
     * @param commission A valid commission.
     */
    public Policy(String insurer, String number, String name, String commission) {
        requireAllNonNull(insurer, number, name, commission);
        checkArgument(isValidPolicyNumber(number), NUMBER_MESSAGE_CONSTRAINTS);
        checkArgument(isValidName(name), POLICY_NAME_MESSAGE_CONSTRAINTS);
        checkArgument(isValidName(insurer), INSURER_NAME_MESSAGE_CONSTRAINTS);
        checkArgument(isValidPolicyCommission(commission), COMMISSION_MESSAGE_CONSTRAINTS);
        this.name = name;
        this.insurer = insurer;
        this.commission = Double.valueOf(commission);
        this.number = Integer.valueOf(number);
    }

    /**
     * Returns true if a given string is a valid policy number.
     */
    public static boolean isValidPolicyNumber(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid insurance plan commission.
     */
    public static boolean isValidPolicyCommission(String test) {
        return test.matches(COMMISSION_VALIDATION_REGEX);
    }

    public String getName() {
        return name;
    }

    public String getInsurer() {
        return insurer;
    }

    public int getNumber() {
        return number;
    }

    public Double getCommission() {
        return commission;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Insurer: ")
                .append(getInsurer())
                .append("; Policy ID: ")
                .append(getNumber())
                .append("; Policy Name: ")
                .append(getName())
                .append("; Commission: ")
                .append(getCommission());
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Policy // instanceof handles nulls
                && insurer.equals(((Policy) other).insurer))
                && number == (((Policy) other).number); // state check
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}