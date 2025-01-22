package com.example.bmiprojectvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmiprojectvm.ui.theme.BMIProjectVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIProjectVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BmiScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    viewModel: BmiViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = viewModel.heightInput,
            onValueChange = viewModel::onHeightChange,
            label = { Text(stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = viewModel.weightInput,
            onValueChange = viewModel::onWeightChange,
            label = { Text(stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = stringResource(R.string.body_mass_index_is) + " ${viewModel.bmi}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BmiScreenPreview() {
    val previewViewModel = BmiViewModel().apply {
        onHeightChange("1.75") // Mock height input
        onWeightChange("70")  // Mock weight input
    }
    BMIProjectVMTheme {
        BmiScreen(viewModel = previewViewModel)
    }
}