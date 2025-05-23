package com.example.friendi.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.friendi.AmphibianApplication
import com.example.friendi.data.FriendiRepository
import com.example.friendi.model.Amphibian
import kotlinx.coroutines.launch
import java.io.IOException

// interface for possible UI states app can be in and its implementations
sealed interface FriendiUiState {
    data class Success(val amphibians: List<Amphibian>) : FriendiUiState
    object Error : FriendiUiState
    object Loading : FriendiUiState
}

// this class will actually provide the viewmodel object that will be used to provide the UI state throughout the app
class FriendiViewModel(private val friendiRepository: FriendiRepository) : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var friendiUiState: FriendiUiState by mutableStateOf(FriendiUiState.Loading)
        private set

    /**
     * Call getAmphibianObjects() on init so we can display status immediately.
     */
    init {
        getAmphibianObjects()
    }

    /**
     * Gets app data from the API Retrofit service and updates the
     * [Amphibian] [List] [MutableList].
     */
    fun getAmphibianObjects() {
        viewModelScope.launch {
            friendiUiState = FriendiUiState.Loading
            friendiUiState = try {
                FriendiUiState.Success(
                    friendiRepository.getAmphibianObjects()
                )
            } catch (e: IOException) {
                FriendiUiState.Error
            } catch (e: HttpException) {
                FriendiUiState.Error
            }
        }
    }

    /**
     * Factory for [FriendiViewModel] that takes [FriendiRepository] as a dependency
     */
    // purpose is to dependency inject our repository into our viewmodel
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val friendiRepository = application.container.friendiRepository
                FriendiViewModel(friendiRepository = friendiRepository) // dependency inject our repository into our viewmodel
            }
        }
    }



}