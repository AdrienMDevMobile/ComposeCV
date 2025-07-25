package com.adrienmandroid.composecv.feature.skills.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toAnnotatedString
import com.adrienmandroid.composecv.feature.skills.ui.R
import com.adrienmandroid.composecv.feature.skills.ui.preview.SkillsPreviewParameterDataProvider
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill

@Composable
fun SkillCard(skill: Skill) {

    val isTextVisible = MutableLiveData(false)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(25.dp)
            )
            .padding(10.dp, 10.dp), backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(text = skill.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.width(10.dp))

            Spacer(modifier = Modifier.height(10.dp))

            skill.targetValue?.let {
                SkillLinearProgressIndicator(targetValue = it)
            }
            skill.subSkills?.let { subskills ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = subskills.first,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = subskills.second,
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            SkillText(isTextVisible, skill.explanation)
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier
                    .size(40.dp, 20.dp)
                    .align(CenterHorizontally),
                contentPadding = PaddingValues(0.dp),
                colors = buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                onClick = {
                    isTextVisible.value = when (isTextVisible.value) {
                        true -> false
                        else -> true
                    }
                }) {
                ShowMore(isVisible = isTextVisible)
            }

        }
    }
}

@Composable
fun ShowMore(isVisible: LiveData<Boolean>) {
    val visible by isVisible.observeAsState(false)

    if (!visible) {
        Image(
            painter = painterResource(id = R.drawable.ic_skill_arrow_down),
            contentDescription = "Show more",
            modifier = Modifier.size(20.dp)
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_skill_arrow_up),
            contentDescription = "Show more",
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun SkillText(isVisible: LiveData<Boolean>, text: String) {
    val textAnnotated = text.toAnnotatedString()

    val visible by isVisible.observeAsState(false)
    //https://stackoverflow.com/questions/66560404/jetpack-compose-unresolved-reference-observeasstate
    if (visible) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = textAnnotated)
    }
}

@PreviewLightDark
@Composable
fun SkillCardPreview(
    @PreviewParameter(SkillsPreviewParameterDataProvider::class) skill: com.adrienmandroid.composecv.feature.skills.domain.model.Skill
) {
    ComposeCVTheme {
        SkillCard(skill)
    }
}
