package com.utad.base.ui.secondFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.base.model.Ropa
import com.utad.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelDetail @Inject constructor(
    private val repository: Repository
):ViewModel() {


    private var _uiState = MutableStateFlow(uiStateDetailView())
    val uiState: StateFlow<uiStateDetailView> = _uiState

    fun searchForThisItem(id: Int) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    objetoAMostrar = repository.getProductoById(id),
                )

            }
        }
    }
}


data class uiStateDetailView(
    var objetoAMostrar: Ropa = Ropa()
        )
