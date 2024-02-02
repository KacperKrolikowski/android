package pl.autopay.parkology.ui.parks.intents

sealed class ParksEvent {
    object LoadMore : ParksEvent()
    data class QueryChanged(val query: String) : ParksEvent()
}