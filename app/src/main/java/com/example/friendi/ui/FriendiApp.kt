package com.example.friendi.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.friendi.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendiApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { FriendiTopAppBar(scrollBehavior = scrollBehavior)}
    ) {
        padding -> HomeScreen(contentPadding = padding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendiTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        modifier = modifier,
        title = {
            Text(
                text = "Amphibians",
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    )
}