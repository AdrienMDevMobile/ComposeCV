package com.adrienmandroid.composecv.ui.welcome

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel

@Composable
fun TextDraw(
    @DrawableRes iconId: Int?,
    @StringRes id: Int,
    style: TextStyle,
    args: Array<Any>,
    clickable: ClickViewModel.ClickAction?,
    clickViewModel: ClickViewModel
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        if (iconId != null) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = iconId.toString(),
                modifier = Modifier.size(24.dp, 24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        if (clickable != null) {
            DrawClickable(
                id = id,
                args = args,
                clickable = clickable,
                style = style,
                clickViewModel = clickViewModel
            )
        } else {
            Text(text = stringResource(id, *args), style = style)
        }
    }

}

@Composable
private fun DrawClickable(
    @StringRes id: Int,
    args: Array<Any>,
    clickable: ClickViewModel.ClickAction,
    style: TextStyle,
    clickViewModel: ClickViewModel
) {

    ClickableText(
        text = with(AnnotatedString.Builder(stringResource(id, *args))) {
            toAnnotatedString()
        },
        style = style.copy(textDecoration = TextDecoration.Underline),
        onClick = { clickViewModel.onClick(clickable) }
    )
}