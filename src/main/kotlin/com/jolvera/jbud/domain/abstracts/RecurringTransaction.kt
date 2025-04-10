package com.jolvera.jbud.domain.abstracts

import com.jolvera.jbud.domain.RecurrancePattern
import com.jolvera.jbud.domain.TransactionType
import java.time.Instant
import java.util.*

abstract class RecurringTransaction {
    abstract val id: UUID
    abstract val dateAdded: Instant
    abstract val dateUpdated: Instant
    abstract val description: String
    abstract val amount: Double
    abstract val transactionDate: Instant
    abstract val type: TransactionType
    abstract val pattern: RecurrancePattern
}