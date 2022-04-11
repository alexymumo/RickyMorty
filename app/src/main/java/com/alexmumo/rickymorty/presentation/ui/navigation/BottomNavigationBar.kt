package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    backStackEntryState: State<NavBackStackEntry?>,
    bottomNavItems: List<NavigationItem>,
    navController: NavController
) {
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .alpha(0.95f),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        cutoutShape = RoundedCornerShape(70),
        elevation = 16.dp
    ) {
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.Red
        ) {
            bottomNavItems.forEach { item ->
                val isSelected = item.route == backStackEntryState.value?.destination?.route
                BottomNavigationItem(
                    icon = {
                        Icon(painter = painterResource(id = item.icon!!),
                            contentDescription = stringResource(id = item.title!!)
                        )
                    },
                    label = {
                        Text(text = stringResource(id = item.title!!))
                    },
                    selectedContentColor = Color.Cyan,
                    unselectedContentColor = Color.Gray,
                    alwaysShowLabel = true,
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
