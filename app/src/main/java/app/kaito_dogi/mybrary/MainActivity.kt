package app.kaito_dogi.mybrary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

        // FIXME: ログイン状態に応じて startDestination を変更する
        AppScaffold(
          startDestination = AppRoute.Main,
        ) { appNavController ->
          mainNavGraph(startDestination = MainRoute.MyBook) { mainNavController ->
            myBookDestination(startDestination = MyBookRoute.MyBookList) { myBookNavController ->
              myBookListScreen()
            }
          }
        }
      }
    }
  }
}
