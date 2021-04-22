package com.example.maskinfokotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maskinfokotlin.model.Store
import com.example.maskinfokotlin.repository.MaskService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.stream.Collector

class MainViewModel : ViewModel() {
    private val TAG = "MainViewModel"
    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    // lateinit var : 나중에 초기화 될때 사용해도 되는 변수( 자바에서 MaskService service; 와 같음)
    // init 에서 초기화 하게되면 null이 아닌 값이 되기 때문에 lateinit를 빼도 됨
    private val service: MaskService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(MaskService::class.java)

        fetchStoreInfo()
    }

    fun fetchStoreInfo(){
        // 로딩 시작
        loadingLiveData.value = true
        viewModelScope.launch {
            val storeInfo = service.fetchStoreInfo(37.188078, 127.043002)
            itemLiveData.value = storeInfo.stores

            Log.d(TAG, "fetchStoreInfo: ${itemLiveData.value}")
            
            // 로딩 끝
            loadingLiveData.value = false
        }
    }
}