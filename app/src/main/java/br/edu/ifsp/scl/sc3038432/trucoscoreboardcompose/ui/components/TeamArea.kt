package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamA
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamAButton

@Composable
fun TeamArea(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    buttonColor: Color,
    label: String,
    score: Int,
    onPlusOne: () -> Unit,
    onPlusThree: () -> Unit,
    isGameOver: Boolean = false,
    showPlusThree: Boolean = true
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TeamLabel( text = label )
        TeamScore(score = score)
        ScoreButtons(
            buttonColor = buttonColor,
            onPlusOne = onPlusOne,
            onPlusThree = onPlusThree,
            enabled = !isGameOver,
            showPlusThree = showPlusThree
        )
    }
}

@Preview(showBackground = true, heightDp = 300)
@Composable
private fun TeamAreaPreview() {
    TeamArea(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        backgroundColor = ColorTeamA,
        buttonColor = ColorTeamAButton,
        label = "Team A",
        score = 5,
        onPlusOne = {},
        onPlusThree = {},
    )
}