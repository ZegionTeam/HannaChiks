package com.example.hannachiks

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.hannachiks.categories.CategoriesActivity
import com.example.hannachiks.categories.FishCategoriesActivity
import com.example.hannachiks.databinding.ActivityBerandaBinding

class BerandaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBerandaBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuChicken.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }
        binding.menuFish.setOnClickListener {
            val intent = Intent(this, FishCategoriesActivity::class.java)
            startActivity(intent)
        }

        drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            handleNavigation(menuItem)
            true
        }

        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }
    }
    // Handle drawer toggle clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    // Handle navigation item clicks
    private fun handleNavigation(menuItem: MenuItem) {
        when (menuItem.itemId) {
            // Add cases here based on menu IDs
            // e.g., R.id.nav_home -> // navigate to home
        }
        binding.drawerLayout.closeDrawers() // Close drawer after selecting an item
    }
}