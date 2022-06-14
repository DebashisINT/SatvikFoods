package com.satvikfoods.features.viewAllOrder.interf

import com.satvikfoods.app.domain.NewOrderGenderEntity
import com.satvikfoods.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}