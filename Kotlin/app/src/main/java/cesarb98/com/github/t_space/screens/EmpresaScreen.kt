package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import cesarb98.com.github.t_space.model.Empresa

@Composable
fun EmpresaScreen(empresa: Empresa, navController: NavController) {
    val spaceBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0D1E), Color(0xFF1B1464), Color(0xFF020617))
    )

    Box(modifier = Modifier.fillMaxSize().background(spaceBackground).padding(24.dp)) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = empresa.nome.uppercase(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = Color(0xFF00FFFF),
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Text(text = "Fundada em: ${empresa.fundacao}", fontSize = 14.sp, color = Color.LightGray)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth().background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp)).padding(16.dp)
            ) {
                Text(text = empresa.descricao, color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "ROTAS DESTA COMPANHIA",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )

            empresa.viagensDisponiveis.forEach { viagem ->
                MenuCardButton(
                    titulo = viagem.destino,
                    subtitulo = "Duração da jornada: ${viagem.duracao}",
                    corItem = Color(0xFF00FFFF),
                    textoBotaoPrincipal = "Ver Roteiro",
                    onCliquePrincipal = {
                        navController.navigate("detalhes/${viagem.id}")
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "VOLTAR AO MENU", color = Color(0xFF1B1464), fontWeight = FontWeight.Bold)
            }
        }
    }
}