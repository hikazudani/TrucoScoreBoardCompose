package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.ResetButton
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.ScoreBoardTitle
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components.TeamArea
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamA
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamAButton
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamB
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamBButton
import kotlin.math.min

private const val TARGET_SCORE = 12
private const val MAO_DE_ONZE_SCORE = 11

@Composable
fun TrucoScoreBoardScreen() {
    val context = LocalContext.current
    var scoreA by rememberSaveable { mutableIntStateOf(0) }
    var scoreB by rememberSaveable { mutableIntStateOf(0) }

    val isGameOver = scoreA >= TARGET_SCORE || scoreB >= TARGET_SCORE
    val isMAoDeOnze = scoreA == MAO_DE_ONZE_SCORE || scoreB == MAO_DE_ONZE_SCORE

    fun addPoints(current: Int, increment: Int, teamLabel: String): Int {
        val updated = min(current + increment, TARGET_SCORE)

        when ( updated ) {
            TARGET_SCORE -> Toast.makeText(
                context, "The Winner is: $teamLabel", Toast.LENGTH_LONG
            ).show()

            MAO_DE_ONZE_SCORE -> Toast.makeText(
                context, "Mão de Onze: $teamLabel", Toast.LENGTH_LONG
            ).show()
        }
        return updated
    }

    Column( modifier = Modifier.fillMaxSize() ) {
        ScoreBoardTitle( text = "Truco Score Board" )

        TeamArea(
            modifier = Modifier.weight( 1f ),
            backgroundColor = ColorTeamA,
            buttonColor = ColorTeamAButton,
            label = "Team A",
            score = scoreA,
            isGameOver = isGameOver,
            showPlusThree = !isMAoDeOnze,
            onPlusOne = { scoreA = addPoints(scoreA, 1, "Team A") },
            onPlusThree = { scoreA = addPoints(scoreA, 3, "Team A") }
        )

        TeamArea(
            modifier = Modifier.weight(1f),
            backgroundColor = ColorTeamB,
            buttonColor = ColorTeamBButton,
            label = "Team B",
            score = scoreB,
            isGameOver = isGameOver,
            showPlusThree = !isMAoDeOnze,
            onPlusOne = { scoreB = addPoints(scoreB, 1, "Team B") },
            onPlusThree = { scoreB = addPoints(scoreB, 3, "Team B") }
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