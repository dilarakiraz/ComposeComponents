package com.example.composecomponents.ui.touchAndInput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.times
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.composecomponents.R
import java.time.format.TextStyle
import kotlin.math.roundToInt

@Composable
fun TapGestureCounter() {
    var tapCount by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Blue)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        tapCount++ // Her dokunuşta sayaç bir artar
                    }
                )
            }
    ) {
        Text(
            text = "Dokunarak Sayaç: $tapCount",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun DoubleTapZoomImage() {
    var scale by remember { mutableStateOf(1f) }

    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Gray)
            .pointerInput(Unit) {
                detectTapGestures (
                    onDoubleTap = {
                        scale *= 1.5f
                    }
                )
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "SampleImage",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(scaleX = scale, scaleY = scale)
        )
    }
}

@Composable
fun DragToMoveBox() {
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
            .offset{ IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    offset = Offset(offset.x + dragAmount.x, offset.y + dragAmount.y)
                }
            }
    ){
        Text(
            text = "Sürükle Beni!",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}

@Composable
fun RotateAndScaleImage() {
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Gray)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, rotationDelta ->
                    // Kullanıcı ölçeklerken ve döndürürken, değişiklikleri uygula
                    scale *= zoom
                    rotation += rotationDelta
                }
            }
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Sample Image",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation
                )
        )
    }
}

@Composable
fun ScrollableListExample() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        repeat(50) { index ->
            Text(
                text = "Öğe #$index",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ToggleTextCase() {
    var text by remember { mutableStateOf("Jetpack Compose") }

    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Cyan)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        text = if (text == text.uppercase()) text.lowercase() else text.uppercase()
                    }
                )
            }
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp)
        )
    }
}

@Preview
@Composable
fun TapGestureCounterPreview() {
    TapGestureCounter()
}

@Preview
@Composable
fun DoubleTapZoomImagePreview() {
    DoubleTapZoomImage()
}

@Preview
@Composable
fun DragToMoveBoxPreview() {
    DragToMoveBox()
}

@Preview
@Composable
fun RotateAndScaleImagePreview() {
    RotateAndScaleImage()
}

@Preview
@Composable
fun ScrollableListExamplePreview() {
    ScrollableListExample()
}

@Preview
@Composable
fun ToggleTextCasePreview() {
    ToggleTextCase()
}