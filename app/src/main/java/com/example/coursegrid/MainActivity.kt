package com.example.coursegrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursegrid.data.DataSource
import com.example.coursegrid.model.Topic
import com.example.coursegrid.ui.theme.CourseGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    courseGridApp()
                }
            }
        }
    }
}

@Composable
fun courseGridApp(modifier: Modifier = Modifier) {
    TopicList(topicList = DataSource().loadTopics(), modifier = Modifier)
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(topicList) {
            TopicCard(it)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    courseGridApp()

}

@Composable
fun TopicCard(
    topic: Topic
) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(11.dp))
            .background(Color(0xFFCBC3E3))
            .height(68.dp)
    ) {
        Image(
            modifier = Modifier
                .width(68.dp)
                .fillMaxHeight(),
            painter = painterResource(id = topic.courseImageId),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(id = topic.courseNameId),
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.Black)
                )
                Text(
                    text = topic.amountOfCourses.toString(),
                    style = MaterialTheme.typography.labelMedium
                )

            }


        }
    }
}