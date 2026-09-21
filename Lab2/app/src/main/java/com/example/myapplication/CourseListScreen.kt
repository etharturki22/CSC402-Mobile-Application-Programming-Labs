package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AndroidGreen
import com.example.myapplication.ui.theme.Navy
import com.example.myapplication.ui.theme.ScreenBackground

// أضيفي هذا فقط إذا Course غير موجودة داخل ملفات المشروع
data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen() {

    val courses = remember {
        listOf(
            Course(
                "CSC 402",
                "Mobile Application Programming",
                3,
                "Mon / Wed"
            ),
            Course(
                "CSC 311",
                "Database Systems",
                4,
                "Sun / Tue"
            ),
            Course(
                "CSC 340",
                "Operating Systems",
                3,
                "Mon / Wed"
            ),
            Course(
                "MATH 202",
                "Discrete Mathematics",
                3,
                "Sun / Thu"
            ),
            Course(
                "ENG 214",
                "Technical Writing",
                2,
                "Tue"
            ),
            Course(
                "PHYS 105",
                "General Physics II",
                4,
                "Sun / Tue"
            ),
            Course(
                "ISLM 101",
                "Islamic Culture",
                2,
                "Thu"
            )
        )
    }

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
                text = "Course List",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "Task 10 - LazyColumn",
                color = AndroidGreen
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Green bar
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(95.dp)
                    .background(AndroidGreen)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                // Course information
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = course.code,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = course.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Navy
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = course.days,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }

                // Credits chip
                Box(
                    modifier = Modifier
                        .background(
                            AndroidGreen.copy(alpha = 0.2f),
                            RoundedCornerShape(50.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 6.dp
                        )
                ) {
                    Text(
                        text = "${course.credits} cr",
                        color = Navy,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}