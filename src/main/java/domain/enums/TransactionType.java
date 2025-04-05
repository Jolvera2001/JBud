package domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TransactionType {
    HOUSING("Housing", TransactionCategory.EXPENSE),
    UTILITIES("Utilities", TransactionCategory.EXPENSE),
    SUBSCRIPTION("Subscription", TransactionCategory.EXPENSE),
    INSURANCE("Insurance", TransactionCategory.EXPENSE),
    GROCERIES("Groceries", TransactionCategory.EXPENSE),
    OTHER_EXPENSE("Other Expense", TransactionCategory.EXPENSE),

    SALARY("Salary", TransactionCategory.INCOME),
    GIFT("Gift", TransactionCategory.INCOME),
    OTHER_INCOME("Other Income", TransactionCategory.INCOME);

    private final String displayName;
    private final TransactionCategory category;

    TransactionType(String displayName, TransactionCategory category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public static List<TransactionType> getExpenseTypes() {
        return Arrays.stream(values())
                .filter(type -> type.category == TransactionCategory.EXPENSE)
                .collect(Collectors.toList());
    }

    public static List<TransactionType> getIncomeTypes() {
        return Arrays.stream(values())
                .filter(type -> type.category == TransactionCategory.INCOME)
                .collect(Collectors.toList());
    }
}
