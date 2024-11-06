package com.example.composecomponents.ui

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponents.R
import java.util.Calendar

@Composable
fun TextFields() {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        item { Default() }
        item { Outlined() }
        item { TextFieldWithLeadingIcon() }
        item { TextFieldWithTrailingIcon() }
        item { TextFieldWithLeadingIconAndTrailingIcon() }
        item { Prefix() }
        item { Suffix() }
        item { SupportingText() }
        item { PasswordTextField() }
        item { DatePickerTextField(context = LocalContext.current) }
    }
}

@Composable
fun Default() {
    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Label") },
        placeholder = { Text("Placeholder") }
    )
}

@Composable
private fun Outlined() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Outlined Label") },
        placeholder = { Text("Placeholder") },
        enabled = true,
        readOnly = false,
        textStyle = TextStyle(color = Color.Blue),
        isError = false,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onSearch = { },
            onNext = { }
        ),
        singleLine = false,
        maxLines = 1,
        minLines = 1,
        colors = OutlinedTextFieldDefaults.colors()
    )
}

@Composable
fun TextFieldWithLeadingIcon() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("LeadingIcon") },
        placeholder = { Text("Placeholder") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
        }
    )
}

@Composable
fun TextFieldWithTrailingIcon() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("TrailingIcon") },
        placeholder = { Text("Placeholder") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }
    )
}

@Composable
fun TextFieldWithLeadingIconAndTrailingIcon() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("LeadingIcon") },
        placeholder = { Text("Placeholder") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close"
            )
        }
    )
}

@Composable
fun Prefix() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        prefix = {
            Text(text = "https://")
        },
    )
}

@Composable
fun Suffix() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        suffix = {
            Text(text = "@gmail.com")
        },
    )
}

@Composable
fun SupportingText() {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Supporting Text") },
        isError = true,
        supportingText = {
            Text(
                text = "*Required",
                color = Color.Red
            )
        }
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }

    val icon =
        painterResource(if (visibility) R.drawable.ic_visibilty else R.drawable.ic_visibility_off)

    val visuualTransformation =
        if (visibility) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        trailingIcon = {
            IconButton(onClick = {
                visibility = !visibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility",
                )
            }
        },
        visualTransformation = visuualTransformation
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerTextField(context: Context) {
    var selectedDate by remember { mutableStateOf("") }

    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        },
        Calendar.getInstance().get(Calendar.YEAR),
        Calendar.getInstance().get(Calendar.MONTH),
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    )
    OutlinedTextField(
        value = selectedDate,
        onValueChange = {},
        label = { Text("Select Date") },
        readOnly = false,
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Date Picker", Modifier.clickable {
                datePickerDialog.show()
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    TextFields()
}