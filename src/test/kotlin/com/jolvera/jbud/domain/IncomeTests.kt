package com.jolvera.jbud.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.time.Instant

class IncomeTests {
    @Test
    fun incomeInitBasic() {
        val currentDate = Instant.now()
        val testDescription = "Test description"
        val testSource = "Test source"
        val testNotes = "Test notes"

        val income = RecurringIncome(
            amount = 20.00,
            transactionDate = currentDate,
            dateAdded = currentDate,
            dateUpdated = currentDate,
            description = testDescription,
            type = TransactionType.HOUSING,
            pattern = RecurrancePattern.MONTHLY,
            source = testSource,
            notes = testNotes,
            isGuaranteed = true
        )

        income shouldNotBe null
        income.description shouldBe testDescription
        income.transactionDate shouldBe currentDate
        income.dateAdded shouldBe currentDate
        income.dateUpdated shouldBe currentDate
        income.type shouldBe TransactionType.HOUSING
        income.pattern shouldBe RecurrancePattern.MONTHLY
        income.source shouldBe testSource
        income.notes shouldBe testNotes
        income.isGuaranteed shouldBe true
    }

    @Test
    fun incomeUUIDNotNull() {
        val income = RecurringIncome(
            amount = 20.00,
            transactionDate = Instant.now(),
            dateAdded = Instant.now(),
            dateUpdated = Instant.now(),
            description = "test Description",
            type = TransactionType.HOUSING,
            pattern = RecurrancePattern.MONTHLY,
            source = "test Source",
            notes = "test Notes",
            isGuaranteed = true
        )

        income.id shouldNotBe null
    }
}