package com.example.composecomponents.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheets() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        item { SimpleModalBottomSheet() }
        item { SelectableBottomSheet() }
        item { DynamicContentBottomSheet() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleModalBottomSheet() {
    var showModal by remember { mutableStateOf(false) }

    if (showModal) {
        ModalBottomSheet(
            onDismissRequest = { showModal = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is a Modal Bottom Sheet")
                Spacer(Modifier.height(8.dp))
                Button(onClick = { showModal = false }) {
                    Text("Close")
                }
            }
        }
    }

    Button(onClick = { showModal = true }) {
        Text("Open Modal Bottom Sheet")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectableBottomSheet() {
    var showSheet by remember { mutableStateOf(false) }
    val options = listOf("Option 1", "Option 2", "Option 3")

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Select an Option")
                options.forEach { option ->
                    Button(
                        onClick = {
                            println("Selected $option")
                            showSheet = false
                        },
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Text(option)
                    }
                }
            }
        }
    }

    Button(onClick = { showSheet = true }) {
        Text("Show Selectable Bottom Sheet")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicContentBottomSheet() {
    var showSheet by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf("Info") }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Button(onClick = { selectedTab = "Info" }) { Text("Info") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { selectedTab = "Settings" }) { Text("Settings") }
                }
                Spacer(Modifier.height(16.dp))

                when (selectedTab) {
                    "Info" -> Text("This is information content.")
                    "Settings" -> Text("This is settings content.")
                }
                Button(onClick = { showSheet = false }) {
                    Text("Close")
                }
            }
        }
    }

    Button(onClick = { showSheet = true }) {
        Text("Show Dynamic Content Bottom Sheet")
    }
}


@Preview(showBackground = true)
@Composable
fun BottomSheetsPreview() {
    BottomSheets()
}
