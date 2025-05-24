package com.example.friendi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.friendi.R
import com.example.friendi.model.Amphibian

// this is the main screen of the app
@Composable
fun HomeScreen(
    friendiUiState: FriendiUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val dummyList = List(6) {
        Amphibian(
            stringResourceId = R.string.loading,
            imageResourceId = R.drawable.ic_broken_image
        )
    }

    AmphibianList(
        amphibianList = dummyList,
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)
    )
}

@Composable
fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column {
            Image(
                painter = painterResource(amphibian.imageResourceId),
                contentDescription = stringResource(amphibian.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(amphibian.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

}

@Composable
fun AmphibianList(
    amphibianList: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(amphibianList) { amphibian ->
            AmphibianCard(
                amphibian = amphibian,
                modifier = Modifier.padding(8.dp)
            )
        }

    }

}