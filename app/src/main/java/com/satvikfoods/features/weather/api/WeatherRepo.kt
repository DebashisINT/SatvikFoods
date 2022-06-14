package com.satvikfoods.features.weather.api

import com.satvikfoods.base.BaseResponse
import com.satvikfoods.features.task.api.TaskApi
import com.satvikfoods.features.task.model.AddTaskInputModel
import com.satvikfoods.features.weather.model.ForeCastAPIResponse
import com.satvikfoods.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}