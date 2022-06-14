package com.satvikfoods.features.viewAllOrder.interf

import com.satvikfoods.app.domain.NewOrderGenderEntity
import com.satvikfoods.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}