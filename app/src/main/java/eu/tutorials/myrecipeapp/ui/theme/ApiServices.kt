package eu.tutorials.myrecipeapp.ui.theme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
/* Retrofit.Builder() -> creates instance of retrofit.builder()
.baseUrl("")-> sets base url for all network requests
.addConverterFactory(GsonConverterFactory.create())-> converts JSON responses to Java/Kotlin file
.build()-> finalises the build and uses the settings given by the builder
*/
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("categories.php")// coming from meal db API end point /categories.php
    suspend fun getCategory(): CategoriesResponse
}