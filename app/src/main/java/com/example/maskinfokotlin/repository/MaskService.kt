package com.example.maskinfokotlin.repository

import com.example.maskinfokotlin.model.StoreInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MaskService {
//    suspend 를 메소드 앞에 붙이게 되면 오랫동안 비동기로 동작할 코드라는 뜻
    // 레트로핏에서 공식적으로 코틀린에만 지원하는 기능 -> Call 객체가 아닌 직접 StoreInfo 를 반환할 수 있음
    @GET("sample.json")
    suspend fun fetchStoreInfo(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
    ): StoreInfo // 이 타입으로 데이터를 받을 예정


    // kotlin 에서는 상수를 companion 이라는 동반 객체를 사용함
   companion object {
        const val BASE_URL =
            "https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94/"
    }
}
