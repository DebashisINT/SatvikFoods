package com.satvikfoods.features.viewAllOrder.interf

import com.satvikfoods.app.domain.NewOrderGenderEntity
import com.satvikfoods.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}