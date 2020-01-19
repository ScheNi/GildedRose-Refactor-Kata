package com.gildedrose

class GildedRose(
        val items: Array<Item>
) {
    private val basicItemHandler: ItemHandler = BasicItemHandler()
    private val brieItemHandler: ItemHandler = BrieItemHandler()
    private val backstagePassesItemHandler: ItemHandler = BackstagePassesItemHandler()
    private val sulfurasItemHandler: ItemHandler = SulfurasItemHandler()

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != ITEM_BRIE
                    && item.name != ITEM_BACKSTAGE_PASSES
                    && item.name != ITEM_SULFURAS) {
                basicItemHandler.handleItem(item)
                return
            }

            if (item.name == ITEM_BRIE) {
                brieItemHandler.handleItem(item)
                return
            }

            if (item.name == ITEM_BACKSTAGE_PASSES) {
                backstagePassesItemHandler.handleItem(item)
                return
            }

            if (item.name == ITEM_SULFURAS) {
                sulfurasItemHandler.handleItem(item)
                return
            }
        }
    }

}

