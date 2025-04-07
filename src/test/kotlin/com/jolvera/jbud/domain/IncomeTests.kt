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
            startDate = currentDate,
            description = testDescription,
            type = TransactionType.HOUSING,
            pattern = RecurrancePattern.MONTHLY,
            source = testSource,
            notes = testNotes,
            isGuaranteed = true
        )

        income shouldNotBe null
        income.description shouldBe "test description"
        income.startDate shouldBe currentDate
        income.type shouldBe TransactionType.HOUSING
        income.pattern shouldBe RecurrancePattern.MONTHLY
        income.source shouldBe testSource
        income.notes shouldBe testNotes
        income.isGuaranteed shouldBe true
    }
}