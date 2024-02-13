package pl.autopay.parkology.ui.parks.intents

import pl.autopay.parkology.ui.details.ParkDetailsEntity

data class ParksViewState(
    val parks: List<ParkDetailsEntity> = emptyList(),
    val query: String = ""
)
