package com.gildedrose


interface ItemHandlerFactory {
    fun fromItem(name: String): ItemHandler
}

class ItemHandlerFactoryImpl(
        private val itemHandlers: Map<String, ItemHandler>,
        private val defaultItemHandler: ItemHandler
) : ItemHandlerFactory {

    override fun fromItem(name: String) = itemHandlers[name] ?: defaultItemHandler

}