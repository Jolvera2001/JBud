package com.jolvera.jbud.models

class Transaction(val name: String?, val amount: Double?) {
    override fun toString(): String {
        return "$name : $$amount"
    }
}