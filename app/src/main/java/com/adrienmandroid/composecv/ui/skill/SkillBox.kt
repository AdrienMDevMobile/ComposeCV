package com.adrienmandroid.composecv.ui.skill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@Composable
fun SkillBox(name : String, targetValue : Float, text: String) {

    val isTextVisible = MutableLiveData(false)
    Column(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
        Row(){
            Text(name)
            Button(colors = buttonColors(backgroundColor = MaterialTheme.colors.primary),
                onClick =  { isTextVisible.value = when(isTextVisible.value){true -> false else -> true } }) {
                //https://developer.android.com/jetpack/compose/state#viewmodel-state
                //Gerer l'affichage de l'élement qui suivra ici ???
                Text(text = ">")
            }
        }
        SkillLinearProgressIndicator(targetValue = targetValue)
        SkillText(isTextVisible, text)
    }
}

@Composable
fun SkillText(isVisible : LiveData<Boolean>, text:String){
    val visible by isVisible.observeAsState(false)
    //https://stackoverflow.com/questions/66560404/jetpack-compose-unresolved-reference-observeasstate
    if(visible){
        Text(text)
    }
}
