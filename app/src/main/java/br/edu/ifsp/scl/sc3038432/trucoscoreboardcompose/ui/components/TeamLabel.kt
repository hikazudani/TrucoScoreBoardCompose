package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TeamLabel( text: String ) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
private fun TeamLabelPreview() {
    TeamLabel( text = "Team A" )
}