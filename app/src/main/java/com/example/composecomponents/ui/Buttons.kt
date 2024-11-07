package com.example.composecomponents.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Buttons() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Filled() }
        item { FilledTonal() }
        item { Outlined() }
        item { Elevated() }
        item { ButtonWithText() }
        item { ButtonWithIcon() }
        item { IconTextButton() }
        item { SingleChoicesSegmentedButton() }
        item { MultipleChoicesSegmentedButton() }
        item { FAB() }
        item { CheckboxExample() }
        item { SwitchExample() }
        item { RadioButtonGroupExample() }
        item { CardExample() }
        item { SliderExample() }
        item { OutlinedTextFieldExample() }
    }
}

@Composable
fun Filled() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.Red,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = true,
        shape = RoundedCornerShape(25),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 24.dp
        ),
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Blue)
            ),
        ),
    ) {
        Text(text = "Filled Button")
    }
}

@Composable
fun FilledTonal() {
    FilledTonalButton(
        onClick = {},
    ) {
        Text("Filled Tonal Button")
    }
}

@Composable
private fun Outlined() {
    OutlinedButton(
        onClick = {}
    ) {
        Text("Outlined Button")
    }
}

@Composable
fun Elevated() {
    ElevatedButton(
        onClick = {}
    ) {
        Text("Elevated Button")
    }
}

@Composable
fun ButtonWithText() {
    TextButton(
        onClick = {}
    ) {
        Text("Text Button")
    }
}

@Composable
fun ButtonWithIcon() {
    IconButton(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
    }
}

@Composable
fun IconTextButton() {
    Button(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
        Text("Add")
    }
}

@Composable
fun SingleChoicesSegmentedButton() {
    var checkedItem by remember { mutableIntStateOf(0) }
    val options = listOf("Option 1", "Option 2", "Option 3")
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, option ->
            SegmentedButton(
                onClick = {
                    checkedItem = index
                },
                selected = checkedItem == index,
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size,
                )
            ) {
                Text(text = option)
            }
        }
    }
}

@Composable
fun MultipleChoicesSegmentedButton() {
    val checkedItems = remember { mutableStateListOf<Int>() }
    val options = listOf("Option 1", "Option 2", "Option 3")
    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, option ->
            SegmentedButton(
                onCheckedChange = {
                    if (index in checkedItems) {
                        checkedItems.remove(index)
                    } else {
                        checkedItems.add(index)
                    }
                },
                checked = index in checkedItems,
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size,
                )
            ) {
                Text(text = option)
            }
        }
    }
}

@Composable
fun FAB() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LargeFloatingActionButton(
            onClick = {},
            containerColor = Color.Blue,
            contentColor = Color.White,
            shape = CircleShape,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }

        FloatingActionButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }

        SmallFloatingActionButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }

        ExtendedFloatingActionButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
            Text(text = "FAB")
        }
    }
}

@Composable
fun CheckboxExample() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Checkbox")
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Composable
fun SwitchExample() {
    var isChecked by remember { mutableStateOf(false) }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text("Switch")
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Composable
fun RadioButtonGroupExample() {
    var selectedOption by remember { mutableStateOf("Option 1") }
    val options = listOf( "Option 1", "Option 2", "Option 3")
    Column {
        options.forEach { option ->
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = {selectedOption = option}
                )
                Text(option)
            }
        }
    }
}

@Composable
private fun CardExample() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Favorite Item")
        }
    }
}

@Composable
fun SliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Slider Value: ${sliderPosition.toInt()}")
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f
        )
    }
}

@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            isValid = it.length >= 6
        },
        label = { Text("Password") },
        isError = !isValid,
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            if (!isValid) Icon(Icons.Default.Close, contentDescription = "Error")
        }
    )
    if (!isValid) {
        Text("Password must be at least 6 characters", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    Buttons()
}