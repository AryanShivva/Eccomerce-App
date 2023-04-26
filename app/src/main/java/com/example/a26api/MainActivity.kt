package com.example.a26api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView     //declare
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        recyclerView=findViewById(R.id.recyclerView)            //initialise

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if api call is sucess,then use the data of api and show in your app

                val responeBody = response.body()
                val productList = responeBody?.products!!   //!! tells if
                //create textview,recycler view and etc

                myAdapter = MyAdapter(this@MainActivity,productList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                //part 2
                myAdapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
                    override fun onItemClicking(position:Int){
                        val intent = Intent(this@MainActivity,productDetails::class.java)

                        startActivity(intent)



                    }
                })

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if api fails
                Log.d("MainActivity","onFailure:" + t.message)
            }
        })

    }
}