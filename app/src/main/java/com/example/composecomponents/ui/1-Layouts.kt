package com.example.composecomponents.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponents.R

@Composable
fun ColumnSamples() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "item one")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "item two")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "item three")
    }
}

@Composable
fun RowSamples() {
    Row (
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = "item one")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "item two")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "item three")
    }
}

@Composable
fun BoxSamples() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Launcher background"
        )
        Text(text = "item one")
    }
}

@Composable
fun LayoutSample() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Person"
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(text = "Name")
            Text(text = "Surname")
        }
        Spacer(modifier = Modifier.weight(1f))
        Box (
            modifier = Modifier.background(
                color = Color.Blue,
                shape = androidx.compose.foundation.shape.CircleShape
            )
                .padding(16.dp)
        ){
            Image(
                painter = painterResource(id =R.drawable.ic_delete),
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Delete"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableSamplePreview() {
    ColumnSamples()
}

@Preview(showBackground = true)
@Composable
fun RowSamplesPreview() {
    RowSamples()
}

@Preview(showBackground = true)
@Composable
fun BoxSamplesPreview() {
    BoxSamples()
}

@Preview(showBackground = true)
@Composable
fun LayoutSamplePreview() {
    LayoutSample()
}