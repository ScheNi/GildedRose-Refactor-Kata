package com.gildedrose

import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {

    @Test fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun `basic item decreases sellIn by one`() {
        val item = Item("basic", 10, 4)
        val app = GildedRose(arrayOf(item))

        app.updateQuality()

        assertEquals(9, item.sellIn)
    }


    @Test
    fun `basic item decreases quality by one when sellIn is greater than 0`() {
        val item = Item("basic", 1, 4)
        val app = GildedRose(arrayOf(item))

        app.updateQuality()

        assertEquals(3, item.quality)
    }

    @Test
    fun `basic item decreases quality twice as fast when sellIn is less than 1`() {
        val item = Item("basic", 0, 4)
        val app = GildedRose(arrayOf(item))

        app.updateQuality()

        assertEquals(2, item.quality)
    }

    @Test
    fun `basic item quality can not go negative`() {
        val item = Item("basic", 0, 0)
        val app = GildedRose(arrayOf(item))

        app.updateQuality()

        assertEquals(0, item.quality)
    }


}


