package pl.autopay.parkology.ui.parks

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
import pl.autopay.parkology.data.network.dto.park.Park

@AndroidEntryPoint
class ParksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ParkologyTheme {
                    ParksScreen(
                        openDetails = ::openDetails,
                    )
                }
            }
        }
    }

    private fun openDetails(park: Park) {
        findNavController().navigate(ParksFragmentDirections.openParkDetailsFragment(park))
    }
}
