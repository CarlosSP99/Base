package com.utad.base.ui.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.base.model.Ropa
import com.utad.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private var _uiState = MutableStateFlow(uiStateMainView())

    val uiState: StateFlow<uiStateMainView> = _uiState.asStateFlow()


    init{
        fetchDataHombre()
    }

     fun fetchDataHombre() {
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(
                    ropaList = repository.getProductosHombre(),
                    isLoading = false
                )
            }
        }
    }

     fun fetchDataMujer() {
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(
                    ropaList = repository.getProductosMujer(),
                    isLoading = false
                )
            }
        }
    }
     fun fetchDataJewelery() {
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(
                    ropaList = repository.getProductosJoyeria(),
                    isLoading = false
                )
            }
        }
    }
     fun fetchDataElectornics() {
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(
                    ropaList = repository.getProductosElectronica(),
                    isLoading = false
                )
            }
        }
    }

}

data class uiStateMainView(
    var isLoading: Boolean = true,
    var ropaList: List<Ropa> = emptyList() )
