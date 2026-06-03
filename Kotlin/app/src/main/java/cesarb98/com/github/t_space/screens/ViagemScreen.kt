package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.model.Viagem

@Composable
fun ViagemScreen(viagem: Viagem, navController: NavController) {
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
                text = viagem.empresa.uppercase(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = corAzulClaro,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = viagem.destino,
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "MANIFESTO DA MISSÃO",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(vidroFumeClaro, RoundedCornerShape(18.dp))
                    .border(1.2.dp, azulClaroContorno.copy(alpha = 0.5f), RoundedCornerShape(18.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = viagem.descricao,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "ESPECIFICAÇÕES",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )

            InfoEspecificacaoRow(
                rotulo = "Duração Estimada",
                valor = viagem.duracao,
                icone = Icons.Default.Info,
                corAzulClaro = corAzulClaro,
                vidroFumeClaro = vidroFumeClaro,
                azulClaroContorno = azulClaroContorno
            )

            Spacer(modifier = Modifier.height(12.dp))

            InfoEspecificacaoRow(
                rotulo = "Custo do Assento",
                valor = viagem.preco,
                icone = Icons.Default.LocationOn,
                corAzulClaro = corAzulClaro,
                vidroFumeClaro = vidroFumeClaro,
                azulClaroContorno = azulClaroContorno
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = corAzulClaro.copy(alpha = 0.65f)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "RESERVAR ASSENTO",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.5.dp, corAzulClaro),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "VOLTAR",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun InfoEspecificacaoRow(
    rotulo: String,
    valor: String,
    icone: ImageVector,
    corAzulClaro: Color,
    vidroFumeClaro: Color,
    azulClaroContorno: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(vidroFumeClaro, RoundedCornerShape(14.dp))
            .border(1.2.dp, azulClaroContorno.copy(alpha = 0.4f), RoundedCornerShape(14.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .background(corAzulClaro.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icone,
                    contentDescription = null,
                    tint = corAzulClaro,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = rotulo,
                    color = Color.Black.copy(alpha = 0.7f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = valor,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}