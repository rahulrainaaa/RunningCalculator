package app.calculator.running

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.lifecycle.LiveData

class LocationLiveData(context: Context) : LiveData<Location>() {

    private val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0F, listener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0F, listener)
    }

    private fun notifyUpdates(data: Location) {
        if (hasActiveObservers()) value = data
    }

    private val listener = LocationListener {
        notifyUpdates(it)
    }
}