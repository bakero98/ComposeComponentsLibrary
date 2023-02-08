package com.example.composecomponentsplayground.ui.components.button

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composecomponentsplayground.ui.theme.Shapes
import com.example.composecomponentsplayground.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonWithCircularProgressIndicator(
    @DrawableRes icon: Int = R.drawable.icon_android,
    @StringRes text: Int = R.string.sign_up_with_android,
    @StringRes loadingText: Int = R.string.logging_in,
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    borderWidth: Dp = 1.dp,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressColor: Color = MaterialTheme.colors.secondary,
    onClick: (() -> Unit) ?= null
) {

    var clicked by remember { mutableStateOf(false ) }

    Surface(
        onClick = { clicked = !clicked },
        shape = shape,
        border = BorderStroke(width = borderWidth, color = borderColor ),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    bottom = 12.dp,
                    start = 12.dp,
                    end = 16.dp,
                )
                .animateContentSize(
                    tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .height(30.dp),
                painter = painterResource(id = icon),
                contentDescription = "Button Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(
                if(clicked) loadingText else text
            ))
            if(clicked) {
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 3.dp,
                    color = progressColor
                )
                onClick?.let { it() }
            }
        }
    }
}

@Preview
@Composable
fun ButtonWithCircularProgressIndicatorPreview() {
    ButtonWithCircularProgressIndicator()
}
