package app.doggy.newmybrary

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration

@HiltAndroidApp
class MybraryApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Realm.init(this)
    val realmConfig = RealmConfiguration.Builder()
      .deleteRealmIfMigrationNeeded()
      .build()
    Realm.setDefaultConfiguration(realmConfig)
  }
}
