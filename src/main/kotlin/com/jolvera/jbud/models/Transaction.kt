package com.jolvera.jbud.models

class Transaction {
    private val name: String? = null
    private val amount: Double? = null

    override fun toString(): String {
        return "$name : /$$amount"
    }
}