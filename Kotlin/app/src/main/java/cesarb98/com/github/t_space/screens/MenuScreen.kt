package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.TravelExplore // Ícone padrão perfeito para viagens
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    // Gradiente e paleta do tema espacial adaptados
    val spaceBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0D1E), Color(0xFF1B1464), Color(0xFF020617))
    )
    val neonCyan = Color(0xFF00FFFF)
    val glassWhite = Color.White.copy(alpha = 0.1f)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(spaceBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()), // Previne quebras em telas menores
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- 1. HEADER ---
            Text(
                text = "VIAGENS ESPACIAIS",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            // --- 2. CAIXA DE IDENTIFICAÇÃO DO PILOTO ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(glassWhite, RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Piloto",
                        tint = neonCyan,
                        modifier = Modifier.size(44.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Viagem X",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = neonCyan
                        )
                        Text(
                            text = "Visao panoramica de cima da terra",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // --- 3. CARDS QUE FUNCIONAM COMO BOTÕES COM SEU NAVCONTROLLER ---

            // Card Companhia
            MenuCardButton(
                titulo = "Companhia",
                subtitulo = "Acessar dados da companhia da viagem",
                icone = Icons.Default.AccountCircle,
                corItem = neonCyan,
                onClick = { navController.navigate("perfil/Fulano de Tal/27") }
            )

            // Card Viagem (Substituído para usar o ícone nativo TravelExplore)
            MenuCardButton(
                titulo = "Viagem",
                subtitulo = "Acessar área de viagens",
                icone = Icons.Default.TravelExplore,
                corItem = Color(0xFFBD00FF), // Roxo Estelar
                onClick = { navController.navigate("pedidos?cliente=Cliente XPTO") }
            )

            // Card Sair
            MenuCardButton(
                titulo = "Sair",
                subtitulo = "Voltar ao inicio",
                icone = Icons.Default.ExitToApp,
                corItem = Color(0xFFED145B), // Rosa de Alerta
                onClick = { navController.navigate("login") }
            )
        }
    }
}

// Componente customizado para os Cards com efeito de click integrado
@Composable
fun MenuCardButton(
    titulo: String,
    subtitulo: String,
    icone: ImageVector,
    corItem: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable { onClick() }, // Transforma o container inteiro em gatilho de toque
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.05f)),
        border = androidx.compose.foundation.BorderStroke(0.5.dp, Color.White.copy(alpha = 0.1f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(corItem.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icone,
                    contentDescription = titulo,
                    tint = corItem,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = titulo,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitulo,
                    color = Color.LightGray,
                    fontSize = 13.sp
                )
            }
        }
    }
}