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

            // Quality cannot be negative
            if (quality == 0) return@apply

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

fun Item.decreaseQuality(by: Int = 1) {
    quality -= by
}

fun Item.decreaseSellIn(by: Int = 1) {
    sellIn -= by
}