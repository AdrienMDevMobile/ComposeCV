package com.adrienmandroid.composecv.ui.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.ExpDates
import com.adrienmandroid.composecv.data.Link
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun ExperienceHeader(logo: Int, name: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.CenterStart,
    ) {

        Image(
            painter = painterResource(logo),
            contentDescription = name,
            modifier = Modifier.height(30.dp)

        )
        Row(){
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = name, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
        }

    }

}

@Composable
fun ExpAdditionalInfo(dates: ExpDates, link: Link?) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(dates.begin.toString())
        Text(dates.end.toString())
        if (link != null) {
            Text(link.text)
        }
    }
}

@Composable
fun ExperienceInfoListItem(information: String) {
    Text(information)
}

@Preview
@Composable
fun previewExperienceHeader(){
    ComposeCVTheme() {
        ExperienceHeader(logo = R.drawable.home, name = "Test")
    }
}