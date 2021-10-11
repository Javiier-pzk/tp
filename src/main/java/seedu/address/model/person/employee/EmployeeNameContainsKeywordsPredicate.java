package seedu.address.model.person.employee;

import seedu.address.commons.util.StringUtil;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Employee}'s {@code Name} matches any of the keywords given.
 */
public class EmployeeNameContainsKeywordsPredicate implements Predicate<Employee> {
    private final List<String> keywords;

    public EmployeeNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Employee employee) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(employee.getName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EmployeeNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((EmployeeNameContainsKeywordsPredicate) other).keywords)); // state check
    }
}
