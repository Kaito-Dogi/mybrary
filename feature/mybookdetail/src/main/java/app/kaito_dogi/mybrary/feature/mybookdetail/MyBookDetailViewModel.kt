package app.kaito_dogi.mybrary.feature.mybookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MyBookDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  val arg: MyBookDetailNavArg = checkNotNull(savedStateHandle[myBookDetailNavArgName])
}
