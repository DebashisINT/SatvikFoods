package com.satvikfoods.features.location.shopRevisitStatus

import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.location.model.ShopDurationRequest
import com.satvikfoods.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}