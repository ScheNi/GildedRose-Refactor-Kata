package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

fun Item.decreaseQuality(by: Int = 1, minimumQuality: Int = DEFAULT_MINIMUM_ITEM_QUALITY) {
    if (quality == minimumQuality) return
    quality -= by
}

fun Item.increaseQuality(by: Int = 1, maximumQuality: Int = DEFAULT_MAXIMUM_ITEM_QUALITY) {
    if (quality == maximumQuality) return
    quality += by
}

fun Item.decreaseSellIn(by: Int = 1) {
    sellIn -= by
}