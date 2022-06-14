package com.satvikfoods.features.newcollectionreport

import com.satvikfoods.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}