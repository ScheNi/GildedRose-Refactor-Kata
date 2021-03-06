package com.gildedrose

interface ItemHandler {
    fun handleItem(item: Item)
}

class BasicItemHandler : ItemHandler {

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

class ConjuredItemHandler : ItemHandler {

    private val qualityDeductionForPositiveSellIn = 2
    private val qualityDeductionForNegativeSellIn = qualityDeductionForPositiveSellIn * 2

    override fun handleItem(item: Item) {
        item.apply {
            // Decrease sellIn by 1
            decreaseSellIn()

            // Decrease quality by 2 if sellIn >= 0 else by twice as much
            val qualityDeduction = if (sellIn >= 0) {
                qualityDeductionForPositiveSellIn
            } else {
                qualityDeductionForNegativeSellIn
            }
            decreaseQuality(by = qualityDeduction)
        }
    }
}

class BrieItemHandler : ItemHandler {

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

class BackstagePassesItemHandler : ItemHandler {

    private val qualityIncreaseForSellInMoreThan10 = 1
    private val qualityIncreaseForSellInMoreThan5 = 2
    private val qualityIncreaseForSellInMoreThan0 = 3

    override fun handleItem(item: Item) {
        item.apply {
            // Decrease sellIn by 1
            decreaseSellIn()

            // Increase quality by 1 if sellIn >= 10
            // Increase quality by 2 if sellIn >= 5
            // Increase quality by 3 if sellIn >= 0
            // If sellIn passes, reset quality to 0
            val qualityIncrease = when {
                sellIn >= 10 -> qualityIncreaseForSellInMoreThan10
                sellIn >= 5 -> qualityIncreaseForSellInMoreThan5
                sellIn >= 0 -> qualityIncreaseForSellInMoreThan0
                else -> -quality
            }
            increaseQuality(by = qualityIncrease)
        }
    }
}

class SulfurasItemHandler : ItemHandler {

    override fun handleItem(item: Item) {
        // Quality + sellIn should stay the same
        // Nothing has to happen here
    }
}
