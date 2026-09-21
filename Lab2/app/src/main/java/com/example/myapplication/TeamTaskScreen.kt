package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AndroidGreen
import com.example.myapplication.ui.theme.Navy
import com.example.myapplication.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TeamTaskTracker() {

    val tasks = remember {
        mutableStateListOf(
            TeamTask(
                1,
                "Create GitHub repository",
                "Fatimah",
                true
            ),
            TeamTask(
                2,
                "Write project proposal",
                "Omar",
                true
            ),
            TeamTask(
                3,
                "Design the login screen",
                "Noura",
                false
            ),
            TeamTask(
                4,
                "Set up Android Studio",
                "Yousef",
                false
            )
        )
    }

    // Values are calculated from the list
    val doneCount = tasks.count { it.isDone }
    val openCount = tasks.count { !it.isDone }
    val totalCount = tasks.size

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
                text = "Team Task Tracker",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "Task 11 - Challenge",
                color = AndroidGreen
            )
        }

        // Summary strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            SummaryItem(
                value = doneCount.toString(),
                label = "Done"
            )

            SummaryItem(
                value = openCount.toString(),
                label = "Open"
            )

            SummaryItem(
                value = totalCount.toString(),
                label = "Total"
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(
                items = tasks,
                key = { task -> task.id }
            ) { task ->

                TaskRow(
                    task = task,
                    onToggle = {

                        val index = tasks.indexOfFirst {
                            it.id == task.id
                        }

                        if (index != -1) {
                            tasks[index] = task.copy(
                                isDone = !task.isDone
                            )
                        }
                    }
                )
            }
        }

        // Add task button
        Button(
            onClick = {

                val nextId =
                    (tasks.maxOfOrNull { it.id } ?: 0) + 1

                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Ethar"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen
            )
        ) {
            Text(
                text = "Add task",
                color = Navy,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SummaryItem(
    value: String,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Text(
            text = label,
            color = AndroidGreen,
            fontSize = 12.sp
        )
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {

                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    color = if (task.isDone) {
                        Color.Gray
                    } else {
                        Navy
                    },
                    textDecoration = if (task.isDone) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )

                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamTaskTrackerPreview() {
    TeamTaskTracker()
}
