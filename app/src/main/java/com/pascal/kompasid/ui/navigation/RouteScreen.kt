@file:OptIn(
    ExperimentalMotionApi::class,
    ExperimentalSharedTransitionApi::class
)

package com.pascal.kompasid.ui.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pascal.kompasid.ui.screen.detail.DetailScreen
import com.pascal.kompasid.ui.screen.favorite.FavoriteScreen
import com.pascal.kompasid.ui.screen.home.HomeScreen
import com.pascal.kompasid.ui.screen.profile.ProfileScreen
import com.pascal.kompasid.ui.screen.splash.SplashScreen
import com.pascal.kompasid.utils.base.getFromPreviousBackStack
import com.pascal.kompasid.utils.base.saveToCurrentBackStack

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RouteScreen(
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(
                    Screen.HomeScreen.route,
                    Screen.EPaperScreen.route,
                    Screen.TTSScreen.route,
                    Screen.BookScreen.route,
                    Screen.ProfileScreen.route
                )) {
                BottomBar(navController)
            }
        }
    ) { paddingValues ->
        SharedTransitionLayout {
            NavHost(
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                navController = navController,
                startDestination = Screen.SplashScreen.route,
            ) {
                composable(route = Screen.SplashScreen.route) {
                    SplashScreen(
                        paddingValues = paddingValues
                    ) {
                        navController.navigate(Screen.HomeScreen.route) {
                            popUpTo(Screen.SplashScreen.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
                composable(route = Screen.HomeScreen.route) {
                    HomeScreen(
                        onDetail = {
                            saveToCurrentBackStack(navController, "articles", it)
                            navController.navigate(Screen.DetailScreen.route)
                        }
                    )
                }
                composable(route = Screen.DetailScreen.route) {
                    DetailScreen(
                        item = getFromPreviousBackStack(navController, "articles"),
                        onNavBack = {
                            navController.popBackStack()
                        }
                    )
                }
                composable(route = Screen.EPaperScreen.route) {
                    FavoriteScreen(
                        paddingValues = paddingValues,
                        onDetail = {}
                    )
                }
                composable(route = Screen.TTSScreen.route) {
                    FavoriteScreen(
                        paddingValues = paddingValues,
                        onDetail = {}
                    )
                }
                composable(route = Screen.BookScreen.route) {
                    FavoriteScreen(
                        paddingValues = paddingValues,
                        onDetail = {}
                    )
                }
                composable(route = Screen.ProfileScreen.route) {
                    ProfileScreen(
                        paddingValues = paddingValues,
                        onDetail = {}
                    )
                }
            }
        }
    }
}