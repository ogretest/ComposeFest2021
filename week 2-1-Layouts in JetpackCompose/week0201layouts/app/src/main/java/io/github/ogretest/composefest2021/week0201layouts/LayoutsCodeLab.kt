package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme


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
    MyOwnColumn(modifier = modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsCodeLabPreview() {
    Week0201layoutsTheme {
        LayoutsCodeLab()
    }
}
