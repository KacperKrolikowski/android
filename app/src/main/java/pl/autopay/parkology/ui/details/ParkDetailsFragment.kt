package pl.autopay.parkology.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import pl.autopay.parkology.databinding.FragmentParkDetailsBinding
import pl.autopay.parkology.util.loadImage

@AndroidEntryPoint
class ParkDetailsFragment : Fragment() {

    private val args by navArgs<ParkDetailsFragmentArgs>()

    private var _binding: FragmentParkDetailsBinding? = null
    private val binding: FragmentParkDetailsBinding get() = _binding!!

    @Suppress("UnnecessaryVariable")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParkDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.imgPark.loadImage(args.park.images.first().url)
        binding.txtName.text = args.park.fullName
        binding.txtDesc.text = args.park.description
        binding.btnBack.setOnClickListener { findNavController().navigateUp() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}