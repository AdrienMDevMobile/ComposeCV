package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.welcome.ui.preview.WelcomePreviewParameterData
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun WelcomeBottomSheet(
    contentCovered: @Composable () -> Unit,
    welcomeBodyElements: List<WelcomeBodyElement>,
    onClick: (Clickable) -> Unit,
    modifier: Modifier = Modifier,
    anchoredContent: (@Composable () -> Unit)? = null,
) {
    Box(modifier = modifier) {
        contentCovered()
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            bottomsheetHeader(
                content = anchoredContent
            )
            bottomsheetBody(
                welcomeBodyElements = welcomeBodyElements,
                onClick = onClick
            )
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewBottomSheet() {
    val context = LocalContext.current

    ComposeCVTheme {
        WelcomeBottomSheet(
            contentCovered = {
                Image(
                    painter = painterResource(TestingR.drawable.img_test),
                    contentDescription = "Test"
                )
            },
            welcomeBodyElements = WelcomePreviewParameterData(context).welcomeBodyElements,
            onClick = {},
            anchoredContent = {
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
        )
    }
}

