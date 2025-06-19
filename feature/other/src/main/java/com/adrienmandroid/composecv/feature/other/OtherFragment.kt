package com.adrienmandroid.composecv.feature.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.adrienmandroid.composecv.data.impl.QuoteRepositoryImpl
import com.adrienmandroid.composecv.data.impl.StudyRepositoryImpl
import com.adrienmandroid.composecv.feature.other.ui.elements.Gratitudes
import com.adrienmandroid.composecv.feature.other.ui.elements.HobbyRow
import com.adrienmandroid.composecv.feature.other.ui.elements.QuoteCarousel
import com.adrienmandroid.composecv.feature.other.ui.elements.Signature
import com.adrienmandroid.composecv.feature.other.ui.elements.StudyList
import com.adrienmandroid.composecv.feature.other.ui.elements.Version
import com.adrienmandroid.composecv.feature.other.ui.elements.otherSection
import com.adrienmandroid.composecv.feature.other.viewmodel.OtherViewModel
import com.adrienmandroid.composecv.model.Hobby

@Composable
fun OtherFragment(
    //TODO utiliser les viewmodel ici et partout ailleur
    otherViewModel: OtherViewModel
) {
    val hobbies: List<Hobby> by otherViewModel.hobbies.observeAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
    ) {
        otherSection(
            { StudyList(studies = StudyRepositoryImpl().getData()) },
            title = R.string.title_diplomas,
            firstElement = true
        )
        otherSection({ QuoteCarousel(QuoteRepositoryImpl()) }, title = R.string.title_quotes)
        otherSection({ HobbyRow(hobbies) }, title = R.string.title_hobbies)
        otherSection({ Gratitudes() }, title = R.string.title_gratitude)
        otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
        otherSection({ Version() })
    }
}

/*TODO
@Composable
@Preview
fun PreviewOther() {
    ComposeCVTheme {
        OtherFragment()
    }
}*/