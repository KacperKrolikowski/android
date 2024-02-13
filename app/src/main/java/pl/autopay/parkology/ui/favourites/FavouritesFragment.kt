package pl.autopay.parkology.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.autopay.parkology.core.theme.ParkologyTheme
import pl.autopay.parkology.ui.details.ParkDetailsEntity

@AndroidEntryPoint
class FavouritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ParkologyTheme {
                    FavouritesScreen(openDetails = ::openDetails)
                }
            }
        }
    }

    private fun openDetails(park: ParkDetailsEntity){
        findNavController().navigate(FavouritesFragmentDirections.openParkDetailsFragment(park))
    }
}