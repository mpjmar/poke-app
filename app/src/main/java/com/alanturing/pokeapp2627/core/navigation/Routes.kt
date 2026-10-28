package com.alanturing.pokeapp2627.core.navigation
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    object PokeList: Routes("listScreen")
}
