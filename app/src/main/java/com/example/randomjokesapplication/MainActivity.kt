package com.example.randomjokesapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.randomjokesapplication.R
import com.example.randomjokesapplication.JokeClientApi.apiService
import com.example.randomjokesapplication.myJokes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var setup: TextView
    private  lateinit var delivery : TextView
    private  lateinit var btnClick : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup = findViewById(R.id.joke)
        delivery = findViewById(R.id.del)
        btnClick = findViewById(R.id.btn)
        getJokes()

        btnClick.setOnClickListener {
          getJokes()

        }
    }

   private  fun getJokes(){
        apiService.getJoke().enqueue(object : retrofit2.Callback<myJokes> {
            override fun onResponse(call: Call<myJokes>, response: Response<myJokes>) {

                if (response.isSuccessful) {

                    val jokeResponse = response.body()
                    if (jokeResponse != null && jokeResponse.type == "twopart") {
                        val setup1 = jokeResponse.setup
                        val delivery1 = jokeResponse.delivery

                        // set the values

                        setup.text = setup1
                        delivery.text = delivery1

                    }
                }

            }

            override fun onFailure(call: Call<myJokes>, t: Throwable) {
                Log.d("Main Activity", "onFailure" + t.message)

            }

        })

    }

}