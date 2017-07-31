package com.vygulyarniy.wowcraft.warehouse

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class AmountTest {
    @Test
    fun `amount can be created with integer value`() {
        Amount(13)
    }

    @Test(expectedExceptions = arrayOf(IllegalArgumentException::class))
    fun `amount cannot be negative`() {
        Amount(-10)
    }

    @Test
    fun `amounts can be added`() {
        val sum = Amount(10) + Amount(15)

        assertThat(sum).isEqualTo(Amount(25))
    }

    @Test
    fun `amounts can be subtracted`() {
        assertThat(Amount(10) - Amount(5)).isEqualTo(Amount(5))
    }

    @Test
    fun `amount iz zero when subtraction result is negative`() {
        assertThat(Amount(10) - Amount(20)).isEqualTo(Amount(0))
    }
}