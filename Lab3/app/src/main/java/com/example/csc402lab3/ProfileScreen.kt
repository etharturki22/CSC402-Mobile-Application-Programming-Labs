package com.example.csc402lab3

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.csc402lab3.ui.theme.CSC402Lab3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,

        topBar = {
            TopAppBar(
                title = {
                    Text("My Profile")
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit profile"
                )
            }
        }
    ) { innerPadding ->

        StudentCard(
            student = Student(
                name = "Ethar Alujaiyan",
                program = "Computer Science",
                gpa = "4.42",
                email = "Ethar@gmail.com",
                city = "Qatif"
            ),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    CSC402Lab3Theme {
        ProfileScreen()
    }
}