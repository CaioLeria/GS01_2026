package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.model.EmpresaViagemRepository

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    val spaceBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0D1E), Color(0xFF1B1464), Color(0xFF020617))
    )
    val neonCyan = Color(0xFF00FFFF)
    val glassWhite = Color.White.copy(alpha = 0.1f)

    Box(modifier = modifier.fillMaxSize().background(spaceBackground)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "VIAGENS ESPACIAIS",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth().background(glassWhite, RoundedCornerShape(16.dp)).border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(16.dp)).padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = neonCyan, modifier = Modifier.size(44.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = "Viagem X", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = neonCyan)
                        Text(text = "Visao panoramica de cima da terra", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "PRÓXIMOS LANÇAMENTOS",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )

            val empresas = EmpresaViagemRepository.listaDeEmpresas

            empresas.forEach { empresa ->
                empresa.viagensDisponiveis.forEach { viagem ->
                    MenuCardButton(
                        titulo = viagem.destino,
                        subtitulo = "Operado por: ${empresa.nome} | ${viagem.duracao}",
                        corItem = Color(0xFFBD00FF),
                        textoBotaoPrincipal = "Ver Viagem",
                        onCliquePrincipal = {
                            navController.navigate("detalhes/${viagem.id}")
                        },
                        textoBotaoSecundario = "Ver Empresa",
                        onCliqueSecundario = {
                            navController.navigate("empresa/${empresa.id}")
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            MenuCardButton(
                titulo = "Sair",
                subtitulo = "Voltar ao inicio",
                icone = Icons.Default.ExitToApp,
                corItem = Color(0xFFED145B),
                textoBotaoPrincipal = "Sair",
                onCliquePrincipal = { navController.navigate("login") }
            )
        }
    }
}