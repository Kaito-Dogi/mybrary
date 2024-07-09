package app.kaito_dogi.mybrary.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.extension.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.login.component.DividerSection
import app.kaito_dogi.mybrary.feature.login.component.LogoSection
import app.kaito_dogi.mybrary.feature.login.component.MailSection
import app.kaito_dogi.mybrary.feature.login.component.SignUpSection

@Composable
internal fun LoginScreen() {
  Scaffold { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(
          innerPadding.plus(
            horizontal = MybraryTheme.space.xl,
            vertical = MybraryTheme.space.xxxl,
          ),
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      LogoSection(modifier = Modifier.weight(1f))
      Gap(height = MybraryTheme.space.xl)
      MailSection(
        mail = "",
        onMailChange = { /*TODO*/ },
        password = "",
        onPasswordChange = { /*TODO*/ },
        onMailLoginClick = { /*TODO*/ },
      )
      Gap(height = MybraryTheme.space.xl)
      DividerSection()
      Gap(height = MybraryTheme.space.xl)
      OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
      ) {
        Icon(
          painter = painterResource(id = R.drawable.icon_google),
          contentDescription = "メールアドレスでログイン",
          tint = Color.Unspecified,
        )
        Gap(width = MybraryTheme.space.xs)
        Text(text = "Googleでログイン")
      }
      Gap(height = MybraryTheme.space.sm)
      SignUpSection(onClick = { /*TODO*/ })
    }
  }
}

@Preview
@Composable
private fun LoginScreenPreview() {
  MybraryTheme {
    LoginScreen()
  }
}
