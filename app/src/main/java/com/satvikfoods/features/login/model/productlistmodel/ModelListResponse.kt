package com.satvikfoods.features.login.model.productlistmodel

import com.satvikfoods.app.domain.ModelEntity
import com.satvikfoods.app.domain.ProductListEntity
import com.satvikfoods.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}