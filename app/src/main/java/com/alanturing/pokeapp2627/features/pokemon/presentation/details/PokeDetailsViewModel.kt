package com.alanturing.pokeapp2627.features.pokemon.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.pokeapp2627.features.pokemon.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PokeDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokeDetailsUiState>(PokeDetailsUiState.Loading)
    val uiState: StateFlow<PokeDetailsUiState> = _uiState.asStateFlow()

    // TODO: Implementar como recibe ID
    init {
        // loadPokemonDetail(id)
    }

    fun loadPokemonDetail(id: Int) {
        viewModelScope.launch {
            _uiState.value = PokeDetailsUiState.Loading
            try {
                val pokemon = repository.readPokemonById(id)
                if (pokemon != null) {
                    _uiState.value = PokeDetailsUiState.Success(pokemon)
                } else {
                    _uiState.value = PokeDetailsUiState.NotFound
                }
            } catch (e: Exception) {
                _uiState.value = PokeDetailsUiState.Error(e.message ?: "Error")
            }
        }
    }
}