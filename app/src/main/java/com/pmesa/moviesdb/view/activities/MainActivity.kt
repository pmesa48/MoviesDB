package com.pmesa.moviesdb.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.view.fragments.TopRatedMoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_activity_fragment_container,
                TopRatedMoviesFragment.newInstance()
            )
            .commitNowAllowingStateLoss()
    }

}
