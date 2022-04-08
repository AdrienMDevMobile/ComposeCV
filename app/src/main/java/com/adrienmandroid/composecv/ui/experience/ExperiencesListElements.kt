package com.adrienmandroid.composerandom.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.adrienmandroid.composecv.data.ExpDates
import com.adrienmandroid.composecv.data.Link

@Composable
fun ExperienceHeader(logo: Int, name: String) {
        Image(
            painter = painterResource(logo),
            contentDescription = name
        )
        Text(name)
}

@Composable
fun ExpAdditionalInfo(dates : ExpDates, link : Link?){
    Row(modifier = Modifier.fillMaxWidth()){
        Text(dates.begin.toString())
        Text(dates.end.toString())
        if(link != null){
            Text(link.text)
        }
    }
}

@Composable
fun ExperienceInfoListItem(information : String){
    Text(information)
}