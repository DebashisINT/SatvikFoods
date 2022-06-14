package com.satvikfoods.features.location.shopRevisitStatus

import com.satvikfoods.features.location.shopdurationapi.ShopDurationApi
import com.satvikfoods.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}