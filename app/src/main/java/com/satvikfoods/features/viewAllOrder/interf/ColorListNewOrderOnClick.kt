package com.satvikfoods.features.viewAllOrder.interf

import com.satvikfoods.app.domain.NewOrderColorEntity
import com.satvikfoods.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}