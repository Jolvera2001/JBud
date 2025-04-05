package com.jolvera.jbud.domain.abstracts

import com.jolvera.jbud.domain.RecurrancePattern
import domain.enums.TransactionType
import java.time.Instant
import java.util.*

class RecurringExpense(
    override val id: UUID = UUID.randomUUID(),
    override val description: String,
    override val amount: Double,
    override val startDate: Instant,
    override val type: TransactionType,
    override val pattern: RecurrancePattern
) : RecurringTransaction() {
    private val payee: String? = null
    private val paymentMethod: String? = null
    private val notes: String? = null
    private val autoRenewable: Boolean? = null
}