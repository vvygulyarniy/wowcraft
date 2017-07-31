package com.vygulyarniy.wowcraft.warehouse

import java.lang.Integer.max

data class Item(val id: Int, val name: String)

data class Quantity(val count: Int) {
    init {
        if (count < 0)
            throw IllegalArgumentException("quantity should be greater than zero")
    }
}

data class Amount(val value: Int) {
    init {
        if (value < 0)
            throw IllegalArgumentException("amount cannot be negative")
    }

    operator fun plus(another: Amount) = Amount(this.value + another.value)
    operator fun minus(another: Amount) = Amount(max(this.value - another.value, 0))

}