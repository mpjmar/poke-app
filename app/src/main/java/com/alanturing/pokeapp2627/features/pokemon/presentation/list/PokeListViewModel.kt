package com.alanturing.pokeapp2627.features.pokemon.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.pokeapp2627.features.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokeListUiState>(PokeListUiState.Loading)
    val uiState: StateFlow<PokeListUiState> = _uiState.asStateFlow()

    init {
        loadPokemonList()
    }

    fun loadPokemonList() {
        viewModelScope.launch {
            _uiState.value = PokeListUiState.Loading
            try {
                val pokemons = repository.readAllPokemon()
                _uiState.value = PokeListUiState.Success(pokemons)
            } catch (e: Exception) {
                _uiState.value = PokeListUiState.Error(e.message ?: "Error")
            }
        }
    }
}