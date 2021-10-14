package ca.tetervak.samplemidtermpart2v2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ca.tetervak.samplemidtermpart2v2.MainViewModel
import ca.tetervak.samplemidtermpart2v2.R
import ca.tetervak.samplemidtermpart2v2.databinding.InputFragmentBinding
import ca.tetervak.samplemidtermpart2v2.model.BreedInfo

class InputFragment : Fragment() {

    private val mainViewModel : MainViewModel by activityViewModels()

    private var _binding: InputFragmentBinding? = null
    private val binding: InputFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InputFragmentBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener { showOutput() }
        return binding.root
    }

    private fun showOutput() {
        val breedName = binding.breedInput.text.toString().trim()
        if(breedName.isEmpty()){
            val required = getString(R.string.error_required)
            binding.breedInput.error = required
        }else{
            val hairList = resources.getStringArray(R.array.hair_length_list)
            val hairLength = hairList[binding.hairInput.selectedItemPosition]
            val breedInfo = BreedInfo(breedName, hairLength)
            mainViewModel.setBreedInfo(breedInfo)
            findNavController().navigate(R.id.action_input_to_output)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}