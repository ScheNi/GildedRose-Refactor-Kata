package com.gildedrose

class GildedRose(
        val items: Array<Item>,
        private val itemHandlerFactory: ItemHandlerFactory
) {

    fun updateQuality() {
        items.forEach { item ->
            val handler = itemHandlerFactory.fromItem(item.name)
            handler.handleItem(item)
        }
    }

}

