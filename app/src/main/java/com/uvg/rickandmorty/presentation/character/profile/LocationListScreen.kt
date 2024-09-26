package com.uvg.rickandmorty.presentation.character.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.rickandmorty.data.model.Location
import com.uvg.rickandmorty.data.source.LocationDb

@Composable
fun LocationListRoute(
    onLocationClick: (Int) -> Unit,
) {
    val locationDb = LocationDb()
    val locations = locationDb.getAllLocations()
    LocationListScreen(
        locations = locations,
        onLocationClick = onLocationClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun LocationListScreen(
    locations: List<Location>,
    onLocationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(locations) { item ->
            LocationItem(
                location = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLocationClick(item.id) }
            )
        }
    }
}

@Composable
private fun LocationItem(
    location: Location,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column {
            Text(text = location.name)
            Text(
                text = location.type,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
