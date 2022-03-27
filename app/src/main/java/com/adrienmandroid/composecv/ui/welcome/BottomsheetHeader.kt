package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.R

fun LazyListScope.BottomsheetHeader() {
    item {
        Column(
            modifier = Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.spacedBy((-16).dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = "Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .zIndex(1f)
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth(1f)
                    .background(Color.Blue)
            )
        }
    }
}