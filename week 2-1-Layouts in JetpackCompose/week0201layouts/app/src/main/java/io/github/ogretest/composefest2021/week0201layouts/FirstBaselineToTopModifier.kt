package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }
)

@Preview(showBackground = true)
@Composable
fun TextWithPaddingToBaselinePreview() {
    Week0201layoutsTheme {
        Column(modifier = Modifier
            .background(Color.Magenta)
            .padding(8.dp)) {
            Text("Hi there", Modifier.firstBaselineToTop(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextWithNormalPaddingPreview() {
    Week0201layoutsTheme {
        Column(modifier = Modifier
            .background(Color.Magenta)
            .padding(8.dp)) {
            Text("Hi there", Modifier.padding(top = 32.dp))
        }
    }
}
