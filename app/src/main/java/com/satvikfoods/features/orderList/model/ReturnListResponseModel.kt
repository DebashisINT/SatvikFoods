package com.satvikfoods.features.orderList.model

import com.satvikfoods.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}