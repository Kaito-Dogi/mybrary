package app.kaito_dogi.mybrary.core.ui.config

import app.kaito_dogi.mybrary.core.config.AppConfig
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppConfigEntryPoint {
  val appConfig: AppConfig
}
