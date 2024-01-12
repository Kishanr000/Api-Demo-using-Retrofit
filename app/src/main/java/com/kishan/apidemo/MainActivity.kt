package com.kishan.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kishan.apidemo.apimodel.ApiData
import com.kishan.apidemo.apimodel.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//    Api call through retrofit

        val retrofitBuilder =Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        val retrofitData = retrofitBuilder.getquotesdata()

//        create object using ctrl+shift+space

        retrofitData.enqueue(object : Callback<ApiData?> {
            override fun onResponse(call: Call<ApiData?>, response: Response<ApiData?>) {
                var responseBody = response.body()
                var quoteList = responseBody?.quotes!!

                myAdapter = MyAdapter(this@MainActivity, quoteList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<ApiData?>, t: Throwable) {
                Log.d("MainActivity", "failure" + t.message)
            }
        })


    }
}