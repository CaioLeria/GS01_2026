package cesarb98.com.github.t_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cesarb98.com.github.t_space.navigation.AppNavigation
import cesarb98.com.github.t_space.ui.theme.PretoCosmico
import cesarb98.com.github.t_space.ui.theme.TSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PretoCosmico
                ) {
                    AppNavigation()
                }
            }
        }
    }
}