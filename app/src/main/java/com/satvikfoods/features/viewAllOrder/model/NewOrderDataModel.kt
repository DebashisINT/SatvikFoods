package com.satvikfoods.features.viewAllOrder.model

import com.satvikfoods.app.domain.NewOrderColorEntity
import com.satvikfoods.app.domain.NewOrderGenderEntity
import com.satvikfoods.app.domain.NewOrderProductEntity
import com.satvikfoods.app.domain.NewOrderSizeEntity
import com.satvikfoods.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

