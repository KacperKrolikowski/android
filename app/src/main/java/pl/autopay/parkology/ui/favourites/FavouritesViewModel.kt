package pl.autopay.parkology.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.autopay.parkology.data.repository.FavouritesRepository
import pl.autopay.parkology.ui.details.mapToParkDetailsEntity
import pl.autopay.parkology.ui.favourites.intents.FavouritesViewState
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val favouritesRepository: FavouritesRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(FavouritesViewState())
    val viewState: StateFlow<FavouritesViewState> = _viewState

    init {
        getFavouritesList()
    }

    private fun getFavouritesList() {
        viewModelScope.launch {
            favouritesRepository.getSavedParks()
                .collect { result ->
                    result.map { list ->
                        _viewState.update {
                            it.copy(favouritesParks = list.map { park ->
                                park.mapToParkDetailsEntity()
                            })
                        }
                    }
                }
        }
    }
}