package pl.autopay.parkology.ui.favourites.intents

import pl.autopay.parkology.ui.details.ParkDetailsEntity

data class FavouritesViewState (
    val favouritesParks: List<ParkDetailsEntity> = emptyList()
)