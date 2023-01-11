package com.example.myproject

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.myproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.bOpenMenu.setOnClickListener {
            binding.Drawer.openDrawer(GravityCompat.START)

        }

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.teorema_pifagora -> openFrag(PifagorFragment.newInstance(), binding.PifagorHolder.id)
            }
            binding.Drawer.closeDrawer(GravityCompat.START)
            true
        }

    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            android.R.id.home -> finish()
//
//        }
//        return true
//    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}