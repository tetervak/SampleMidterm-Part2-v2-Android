package ca.tetervak.samplemidtermpart2v2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tetervak.samplemidtermpart2v2.model.BreedInfo

class MainViewModel : ViewModel(){

    private val _breedInfo: MutableLiveData<BreedInfo> = MutableLiveData()
    val breedInfo: LiveData<BreedInfo> = _breedInfo

    fun setBreedInfo(breedInfo: BreedInfo){
        _breedInfo.value = breedInfo
    }
}