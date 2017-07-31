package com.vygulyarniy.wowcraft.warehouse

import org.testng.annotations.Test

class QuantityTest {
    @Test
    fun `quantity can be be positive`() {
        Quantity(13)
    }

    @Test(expectedExceptions = arrayOf(IllegalArgumentException::class))
    fun `quantity cannot be negative`() {
        Quantity(-10)
    }
}