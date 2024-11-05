package com.example.composecomponents.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        fontSize = 24.sp,
        lineHeight = 32.sp,
        color = Color.Red,
        maxLines = 4,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AnnotatedText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Kullanım şartlarını")
            }
            append(" okudum, kabul ediyorum")
        }
    )
}

@Composable
fun TextStyleText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        fontSize = 24.sp,
        style = TextStyle(
            brush = Brush.horizontalGradient(colors = listOf(Color.Magenta, Color.Blue)),
            shadow = Shadow(
                color = Color.Gray,
                offset = Offset(
                    4f,
                    4f
                ),
                blurRadius = 10f
            )
        )
    )
}

@Composable
fun OverFlowText() {
    Text(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed Do Eiusmed ",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TextDecorationText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun BackgroundColorText() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Yellow),
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun NormalTextPreview() {
    NormalText()
}

@Preview(showBackground = true)
@Composable
fun AnnotatedTextPreview() {
    AnnotatedText()
}

@Preview(showBackground = true)
@Composable
fun TextStyleTextPreview() {
    TextStyleText()
}

@Preview(showBackground = true)
@Composable
fun OverFlowTextPreview() {
    OverFlowText()
}

@Preview(showBackground = true)
@Composable
fun TextDecorationTextPreview() {
    TextDecorationText()
}

@Preview(showBackground = true)
@Composable
fun BackgroundColorTextPreview() {
    BackgroundColorText()
}