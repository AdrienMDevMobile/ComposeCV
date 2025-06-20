package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.core.test.R as TestingR

val hobby_width = 200.dp

@Composable
fun HobbyCardView(hobby: Hobby) {
    Column(
        modifier = Modifier
            .size(width = hobby_width, height = 250.dp)
            .padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(hobby.picture),
            contentDescription = stringResource(id = hobby.name),
            modifier = Modifier
                .size(hobby_width, hobby_width)
        )
        Text(
            text = stringResource(hobby.name),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = stringResource(hobby.category),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
@Preview
fun PreviewHobbyCardView() {
    ComposeCVTheme {
        HobbyCardView(
            hobby = Hobby(
                name = TestingR.string.test_1_word,
                TestingR.drawable.ic_test,
                TestingR.string.test_short_text_1_line
            )
        )
    }
}