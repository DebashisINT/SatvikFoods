package com.satvikfoods.features.dashboard.presentation.api.dayStartEnd

import com.satvikfoods.features.stockCompetetorStock.api.AddCompStockApi
import com.satvikfoods.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}