package com.example.composecomponents.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
private fun ProgressIndicators() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { CircularDeterminateIndicator() }
        item { LinearProgressWithText() }
        item { InfiniteCircularProgress() }
        item { LinearProgressWithPause() }
        item { ColoredLinearProgress() }
        item { CircularProgressWithBackground() }
        item { ProgressWithPercentage() }
    }
}

@Composable
fun CircularDeterminateIndicator() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column (
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ){
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            CircularProgressIndicator(
                progress = currentProgress,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100){
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Composable
fun LinearProgressWithText() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    progress = currentProgress,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text("${(currentProgress * 100).toInt()}%")
            }
        }
    }
}

@Composable
fun InfiniteCircularProgress() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (loading) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
fun LinearProgressWithPause() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    var paused by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column (
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = {
                if (!loading) {
                    loading = true
                    scope.launch {
                        loadProgress { progress ->
                            if (!paused) {
                                currentProgress = progress
                            }
                        }
                    }
                }
            }, enabled = !loading) {
            Text("start loading")
        }
        Button(onClick = {paused = !paused}) {
            Text(if (paused) "Resume" else "Pause")
        }
        if (loading){
            LinearProgressIndicator(
                progress = currentProgress,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ColoredLinearProgress() {
    var progress by remember { mutableStateOf(0.5f) }

    LinearProgressIndicator(
        progress = progress,
        color = Color.Green,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CircularProgressWithBackground() {
    var loading by remember { mutableStateOf(true) }

    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = Color.Blue,
            modifier = Modifier.size(100.dp)
        )
        CircularProgressIndicator(
            color = Color.Gray.copy(alpha = 0.3f),
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun ProgressWithPercentage() {
    var progress by remember { mutableFloatStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            for (i in 1..100) {
                delay(50)
                progress = i / 100f
            }
        }
    }

    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(100.dp),
            color = Color.Cyan
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun ProgressIndicatorsPreview() {
    ProgressIndicators()
}
