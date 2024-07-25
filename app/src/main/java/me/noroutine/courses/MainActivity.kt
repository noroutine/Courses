package me.noroutine.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.noroutine.courses.model.CourseTopic
import me.noroutine.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
            }
        }
    }
}

@Composable
fun CourseTopicCard(courseTopic: CourseTopic, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.height(68.dp)
    ) {
        Row {
            Image(
                painter = painterResource(courseTopic.topicIconId),
                contentDescription = stringResource(courseTopic.topicNameId),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight()
            )
            Column(
                modifier = Modifier.padding(top = 16.dp, bottom = 0.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(courseTopic.topicNameId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = courseTopic.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun CourseTopicCardPreview() {
    CoursesTheme {
        CourseTopicCard(CourseTopic(R.string.photography, 321, R.drawable.photography))
    }
}