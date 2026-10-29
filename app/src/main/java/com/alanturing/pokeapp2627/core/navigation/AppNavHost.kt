package com.alanturing.pokeapp2627.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alanturing.pokeapp2627.features.pokemon.PokeDetailsScreen
import com.alanturing.pokeapp2627.features.pokemon.PokeListScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.PokeList.route,
        modifier = modifier
    ) {
        composable(Routes.PokeList.route) {
            PokeListScreen { id ->
                navController.navigate(Routes.PokeDetails.route)
            }
        }
        composable(Routes.PokeDetails.route) {
            PokeDetailsScreen {
                navController.navigate(Routes.PokeList.route)
            }
        }
    }
}
