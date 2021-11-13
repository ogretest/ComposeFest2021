package io.github.ogretest.composefest2021.week0201layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week0201layoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week0201layoutsTheme {
        Greeting("Android")
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = {  /* PASS */ })
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // TODO Images
        }

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotographerCardPreview() {
    Week0201layoutsTheme {
        PhotographerCard()
    }
}

@Composable
fun C4SlotAPIsButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun C4SlotAPIsPreview() {
    var count by remember { mutableStateOf(0) }
    Week0201layoutsTheme {
        C4SlotAPIsButton(
            onClick = { count += 1 }
        ) {
            Text("C4SlotAPIsButton $count")
        }
    }
}

@Composable
fun LayoutsCodeLab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* PASS*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsCodeLabPreview() {
    Week0201layoutsTheme {
        LayoutsCodeLab()
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it", color = MaterialTheme.colors.primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    Week0201layoutsTheme {
        Surface(color = MaterialTheme.colors.surface) {
            SimpleList()
        }
    }
}
