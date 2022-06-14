package com.satvikfoods.features.lead.api

import com.satvikfoods.features.NewQuotation.api.GetQuotListRegRepository
import com.satvikfoods.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}