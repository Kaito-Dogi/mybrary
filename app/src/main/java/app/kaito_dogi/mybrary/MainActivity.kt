package app.kaito_dogi.mybrary

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.browser.rememberInternalBrowserLauncher
import app.kaito_dogi.mybrary.core.ui.exception.ExceptionConsumer
import app.kaito_dogi.mybrary.core.ui.exception.ExceptionConsumerEntryPoint
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.SearchBookRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.SettingRoute
import app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.myBookDetailEntry
import app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist.myBookListEntry
import app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.searchBookEntry
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.settingListEntry
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    setContent {
      MybraryTheme {
        // FIXME: 共通化する
        val context = LocalContext.current
        val exceptionConsumer: ExceptionConsumer = remember(key1 = context) {
          EntryPointAccessors.fromApplication<ExceptionConsumerEntryPoint>(context.applicationContext)
            .exceptionConsumer()
        }
        val exception = exceptionConsumer.exception.collectAsStateWithLifecycle()
        LaunchedEffect(key1 = exception) {
          // FIXME: 共通のエラー処理を実行
          exceptionConsumer.consumeException()
        }

        val backStack = rememberNavBackStack(MyBookRoute.MyBookList)
        val internalBrowserLauncher = rememberInternalBrowserLauncher()

        NavDisplay(
          backStack = backStack,
          onBack = { backStack.removeLastOrNull() },
          entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
          ),
          entryProvider = entryProvider {
            myBookListEntry(
              onSettingClick = { backStack.add(element = SettingRoute.SettingList) },
              onAdditionClick = { backStack.add(element = SearchBookRoute.SearchBook) },
              onMyBookClick = { myBook ->
                backStack.add(element = MyBookRoute.MyBookDetail(myBook = myBook))
              },
            )

            myBookDetailEntry(
              onNavigationIconClick = { backStack.removeLastOrNull() },
            )

            searchBookEntry()

            settingListEntry(
              onNavigationIconClick = { backStack.removeLastOrNull() },
              onTermsOfUseClick = internalBrowserLauncher::launch,
              onPrivacyPolicyClick = internalBrowserLauncher::launch,
              onLicenceClick = {},
              onRakutenDevelopersClick = internalBrowserLauncher::launch,
            )
          },
        )
      }
    }
  }
}
