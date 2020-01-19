package com.gildedrose

interface ItemHandler {
    fun handleItem(item: Item)
}

class BasicItemHandler() : ItemHandler {

    private val qualityDeductionForPositiveSellIn = 1
    private val qualityDeductionForNegativeSellIn = qualityDeductionForPositiveSellIn * 2

    override fun handleItem(item: Item) {
        item.apply {
            // Decrease sellIn by 1
            decreaseSellIn()

            // Decrease quality by 1 if sellIn >= 0 else by twice as much
            val qualityDeduction = if (sellIn >= 0) {
                qualityDeductionForPositiveSellIn
            } else {
                qualityDeductionForNegativeSellIn
            }
            decreaseQuality(by = qualityDeduction)
        }
    }
}


class BrieItemHandler() : ItemHandler {
    private val qualityIncreaseForPositiveSellIn = 1
    private val qualityIncreaseForNegativeSellIn = qualityIncreaseForPositiveSellIn * 2
    override fun handleItem(item: Item) {
        item.apply {
            // Decrease sellIn by 1
            decreaseSellIn()

            // Increase quality by 1 if sellIn >= 0 else by twice as much
            val qualityIncrease = if (sellIn >= 0) {
                qualityIncreaseForPositiveSellIn
            } else {
                qualityIncreaseForNegativeSellIn
            }
            increaseQuality(by = qualityIncrease)
        }
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