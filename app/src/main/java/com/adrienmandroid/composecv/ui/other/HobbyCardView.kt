package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Hobby
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

val hobby_width = 200.dp

@Composable
fun HobbyCardView(hobby: Hobby) {
    Column(modifier = Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(hobby.picture),
            contentDescription = stringResource(id = hobby.name),
            modifier = Modifier
                .size(hobby_width, hobby_width)
        )
        Text(
            text = stringResource(hobby.name),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = stringResource(hobby.category),
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
@Preview
fun previewHobbyCardView() {
    ComposeCVTheme() {
        HobbyCardView(
            hobby = Hobby(
                name = R.string.hobby_LoL,
                R.drawable.hobby_westcoastswing,
                R.string.hobby_category_competition
            )
        )
    }
}