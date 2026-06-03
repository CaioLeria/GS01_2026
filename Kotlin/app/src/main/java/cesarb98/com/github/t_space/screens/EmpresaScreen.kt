package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.model.Empresa

@Composable
fun EmpresaScreen(empresa: Empresa, navController: NavController) {
    val corAzulClaro = Color(0xFF00BFFF)
    val azulClaroContorno = Color(0xFF87CEEB)
    val vidroFumeClaro = Color.White.copy(alpha = 0.65f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = empresa.nome.uppercase(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = corAzulClaro,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )

            Text(
                text = "Fundada em: ${empresa.fundacao}",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.6f),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(vidroFumeClaro, RoundedCornerShape(18.dp))
                    .border(1.2.dp, azulClaroContorno.copy(alpha = 0.4f), RoundedCornerShape(18.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = empresa.descricao,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "ROTAS DESTA COMPANHIA",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            empresa.viagensDisponiveis.forEach { viagem ->
                MenuCardButton(
                    titulo = viagem.destino,
                    subtitulo = "Duração da jornada: ${viagem.duracao}",
                    corAzulClaro = corAzulClaro,
                    textoBotaoPrincipal = "Ver Roteiro",
                    onCliquePrincipal = {
                        navController.navigate("detalhes/${viagem.id}")
                    },
                    textoBotaoSecundario = null
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(10.dp),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, corAzulClaro),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = corAzulClaro.copy(alpha = 0.65f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "VOLTAR AO MENU",
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
        }
    }
}