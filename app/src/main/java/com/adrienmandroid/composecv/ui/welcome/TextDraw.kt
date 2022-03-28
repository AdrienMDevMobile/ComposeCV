package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

class TextDraw(
    private val iconId: Int? = null,
    private val id: Int,
    private val style: TextStyle = TextStyle(),
    private val args: Array<Any> = emptyArray()
) : SimpleDraw {
    @Composable
    override fun Draw() {
        Row(modifier = Modifier.fillMaxWidth()){
            if(iconId != null){
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = iconId.toString(),
                    modifier = Modifier.size(24.dp, 24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(text = stringResource(id, *args), style = style)
        }

    }

}