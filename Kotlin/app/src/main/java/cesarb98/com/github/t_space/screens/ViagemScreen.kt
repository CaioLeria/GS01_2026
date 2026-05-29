package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
    val spaceBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0D1E), Color(0xFF1B1464), Color(0xFF020617))
    )
    val neonCyan = Color(0xFF00FFFF)
    val glassWhite = Color.White.copy(alpha = 0.05f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(spaceBackground)
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
                color = neonCyan,
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
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(glassWhite, RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = viagem.descricao,
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "ESPECIFICAÇÕES",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )

            InfoEspecificacaoRow(
                rotulo = "Duração Estimada",
                valor = viagem.duracao,
                icone = Icons.Default.Info,
                corIcone = Color(0xFFBD00FF)
            )

            Spacer(modifier = Modifier.height(12.dp))

            InfoEspecificacaoRow(
                rotulo = "Custo do Assento",
                valor = viagem.preco,
                icone = Icons.Default.LocationOn,
                corIcone = neonCyan
            )

            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Ação futura: Reservar assento */ },
                colors = ButtonDefaults.buttonColors(containerColor = neonCyan),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                    tint = Color(0xFF020617),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "RESERVAR ASSENTO",
                    color = Color(0xFF020617),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
            ) {
                Text(
                    text = "VOLTAR",
                    color = Color.White,
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
    corIcone: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.02f), RoundedCornerShape(12.dp))
            .border(0.5.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(corIcone.copy(alpha = 0.1f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icone,
                    contentDescription = null,
                    tint = corIcone,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = rotulo, color = Color.Gray, fontSize = 12.sp)
                Text(text = valor, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}