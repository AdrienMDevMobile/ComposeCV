package com.adrienmandroid.composecv.ui.skill

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


//Adapté de https://betterprogramming.pub/gridview-and-lazycolum-integration-with-jetpack-compose-e90849aeb6d3
@Composable
fun <T> GridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit, //Passer une fonction composable en paramètre permet d'adapter la fonction dans plusieurs situations.
) {
    val size = data.count()
    val rows = if (size == 0) 0 else 1 + (size - 1) / columnCount
    /*Pourquoi 1 + (size -1 ) : car cela permet d'arrondir au superieur alors que les int sont arrondis à l'inferieur
    Les autres solutions pour arronsdir ne sont pas plus propres que cettes solution : https://www.baeldung.com/kotlin/round-numbers*/
    Column(modifier = Modifier.wrapContentSize()) {
        for (rowIndex in 0..rows) {
            Row(
                horizontalArrangement = horizontalArrangement,
                modifier = modifier
            ) { //Ci dessous : une colone
                for (columnIndex in 0 until columnCount) { //Nous parcourons la liste de manière non linéaire
                    val itemIndex = rowIndex * columnCount + columnIndex
                    if (itemIndex < size) {
                        Box(
                            modifier = Modifier.weight(1F, fill = true),
                            propagateMinConstraints = true
                        ) {
                            itemContent(data[itemIndex])
                        }
                    } else { //Cases vide à la fin du tableau
                        Spacer(Modifier.weight(1F, fill = true))
                    }
                }
            }
        }
    }
}