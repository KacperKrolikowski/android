package pl.autopay.parkology.ui.parks.intents

import pl.autopay.parkology.data.network.dto.park.Park

data class ParksViewState(
    val parks: List<Park> = emptyList(),
    val query: String = ""
)
