package io.github.ogretest.composefest2021.week0201layouts

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import io.github.ogretest.composefest2021.week0201layouts.ui.theme.Week0201layoutsTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button(
            onClick = { /* PASS*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })
        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = {/* PASS */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text("Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
    Week0201layoutsTheme {
        ConstraintLayoutContent()
    }
}

@Composable
fun LargeConstraintLayout() {
    ConstraintLayout {
        val text = createRef()
        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
                width = Dimension.preferredWrapContent
            },
            color = MaterialTheme.colors.primary,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LargeConstraintLayoutPreview() {
    Week0201layoutsTheme {
        LargeConstraintLayout()
    }
}

fun decoupledConstraints(margin: Dp) = ConstraintSet {
    val button = createRefFor("button")
    val text = createRefFor("text")

    constrain(button) {
        top.linkTo(parent.top, margin = margin)
    }
    constrain(text) {
        top.linkTo(button.bottom, margin)
    }
}

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 32.dp)
        }
        ConstraintLayout(constraints) {
            Button(
                onClick = { /* PASS */ },
                modifier = Modifier.layoutId("button"),
            ) {
                Text("Button")
            }
            Text(
                "Text",
                modifier = Modifier.layoutId("text")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DecoupledConstraintLayoutPreview() {
    Week0201layoutsTheme {
        DecoupledConstraintLayout()
    }
}
