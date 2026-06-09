package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.model.EmpresaViagemRepository
import cesarb98.com.github.t_space.model.Viagem
import cesarb98.com.github.t_space.ui.theme.AzulGeada
import cesarb98.com.github.t_space.ui.theme.AzulNoturnoFundo
import cesarb98.com.github.t_space.ui.theme.AzulSideralMedio
import cesarb98.com.github.t_space.ui.theme.BrancoNeblina

@Composable
fun ViagemScreen(viagem: Viagem, navController: NavController) {
    val nomeEmpresa = EmpresaViagemRepository
        .buscarEmpresaPorViagemId(viagem.id)?.nome ?: ""

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
                text = nomeEmpresa.uppercase(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = AzulGeada,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = viagem.destino,
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                color = BrancoNeblina,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "MANIFESTO DA MISSÃO",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AzulGeada,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulNoturnoFundo.copy(alpha = 0.85f), RoundedCornerShape(18.dp))
                    .border(1.2.dp, AzulSideralMedio.copy(alpha = 0.6f), RoundedCornerShape(18.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = viagem.descricao,
                    color = BrancoNeblina,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "ESPECIFICAÇÕES",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AzulGeada,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            InfoEspecificacaoRow(
                rotulo = "Duração Estimada",
                valor = viagem.duracao,
                icone = Icons.Default.Info
            )

            Spacer(modifier = Modifier.height(12.dp))

            InfoEspecificacaoRow(
                rotulo = "Custo do Assento",
                valor = viagem.preco,
                icone = Icons.Default.LocationOn
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = AzulSideralMedio),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                    tint = BrancoNeblina,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "RESERVAR ASSENTO",
                    color = BrancoNeblina,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.5.dp, AzulGeada),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = AzulGeada
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
    icone: ImageVector
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AzulNoturnoFundo.copy(alpha = 0.85f), RoundedCornerShape(14.dp))
            .border(1.2.dp, AzulSideralMedio.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .background(AzulSideralMedio.copy(alpha = 0.35f), CircleShape)
                    .border(1.dp, AzulGeada.copy(alpha = 0.4f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icone,
                    contentDescription = null,
                    tint = AzulGeada,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = rotulo,
                    color = AzulGeada,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = valor,
                    color = BrancoNeblina,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}