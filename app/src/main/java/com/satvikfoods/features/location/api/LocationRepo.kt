package com.satvikfoods.features.location.api

import com.satvikfoods.app.Pref
import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.location.model.AppInfoInputModel
import com.satvikfoods.features.location.model.AppInfoResponseModel
import com.satvikfoods.features.location.model.ShopDurationRequest
import com.satvikfoods.features.location.shopdurationapi.ShopDurationApi
import io.reactivex.Observable

/**
 * Created by Saikat on 17-Aug-20.
 */
class LocationRepo(val apiService: LocationApi) {
    fun appInfo(appInfo: AppInfoInputModel?): Observable<BaseResponse> {
        return apiService.submitAppInfo(appInfo)
    }

    fun getAppInfo(): Observable<AppInfoResponseModel> {
        return apiService.getAppInfo(Pref.session_token!!, Pref.user_id!!)
    }
}