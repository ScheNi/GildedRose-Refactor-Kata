package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    // Item quality is greater than 0
                    // Item is not aged brie & not backstage passes
                    // -> Decrease quality by 1
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                // Item quality is less than 50
                // -> Increase quality by 1
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
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
            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            // Item is over sellIn date,
                            // Item is not aged brie, not backstage pass & not Sulfuras
                            // Item quality is bigger than 0
                            // -> Decrease quality by 1
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
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

