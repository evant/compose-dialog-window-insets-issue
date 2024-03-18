package me.tatarka.composedialogwindowinsetsissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import me.tatarka.composedialogwindowinsetsissue.ui.theme.ComposeDialogWindowInsetsIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ComposeDialogWindowInsetsIssueTheme {
                var showFullPageDialog by remember { mutableStateOf(false) }
                Surface(modifier = Modifier.windowInsetsPadding(WindowInsets.safeContent)) {
                    Button(onClick = { showFullPageDialog = true }) {
                        Text("Open dialog")
                    }
                }
                if (showFullPageDialog) {
                    FullPageDialog(onDismissRequest = { showFullPageDialog = false })
                }
            }
        }
    }
}

@Composable
fun FullPageDialog(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    // this is always 0
                    .windowInsetsPadding(WindowInsets.systemBars)
            ) {
                Text("full-page dialog")
            }
        }
    }
}