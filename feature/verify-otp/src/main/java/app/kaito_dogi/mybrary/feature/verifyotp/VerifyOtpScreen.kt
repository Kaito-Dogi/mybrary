package app.kaito_dogi.mybrary.feature.verifyotp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.extension.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VerifyOtpScreen(
  otp: String,
  onOtpChange: (String) -> Unit,
  onLoginClick: () -> Unit,
  onSignUpClick: () -> Unit,
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "Enter One-Time Password",
          )
        },
      )
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding.plus(horizontal = MybraryTheme.space.md)),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      TextField(
        value = otp,
        onValueChange = onOtpChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
          Text("123456")
        },
        leadingIcon = {
          Icon(
            iconResId = R.drawable.icon_key,
            // FIXME: 文言
            descResId = R.string.my_book_list_desc_search_for_books,
          )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.NumberPassword,
          imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(
          onSend = { onLoginClick() },
        ),
        singleLine = true,
      )

      Button(
        onClick = onLoginClick,
        modifier = Modifier.fillMaxWidth(),
      ) {
        Text("Login")
      }
    }
  }
}

@Preview
@Composable
private fun VerifyOtpScreenPreview() {
  MybraryTheme {
    VerifyOtpScreen(
      otp = "",
      onOtpChange = {},
      onLoginClick = {},
      onSignUpClick = {},
    )
  }
}
