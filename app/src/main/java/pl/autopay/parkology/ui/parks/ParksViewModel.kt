package pl.autopay.parkology.ui.parks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import pl.autopay.parkology.data.repository.ParkRepository
import pl.autopay.parkology.ui.parks.intents.ParksEvent
import pl.autopay.parkology.ui.parks.intents.ParksViewState
import javax.inject.Inject

@HiltViewModel
class ParksViewModel @Inject constructor(
    private val repo: ParkRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(ParksViewState())
    val viewState: StateFlow<ParksViewState> = _viewState

    private var page = 0

    init {
        getParks()
    }

    fun onEvent(event: ParksEvent) {
        when (event) {
            ParksEvent.LoadMore -> loadMore()
            is ParksEvent.QueryChanged -> queryChanged(event.query)
        }
    }

    private fun queryChanged(query: String) {
        _viewState.update { it.copy(query = query) }
    }

    private fun loadMore() {
        page++
        getParks()
    }

    private fun getParks() {
        repo.getParks(page)
            .onEach { response -> _viewState.update { it.copy(parks = it.parks.plus(response.data)) } }
            .launchIn(viewModelScope)
    }
}