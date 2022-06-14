package com.satvikfoods.features.newcollection.model

import com.satvikfoods.app.domain.CollectionDetailsEntity
import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}