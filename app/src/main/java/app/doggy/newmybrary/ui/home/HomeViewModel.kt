package app.doggy.newmybrary.ui.home

import androidx.lifecycle.ViewModel
import app.doggy.newmybrary.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val bookRepository: BookRepository,
) : ViewModel()
