package com.jolvera.jbud.examples

class Transaction(val name: String?, val amount: Double?) {
    override fun toString(): String {
        return "$name : $$amount"
    }
}