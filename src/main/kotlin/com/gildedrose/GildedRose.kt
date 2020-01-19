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


            if (item.name != ITEM_BRIE && item.name != ITEM_BACKSTAGE_PASSES) {
                if (item.quality > 0) {
                    // Item quality is greater than 0
                    // Item is not aged brie & not backstage passes
                    // -> Decrease quality by 1
                    if (item.name != ITEM_SULFURAS) {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                // Item quality is less than 50
                // -> Increase quality by 1
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name == ITEM_BACKSTAGE_PASSES) {
                        if (item.sellIn < 11) {
                            // Item quality is less than 50
                            // Item sellIn is less than 11
                            // Item are Backstage passes
                            // -> Increase quality by 1
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }

                        if (item.sellIn < 6) {
                            // Item quality is less than 50
                            // Item sellIn is less than 6
                            // Item are Backstage passes
                            // -> Increase quality by 1
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                    }
                }
            }


            // Item is not Sulfuras
            // -> decrease sellIn by 1
            if (item.name != ITEM_SULFURAS) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != ITEM_BRIE) {
                    if (item.name != ITEM_BACKSTAGE_PASSES) {
                        if (item.quality > 0) {
                            // Item is over sellIn date,
                            // Item is not aged brie, not backstage pass & not Sulfuras
                            // Item quality is bigger than 0
                            // -> Decrease quality by 1
                            if (item.name != ITEM_SULFURAS) {
                                item.quality = item.quality - 1
                            }
                        }

                        // Item is over sellIn date,
                        // Item is backstage pass
                        // -> Reset quality
                    } else {
                        item.quality = item.quality - item.quality
                    }

                } else {

                    // Item quality is less than 50
                    // Item is aged brie
                    // -> increate quality by 1
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }
    }

}

