package cesarb98.com.github.t_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cesarb98.com.github.t_space.model.EmpresaViagemRepository
import cesarb98.com.github.t_space.screens.EmpresaScreen
import cesarb98.com.github.t_space.screens.MenuScreen
import cesarb98.com.github.t_space.screens.ViagemScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF020617)
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "menu"
                    ) {

                        composable(route = "menu") {
                            MenuScreen(navController = navController)
                        }

                        composable(
                            route = "empresa/{empresaId}",
                            arguments = listOf(
                                navArgument("empresaId") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val empresaId = backStackEntry.arguments?.getString("empresaId") ?: ""

                            val empresaSelecionada = EmpresaViagemRepository.buscarEmpresaPorId(empresaId)

                            if (empresaSelecionada != null) {
                                EmpresaScreen(
                                    empresa = empresaSelecionada,
                                    navController = navController
                                )
                            }
                        }

                        composable(
                            route = "detalhes/{viagemId}",
                            arguments = listOf(
                                navArgument("viagemId") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val viagemId = backStackEntry.arguments?.getString("viagemId") ?: ""

                            val viagemSelecionada = EmpresaViagemRepository.buscarViagemPorId(viagemId)

                            if (viagemSelecionada != null) {
                                ViagemScreen(
                                    viagem = viagemSelecionada,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

