package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp),
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ImageList(count: Int, scrollState: LazyListState) {
    LazyColumn(state = scrollState) {
        items(count) {
            ImageListItem(it)
        }
    }
}

@Composable
private fun ScrollerHeader(
    coroutineScope: CoroutineScope,
    scrollState: LazyListState,
    listSize: Int
) {
    Row {
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(0)
            }
        }) {
            Text("Scroll to the top")
        }
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(listSize - 1)
            }
        }) {
            Text("Scroll to the end")
        }
    }
}


@Composable
fun ScrollingList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        ScrollerHeader(coroutineScope, scrollState, listSize)
        ImageList(listSize, scrollState)
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollingListPreview() {
    Week0201layoutsTheme {
        Surface(color = MaterialTheme.colors.surface) {
            ScrollingList()
        }
    }
}