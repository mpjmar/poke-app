package com.alanturing.pokeapp2627.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.PokeList.route,
        modifier = modifier
    ) {
        composable(Routes.PokeList.route) {
            PokeListScreen {
                navController.navigate(Routes.PokeList.route)
            }
        }
        composable(Routes.PokeDetails.route) {
            PokeDetailsScreen {
                navController.navigate(Routes.PokeDetailsScreen.route)
            }
        }
    }
}
