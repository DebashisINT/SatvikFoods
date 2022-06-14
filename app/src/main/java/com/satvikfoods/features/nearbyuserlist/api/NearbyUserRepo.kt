package com.satvikfoods.features.nearbyuserlist.api

import com.satvikfoods.app.Pref
import com.satvikfoods.features.nearbyuserlist.model.NearbyUserResponseModel
import com.satvikfoods.features.newcollection.model.NewCollectionListResponseModel
import com.satvikfoods.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}