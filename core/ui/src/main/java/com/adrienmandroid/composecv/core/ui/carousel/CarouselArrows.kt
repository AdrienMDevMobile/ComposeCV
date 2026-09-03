package com.adrienmandroid.composecv.core.ui.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.R
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import kotlinx.coroutines.launch

@Composable
fun BoxScope.CarouselAccessibilityArrows(pagerState: PagerState){
    val coroutineScope = rememberCoroutineScope()

    CarouselArrows(
        pagerState,
        onClick = { forward ->
            coroutineScope.launch {
                if (forward) {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                } else {
                    pagerState.scrollToPage(pagerState.currentPage - 1)
                }
            }

        })
}

@Composable
private fun BoxScope.CarouselArrows(
    pagerState: PagerState,
    onClick: (Boolean) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.matchParentSize()
    ) {
        if (pagerState.canScrollBackward) {
            CarrousselArrows(forward = false, onClick)
        } else {
            PlaceHolderForSpacer()
        }

        if (pagerState.canScrollForward) {
            CarrousselArrows(forward = true, onClick)
        } else {
            PlaceHolderForSpacer()
        }
    }
}

@Composable
fun CarrousselArrows(
    forward: Boolean,
    onClick: (Boolean) -> Unit
) {
    Button(
        onClick = {
            onClick(forward)
        },
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(
                if (forward)
                    R.drawable.chevron_forward
                else R.drawable.chevron_backward
            ),
            contentDescription = "Next",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun PlaceHolderForSpacer() {
    Box {}
}

@Composable
@Preview
fun PreviewCarrouselArrowsStartElement() {
    val elements = listOf("1", "2", "3")
    val pagerState = PagerState {
        elements.size
    }
    ComposeCVTheme {
        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()) {
            HorizontalPager(state = pagerState) { }
            CarouselArrows(pagerState, {})
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewCarrousselArrowsMiddleElement() {
    val elements = listOf(1, 2, 3)
    val pagerState = PagerState(1) { elements.size }
    ComposeCVTheme {
        Box(modifier = Modifier.height(200.dp)) {
            HorizontalPager(state = pagerState) { }
            CarouselArrows(pagerState, {})
        }
    }
}

@Composable
@Preview
fun PreviewCarrousselArrowsLastElement() {
    val elements = listOf(1, 2, 3)
    val pagerState = PagerState(elements.lastIndex) { elements.size }
    ComposeCVTheme {
        Box(modifier = Modifier.height(200.dp)) {
            HorizontalPager(state = pagerState) { }
            CarouselArrows(pagerState, {})
        }
    }
}

@Composable
@Preview
fun PreviewCarrousselArrowsOneElement() {
    val elements = listOf(1)
    val pagerState = PagerState(1) { elements.size }
    ComposeCVTheme {
        Box(modifier = Modifier.height(200.dp)) {
            HorizontalPager(state = pagerState) { }
            CarouselArrows(pagerState, {})
        }
    }
}