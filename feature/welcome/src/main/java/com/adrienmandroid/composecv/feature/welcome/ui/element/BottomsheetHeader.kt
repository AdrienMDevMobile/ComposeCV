package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.roundedTopEndSquare
import com.adrienmandroid.composecv.core.test.R as TestingR

fun LazyListScope.bottomsheetHeader(
    verticalArrangement: Dp = 32.dp,
    content: (@Composable () -> Unit)? = null,
) {
    item {
        Column(
            modifier = Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.spacedBy(verticalArrangement.unaryMinus())
        ) {
            content?.let {
                content()
            }
            Spacer(
                modifier = Modifier
                    .height(verticalArrangement)
                    .fillMaxWidth(1f)
                    .background(
                        MaterialTheme.colors.background,
                        roundedTopEndSquare
                    )

            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomSheetHeader() {
    ComposeCVTheme {
        LazyColumn {
            bottomsheetHeader {
                Image(
                    painter = painterResource(TestingR.drawable.img_test),
                    contentDescription = "Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(5.dp)
                        .zIndex(1f)
                        .clip(CircleShape)
                        .border(4.dp, MaterialTheme.colors.background, CircleShape)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewBottomSheetHeaderNull() {
    ComposeCVTheme {
        LazyColumn {
            bottomsheetHeader()
        }
    }
}