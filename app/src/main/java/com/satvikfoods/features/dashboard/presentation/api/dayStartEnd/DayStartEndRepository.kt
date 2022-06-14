package com.satvikfoods.features.dashboard.presentation.api.dayStartEnd

import com.satvikfoods.app.Pref
import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.dashboard.presentation.model.DaystartDayendRequest
import com.satvikfoods.features.dashboard.presentation.model.StatusDayStartEnd
import com.satvikfoods.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.satvikfoods.features.stockCompetetorStock.api.AddCompStockApi
import io.reactivex.Observable

class DayStartEndRepository (val apiService: DayStartEndApi){
    fun dayStart(daystartDayendRequest: DaystartDayendRequest): Observable<BaseResponse> {
        return apiService.submitDayStartEnd(daystartDayendRequest)
    }

    fun dayStartEndStatus(date:String): Observable<StatusDayStartEnd> {
        return apiService.statusDayStartEnd(Pref.session_token!!, Pref.user_id!!,date)
    }


}