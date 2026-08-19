package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.ColorTeamAButton

@Composable
fun ScoreButton(text: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = text, color = Color.White, fontSize = 30.sp)
    }
}

@Composable
fun ScoreButtons(
    buttonColor: Color,
    onPlusOne: () -> Unit,
    onPlusThree: () -> Unit
) {
    Row(
        modifier = Modifier.padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ScoreButton( text = "+ 1", color = buttonColor, onClick = onPlusOne )
        ScoreButton( text = "+ 3", color = buttonColor, onClick = onPlusThree )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScoreButtonPreview() {
    ScoreButton(text = "+1", color = ColorTeamAButton, onClick = {})
}

@Preview(showBackground = true)
@Composable
private fun ScoreButtonsPreview() {
    ScoreButtons(
        buttonColor = ColorTeamAButton,
        onPlusOne = {},
        onPlusThree = {}
    )
}