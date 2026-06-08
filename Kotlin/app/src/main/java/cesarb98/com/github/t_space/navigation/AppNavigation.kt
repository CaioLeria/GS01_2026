package cesarb98.com.github.t_space.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cesarb98.com.github.t_space.R
import cesarb98.com.github.t_space.model.EmpresaViagemRepository
import cesarb98.com.github.t_space.screens.EmpresaScreen
import cesarb98.com.github.t_space.screens.MenuScreen
import cesarb98.com.github.t_space.screens.StartScreen
import cesarb98.com.github.t_space.screens.ViagemScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rotaAtual = navBackStackEntry?.destination?.route

    Box(modifier = Modifier.fillMaxSize()) {

        if (rotaAtual != Routes.START.route) {
            Image(
                painter = painterResource(id = R.drawable.fundo_espaco),
                contentDescription = "Fundo do Espaço Global",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.3f
            )
        }

        NavHost(
            navController = navController,
            startDestination = Routes.START.route
        ) {

            composable(route = Routes.START.route) {
                StartScreen(navController = navController)
            }

            composable(route = Routes.MENU.route) {
                MenuScreen(navController = navController)
            }

            composable(
                route = Routes.EMPRESA.route,
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
                route = Routes.DETALHES.route,
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