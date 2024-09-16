package app.kaito_dogi.mybrary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.exception.ExceptionConsumer
import app.kaito_dogi.mybrary.core.ui.exception.ExceptionConsumerEntryPoint
import app.kaito_dogi.mybrary.core.ui.navigation.AppRoute
import app.kaito_dogi.mybrary.core.ui.navigation.AppScaffold
import app.kaito_dogi.mybrary.core.ui.navigation.MainRoute
import app.kaito_dogi.mybrary.core.ui.navigation.mainNavGraph
import app.kaito_dogi.mybrary.feature.mybook.MyBookRoute
import app.kaito_dogi.mybrary.feature.mybook.myBookDestination
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.myBookListScreen
import app.kaito_dogi.mybrary.feature.setting.SettingRoute
import app.kaito_dogi.mybrary.feature.setting.route.settinglist.settingListScreen
import app.kaito_dogi.mybrary.feature.setting.settingDestination
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MybraryTheme {
        // FIXME: 共通化する
        val context = LocalContext.current
        val exceptionConsumer: ExceptionConsumer = remember(context) {
          EntryPointAccessors.fromApplication<ExceptionConsumerEntryPoint>(context.applicationContext)
            .exceptionConsumer()
        }
        val exception = exceptionConsumer.exception.collectAsStateWithLifecycle()
        LaunchedEffect(exception) {
          // FIXME: 共通のエラー処理を実行
          exceptionConsumer.consumeException()
        }

        // FIXME: 適切な場所に置く
        val mainNavController = rememberNavController()

        // FIXME: ログイン状態に応じて startDestination を変更する
        AppScaffold(
          mainNavController = mainNavController,
          startDestination = AppRoute.Main,
        ) { appNavController ->
          mainNavGraph(
            navController = mainNavController,
            startDestination = MainRoute.MyBook,
          ) {
            myBookDestination(
              startDestination = MyBookRoute.MyBookList,
            ) { myBookNavController ->
              myBookListScreen()
            }

            settingDestination(
              startDestination = SettingRoute.SettingList,
            ) { settingNavController ->
              settingListScreen()
            }
          }
        }
      }
    }
  }
}
