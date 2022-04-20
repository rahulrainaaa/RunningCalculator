package app.calculator.running.core

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocationLiveData @Inject constructor(@ApplicationContext private val context: Context) : LiveData<Location>() {

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    override fun onActive() {
        super.onActive()
        enableLiveLocation()
    }

    private fun enableLiveLocation() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0F, listener)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0F, listener)

        }
    }

    override fun onInactive() {
        super.onInactive()
        locationManager.removeUpdates(listener)
    }

    private fun notifyUpdates(data: Location) {
        if (hasActiveObservers()) value = data
    }

    private val listener = LocationListener {
        notifyUpdates(it)
    }
}