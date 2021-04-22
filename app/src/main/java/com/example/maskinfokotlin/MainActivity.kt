package com.example.maskinfokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maskinfokotlin.model.Store

class MainActivity : AppCompatActivity() {
    // 변하지 않으면서 null이 아니고 초기화 보장해주게 선언하기 ( by lazy 써도 됨 )
    // viewModels() -> fragment-ktx 에서 제공하는 코틀린 확장 함수
    // 코틀린에서는 되도록 모델클래스 이외에서는 var를 안쓰는게 좋음
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val storeAdapter = StoreAdapter()

        // recyclerView 를 this로 만들어 반복을 줄일 수 있음
        recyclerView.apply {

            layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
            adapter = storeAdapter
        }

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                storeAdapter.updateItems(it)
            })

            loadingLiveData.observe(this@MainActivity, Observer { isLoading ->
                if (isLoading){
                    // todo : 프로그래스바 나타남
                } else {
                    // todo : 프로그래스바 사라지게
                }
            })
        }

        // 테스트 데이터
        /*val items = listOf(
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" )
        )*/

//        storeAdapter.updateItems(items)
    }
}
