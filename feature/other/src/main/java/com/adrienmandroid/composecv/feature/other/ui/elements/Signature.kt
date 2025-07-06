package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme

//Non optimal. il faudrait donner à la fonction une taille et ad
@Composable
fun Signature(color: Color) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier.size(72.dp, 90.dp)
        ) {

            //save()
            clipPath(
                Path().apply {
                    addOval(
                        Rect(
                            Offset(((size.width / 2) - 78), 14f),
                            Size(156f, 165f)
                        )
                    )
                },
                ClipOp.Difference,
            ) {
                drawOval(
                    topLeft = Offset(((size.width / 2) - 98), 0f),
                    size = Size(196f, 245f),
                    color = color
                )


            }
            drawOval(
                topLeft = Offset(((size.width / 2) - 49), 5f),
                size = Size(98f, 49f),
                color = color
            )
        }
    }
}


@Preview
@Composable
fun PreviewSignature() {
    ComposeCVTheme {
        Signature(Color.Black)
    }
}