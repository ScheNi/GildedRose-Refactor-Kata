package com.gildedrose

import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {


    @Test fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items, itemHandlerFactory)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun `basic item decreases sellIn by one`() {
        val item = Item("basic", 10, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(9, item.sellIn)
    }


    @Test
    fun `basic item decreases quality by one when sellIn is greater than 0`() {
        val item = Item("basic", 1, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(3, item.quality)
    }

    @Test
    fun `basic item decreases quality twice as fast when sellIn is less than 1`() {
        val item = Item("basic", 0, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(2, item.quality)
    }

    @Test
    fun `basic item quality can not go negative`() {
        val item = Item("basic", 0, 0)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(0, item.quality)
    }

    @Test
    fun `brie item decreases sellIn by one`() {
        val item = Item(ITEM_BRIE, 10, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(9, item.sellIn)
    }

    @Test
    fun `brie item increases quality by one when sellIn is greater than 0`() {
        val item = Item(ITEM_BRIE, 1, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(5, item.quality)
    }

    @Test
    fun `brie item increases quality twice as fast when sellIn is less than 1`() {
        val item = Item(ITEM_BRIE, 0, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(6, item.quality)
    }

    @Test
    fun `brie item quality can not go above 50`() {
        val item = Item(ITEM_BRIE, 1, 50)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(50, item.quality)
    }

    @Test
    fun `backstage passes item decreases sellIn by one`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 10, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(9, item.sellIn)
    }

    @Test
    fun `backstage passes item increases quality by one when sellIn is more than or equal to 11`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 11, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(5, item.quality)
    }

    @Test
    fun `backstage passes item increases quality by two when sellIn is more than or equal to 6`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 6, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(6, item.quality)
    }

    @Test
    fun `backstage passes item increases quality by three when sellIn is more than 0`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 1, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(7, item.quality)
    }

    @Test
    fun `backstage passes item quality drops to 0 when sellIn is less than or equal to 0`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 0, 4)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(0, item.quality)
    }

    @Test
    fun `backstage passes item quality can not go above 50`() {
        val item = Item(ITEM_BACKSTAGE_PASSES, 1, 50)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(50, item.quality)
    }

    @Test
    fun `sulfuras item does not decrease sellIn`() {
        val item = Item(ITEM_SULFURAS, 10, 80)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(10, item.sellIn)
    }

    @Test
    fun `sulfuras item does not increase quality`() {
        val item = Item(ITEM_SULFURAS, 10, 80)
        val app = GildedRose(arrayOf(item), itemHandlerFactory)

        app.updateQuality()

        assertEquals(80, item.quality)
    }


}


