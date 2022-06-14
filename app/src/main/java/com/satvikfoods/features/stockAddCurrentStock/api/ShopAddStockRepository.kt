package com.satvikfoods.features.stockAddCurrentStock.api

import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.location.model.ShopRevisitStatusRequest
import com.satvikfoods.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.satvikfoods.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.satvikfoods.features.stockAddCurrentStock.model.CurrentStockGetData
import com.satvikfoods.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}