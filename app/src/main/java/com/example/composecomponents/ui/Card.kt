package com.example.composecomponents.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponents.R

@Composable
private fun CardExample() {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        item { CardMinimalExample() }
        item { FilledCardExample() }
        item { IconTextCard() }
        item { ImageCard() }
        item { CardWithButton() }
        item { RoundedCornerCard() }
        item{ AnimatedCard() }
        item { RotatingCard() }
        item { ElevatedCardExample() }
        item { OutlinedCardExample() }
        item { CarouselCardExample() }
    }
}

@Composable
fun CardMinimalExample() {
    Card() {
        Text(text = "Hello, world!")
    }
}

@Composable
fun FilledCardExample() {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ){
        Text(
            text = "Filled",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun IconTextCard() {
    Card (
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Favorite Item",
                modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}

@Composable
fun ImageCard() {
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "Sample Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Text(
                text = "Kart Başlığı",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Bu kart örneğinde başlık ve bir açıklama metni var.",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun CardWithButton() {
    Card (
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = "Kart üzerindeki buton", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Bu bir kart örneğidir.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}) {
                Text("Tıkla..")
            }
        }
    }
}

@Composable
fun RoundedCornerCard(){
    Card (
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp),
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Köşeli Kart")
        }
    }
}

@Composable
fun AnimatedCard() {
    var isHovered by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isHovered) 2.1f else 1f)

    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .graphicsLayer (scaleX = scale, scaleY = scale)
            .pointerInput(Unit) {
                detectTapGestures (
                    onPress = {
                        isHovered = true
                        tryAwaitRelease()
                        isHovered = false
                    }
                )
            },
        elevation = CardDefaults.cardElevation(5.dp),
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Animasyonlu Kart")
            Text(text = "Bu kartın üzerine tıkladığınızda büyür.")
        }
    }
}

@Composable
fun RotatingCard() {
    var isRotated by remember { mutableStateOf(false) }
    val rottaion by animateFloatAsState(targetValue = if (isRotated) 180f else 0f)

    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .graphicsLayer(rotationY = rottaion)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isRotated = !isRotated
                        tryAwaitRelease()
                    }
                )
            },
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Text(text = "Döndürülmüş Kart")
        }
    }
}

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(5.dp, Color.Black),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun CarouselCardExample() {
    val items = listOf("Kart 1", "Kart 2", "Kart 3")
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.size(width = 150.dp, height = 150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                )
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = item)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    CardExample()
}
