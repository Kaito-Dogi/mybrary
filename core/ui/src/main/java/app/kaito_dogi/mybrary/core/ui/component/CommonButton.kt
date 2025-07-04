package app.kaito_dogi.mybrary.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun CommonButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  isLoading: Boolean = false,
  icon: ImageVector? = null,
  variant: CommonButtonVariant = CommonButtonVariant.Filled,
) {
  val buttonContent: @Composable () -> Unit = {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      if (isLoading) {
        CircularProgressIndicator(
          modifier = Modifier.size(16.dp),
          strokeWidth = 2.dp,
        )
      } else {
        icon?.let { iconVector ->
          Icon(
            imageVector = iconVector,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
          )
          Spacer(modifier = Modifier.width(MybraryTheme.spaces.xs))
        }
      }
      
      Text(
        text = text,
        style = MybraryTheme.typography.labelLarge,
      )
    }
  }

  when (variant) {
    CommonButtonVariant.Filled -> {
      Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading,
        colors = ButtonDefaults.buttonColors(
          containerColor = MybraryTheme.colorScheme.primary,
          contentColor = MybraryTheme.colorScheme.onPrimary,
        ),
        contentPadding = PaddingValues(
          horizontal = MybraryTheme.spaces.md,
          vertical = MybraryTheme.spaces.sm,
        ),
        content = { buttonContent() },
      )
    }
    CommonButtonVariant.Outlined -> {
      OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading,
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = MybraryTheme.colorScheme.primary,
        ),
        contentPadding = PaddingValues(
          horizontal = MybraryTheme.spaces.md,
          vertical = MybraryTheme.spaces.sm,
        ),
        content = { buttonContent() },
      )
    }
    CommonButtonVariant.Text -> {
      TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading,
        colors = ButtonDefaults.textButtonColors(
          contentColor = MybraryTheme.colorScheme.primary,
        ),
        contentPadding = PaddingValues(
          horizontal = MybraryTheme.spaces.md,
          vertical = MybraryTheme.spaces.sm,
        ),
        content = { buttonContent() },
      )
    }
  }
}

enum class CommonButtonVariant {
  Filled,
  Outlined,
  Text,
}

@Preview
@Composable
private fun CommonButtonFilledPreview() {
  MybraryTheme {
    CommonButton(
      text = "Filled Button",
      onClick = {},
      variant = CommonButtonVariant.Filled,
    )
  }
}

@Preview
@Composable
private fun CommonButtonOutlinedPreview() {
  MybraryTheme {
    CommonButton(
      text = "Outlined Button",
      onClick = {},
      variant = CommonButtonVariant.Outlined,
    )
  }
}

@Preview
@Composable
private fun CommonButtonTextPreview() {
  MybraryTheme {
    CommonButton(
      text = "Text Button",
      onClick = {},
      variant = CommonButtonVariant.Text,
    )
  }
}

@Preview
@Composable
private fun CommonButtonLoadingPreview() {
  MybraryTheme {
    CommonButton(
      text = "Loading...",
      onClick = {},
      isLoading = true,
    )
  }
}

@Preview
@Composable
private fun CommonButtonDisabledPreview() {
  MybraryTheme {
    CommonButton(
      text = "Disabled Button",
      onClick = {},
      enabled = false,
    )
  }
}