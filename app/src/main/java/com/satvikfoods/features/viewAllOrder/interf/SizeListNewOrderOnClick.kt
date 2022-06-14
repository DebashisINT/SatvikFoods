package com.satvikfoods.features.viewAllOrder.interf

import com.satvikfoods.app.domain.NewOrderProductEntity
import com.satvikfoods.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}