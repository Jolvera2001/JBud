package com.jolvera.jbud.domain

import org.junit.jupiter.api.Test
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.Instant

class ExpenseTests {
    @Test
    fun expenseInitBasic() {
        val currentDate = Instant.now()
        val testDescription = "Test description"
        val testPayee = "Test payee"
        val testPaymentMethod = "Card"
        val testNotes = "Test notes"

        val expense = RecurringExpense(
            amount = 20.00,
            startDate = currentDate,
            description = testDescription,
            type = TransactionType.HOUSING,
            pattern = RecurrancePattern.MONTHLY,
            payee = testPayee,
            paymentMethod = testPaymentMethod,
            notes = testNotes,
            autoRenewable = true,
        )

        expense shouldNotBe null
        expense.description shouldBe "test description"
        expense.startDate shouldBe currentDate
        expense.type shouldBe TransactionType.HOUSING
        expense.pattern shouldBe RecurrancePattern.MONTHLY
        expense.payee shouldBe testPayee
        expense.paymentMethod shouldBe testPaymentMethod
        expense.notes shouldBe testNotes
        expense.autoRenewable shouldBe true
    }

    @Test
    fun expenseUUIDNotNull() {
        val expense = RecurringExpense(
            amount = 20.00,
            startDate = Instant.now(),
            description = "test description",
            type = TransactionType.HOUSING,
            pattern = RecurrancePattern.MONTHLY,
            payee = "test",
            paymentMethod = "test",
            notes = "test",
            autoRenewable = true,
        )

        expense.id shouldNotBe null
    }
}