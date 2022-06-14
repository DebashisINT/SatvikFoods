package com.satvikfoods.features.weather.api

import com.satvikfoods.features.task.api.TaskApi
import com.satvikfoods.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}