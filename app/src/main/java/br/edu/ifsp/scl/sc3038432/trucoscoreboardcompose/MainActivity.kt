package br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.screen.TrucoScoreBoardScreen
import br.edu.ifsp.scl.sc3038432.trucoscoreboardcompose.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardComposeTheme {
                Surface( modifier = Modifier.fillMaxSize().safeDrawingPadding() ) {
                    TrucoScoreBoardScreen()
                }
            }
        }
    }
}

@Preview
@Composable
private fun TrucoScoreBoardScreenPreview() {
    TrucoScoreBoardComposeTheme {
        Surface(modifier = Modifier.fillMaxSize().safeDrawingPadding()) { TrucoScoreBoardScreen() }
    }
}