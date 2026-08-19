package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.ResetButton
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.ScoreBoardTitle
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.TeamArea
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamA
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamAButton
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamB
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamBButton

@Composable
fun TrucoScoreBoardScreen() {
    var scoreA by rememberSaveable { mutableIntStateOf(0) }
    var scoreB by rememberSaveable { mutableIntStateOf(0) }

    Column( modifier = Modifier.fillMaxSize() ) {
        ScoreBoardTitle( text = "Truco Score Board" )

        TeamArea(
            modifier = Modifier.weight( 1f ),
            backgroundColor = ColorTeamA,
            buttonColor = ColorTeamAButton,
            label = "Team A",
            score = scoreA,
            onPlusOne = { scoreA += 1 },
            onPlusThree = { scoreA += 3 }
        )

        TeamArea(
            modifier = Modifier.weight(1f),
            backgroundColor = ColorTeamB,
            buttonColor = ColorTeamBButton,
            label = "Team B",
            score = scoreB,
            onPlusOne = { scoreB += 1 },
            onPlusThree = { scoreB += 3 }
        )

        ResetButton (
            onClick = {
                scoreA = 0
                scoreB = 0
            }
        )
    }
}

@Preview(showBackground = true, heightDp = 700)
@Composable
private fun TrucoScoreBoardScreenPreview() {
    MaterialTheme {
        TrucoScoreBoardScreen()
    }
}