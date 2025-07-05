package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.feature.welcome.viewmodel.WelcomeViewModel

@Composable
fun TextDraw(
    @DrawableRes iconId: Int?,
    value: String,
    style: TextStyle,
    onClick: WelcomeViewModel.ClickAction?,
    welcomeViewModel: WelcomeViewModel,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        if (iconId != null) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = iconId.toString(),
                modifier = Modifier.size(24.dp, 24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        if (onClick != null) {
            //Ca c'est le reste
            DrawClickableText(
                text = value,
                clickable = onClick,
                style = style,
                welcomeViewModel = welcomeViewModel
            )
        } else {
            //Ici c'est paris
            Text(text = value, style = style)
        }
    }

}

@Composable
private fun DrawClickableText(
    text: String,
    clickable: WelcomeViewModel.ClickAction,
    style: TextStyle,
    welcomeViewModel: WelcomeViewModel,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.clickable {
            welcomeViewModel.onClick(clickable)
        },
        text = with(AnnotatedString.Builder(text)) {
            toAnnotatedString()
        },
        style = style.copy(textDecoration = TextDecoration.Underline,
            color = style.color.takeOrElse {
                LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
            }
        ),
    )
}