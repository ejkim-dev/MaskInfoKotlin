package com.example.maskinfokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maskinfokotlin.model.Store

class MainActivity : AppCompatActivity() {

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


        // 테스트 데이터
        val items = listOf(
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" ),
            Store("aaa", "dddd", "fff", 1111.11, 22.00, "rrrrr","ddd","kkkk","lll" )
        )

        storeAdapter.updateItems(items)
    }
}
