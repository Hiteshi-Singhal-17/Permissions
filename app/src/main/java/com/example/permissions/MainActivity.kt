package com.example.permissions

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.requestPermissions).setOnClickListener {
            requestPermissions()
        }
    }

    /*
    checkSelfPermission -> Determine whether you have been granted a particular permission.
    Returns Int; Permission_Granted i.e 0 or Permission_Denied i.e -1
    */

    //Checking whether external storage permission is granted or not
    private fun hasGrantedExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    //Checking whether foreground location permission is granted or not
    private fun hasGrantedForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    //Checking whether background location permission is granted or not
    /*On earlier versions of Android (before API Level 29), when your app receives foreground location access,
    it automatically receives background location access as well.*/
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hasGrantedBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        @RequiresApi(Build.VERSION_CODES.Q)
        if (!hasGrantedBackgroundPermission())
            permissionsToRequest.add(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION)

        if (!hasGrantedForegroundPermission())
            permissionsToRequest.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)

        if (!hasGrantedExternalStoragePermission())
            permissionsToRequest.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

        //only to request permissions
        /*The permissions dialog shown by the system when you call requestPermissions()
        says what permission your app wants, but doesn't say why.*/
        if (permissionsToRequest.isNotEmpty()) {
            Log.d("PermissionsRequest", "UI because of me ?: ")
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)

        }
    }

    /*Why do we need requestCode ?
    The point of the request code is that you can distinguish between different
    permission requests in the onRequestPermissionsResult handler.*/
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray //Either permission_granted or permission_denied
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("PermissionsRequest", "${permissions[i]} granted.")
            }
        }
    }


}

