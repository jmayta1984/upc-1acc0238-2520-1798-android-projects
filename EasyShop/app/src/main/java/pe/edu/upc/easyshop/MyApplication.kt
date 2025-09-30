package pe.edu.upc.easyshop

import android.app.Application

class MyApplication : Application() {

    companion object {
        lateinit var INSTANCE: MyApplication
            private set

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}