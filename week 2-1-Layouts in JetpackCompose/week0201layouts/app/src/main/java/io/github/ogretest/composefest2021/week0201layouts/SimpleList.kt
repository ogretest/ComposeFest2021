package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme

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
