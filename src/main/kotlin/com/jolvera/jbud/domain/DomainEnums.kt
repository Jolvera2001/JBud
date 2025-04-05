package com.jolvera.jbud.domain

enum class TransactionCategory {
    EXPENSE,
    INCOME,
}

enum class RecurrancePattern(val description: String) {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    BIWEEKLY("Biweekly"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly");
}

enum class TransactionType(val description: String, val category: TransactionCategory) {
    HOUSING("Housing", TransactionCategory.EXPENSE),
    UTILITIES("Utilities", TransactionCategory.EXPENSE),
    SUBSCRIPTION("Subscription", TransactionCategory.EXPENSE),
    INSURANCE("Insurance", TransactionCategory.EXPENSE),
    GROCERIES("Groceries", TransactionCategory.EXPENSE),
    OTHER_EXPENSE("Other Expense", TransactionCategory.EXPENSE),

    SALARY("Salary", TransactionCategory.INCOME),
    GIFT("Gift", TransactionCategory.INCOME),
    OTHER_INCOME("Other Income", TransactionCategory.INCOME);
}