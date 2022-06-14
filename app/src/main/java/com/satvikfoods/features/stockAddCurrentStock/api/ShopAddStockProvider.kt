package com.satvikfoods.features.stockAddCurrentStock.api

import com.satvikfoods.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.satvikfoods.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}