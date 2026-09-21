package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AndroidGreen
import com.example.myapplication.ui.theme.Navy
import com.example.myapplication.ui.theme.ScreenBackground

@Composable
fun AttendanceCounter() {

    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        // Top bar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {
            Text(
                text = "Attendance Counter",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "Task 8 - remember & state",
                color = AndroidGreen
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "STUDENTS PRESENT",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Number card
            Card(
                modifier = Modifier.size(
                    width = 180.dp,
                    height = 110.dp
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = count.toString(),
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Minus and Plus
            Row {

                Button(
                    onClick = {
                        if (count > 0) {
                            count--
                        }
                    },
                    enabled = count > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    )
                ) {
                    Text(
                        text = "-",
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {
                        count++
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AndroidGreen
                    )
                ) {
                    Text(
                        text = "+",
                        fontSize = 24.sp,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reset
            Button(
                onClick = {
                    count = 0
                },
                enabled = count > 0
            ) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = if (count == 0) {
                    "Tap + to check a student in."
                } else {
                    "$count of 30 students checked in."
                },
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}