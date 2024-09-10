package com.dkin.chevit.app

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.dkin.chevit.app.databinding.ActivityMainBinding
import com.dkin.chevit.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val topLevelPage = setOf(
        com.dkin.chevit.presentation.splash.R.id.splash,
        com.dkin.chevit.presentation.auth.R.id.auth,
        com.dkin.chevit.presentation.home.R.id.home,
    )
    private val appBarConfiguration by lazy {
        AppBarConfiguration(topLevelPage)
    }
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    }
    private val navController by lazy {
        navHostFragment.navController
    }

    private val requestPermissionLauncher by lazy {
        registerForActivityResult(RequestPermission()) { isGranted: Boolean ->
            Timber.d("Permission granted: $isGranted")
        }
    }

    override fun initView() {
        NavigationUI.setupActionBarWithNavController(
            this@MainActivity,
            navController,
            appBarConfiguration,
        )
        navController.addOnDestinationChangedListener { _, _, _ ->
            hideSoftKeyboard()
        }
        supportActionBar?.hide()

        // TODO 임시로 이렇게 처리 추후 개선 필요
        askNotificationPermission()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    override fun onBackPressed() {
        when {
            // 최상단 페이지인 경우 앱 종료
            topLevelPage.contains(navController.currentDestination?.id) -> finish()
            else -> super.onBackPressed()
        }
    }

    private fun hideSoftKeyboard() = currentFocus?.let { focus ->
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        inputMethodManager?.hideSoftInputFromWindow(focus.windowToken, 0)
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PERMISSION_GRANTED) {
                // 이미 알림 권한 허용
                return
            } else if (shouldShowRequestPermissionRationale(POST_NOTIFICATIONS)) {
                AlertDialog.Builder(this)
                    .setTitle("기기 알림이 꺼져있어요")
                    .setMessage("알림을 허용하여 준비물을 빼먹지 않도록 해요!")
                    .setPositiveButton("확인") { _, _ ->
                        navigateNotificationSetting()
                    }
                    .setNegativeButton("취소") { _, _ -> }
                    .show()
            } else {
                requestPermissionLauncher.launch(POST_NOTIFICATIONS)
            }
        }
    }

    private fun navigateNotificationSetting() {
        val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
            putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        }
        kotlin.runCatching {
            startActivity(intent)
        }.onFailure { throwable ->
            Timber.e(throwable)
        }
    }
}
