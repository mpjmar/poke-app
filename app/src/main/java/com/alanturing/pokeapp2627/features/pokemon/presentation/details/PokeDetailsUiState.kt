package com.alanturing.pokeapp2627.features.pokemon.presentation.details

import com.alanturing.pokeapp2627.features.pokemon.data.model.Pokemon

sealed interface PokeDetailsUiState {
    object Loading : PokeDetailsUiState
    object NotFound : PokeDetailsUiState
    data class Success(val pokemonDetail: Pokemon) : PokeDetailsUiState
    data class Error(val message: String) : PokeDetailsUiState
}