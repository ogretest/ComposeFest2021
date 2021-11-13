package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.clickable
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme

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
