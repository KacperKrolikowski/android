package pl.autopay.parkology.ui.favourites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import pl.autopay.parkology.ui.details.ParkDetailsEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavouritesScreen(
    openDetails: (ParkDetailsEntity) -> Unit,
    viewModel: FavouritesViewModel = hiltViewModel()
) {
    val state by viewModel.viewState.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        items(state.favouritesParks) { park ->
            Card(onClick = { openDetails(park) }) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    AsyncImage(
                        model = park.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.background.copy(alpha = 0.6f))
                    ) {
                        Text(
                            text = park.name,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}