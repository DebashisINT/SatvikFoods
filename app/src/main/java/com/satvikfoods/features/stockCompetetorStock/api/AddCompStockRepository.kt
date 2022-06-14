package com.satvikfoods.features.stockCompetetorStock.api

import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.orderList.model.NewOrderListResponseModel
import com.satvikfoods.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.satvikfoods.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}