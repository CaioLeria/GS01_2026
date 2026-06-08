package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.R
import cesarb98.com.github.t_space.ui.theme.AzulGeada
import cesarb98.com.github.t_space.ui.theme.AzulNoturnoFundo
import cesarb98.com.github.t_space.ui.theme.AzulSideralMedio
import cesarb98.com.github.t_space.ui.theme.BrancoNeblina
import cesarb98.com.github.t_space.ui.theme.PretoCosmico

@Composable
fun StartScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.fundo_espaco),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(PretoCosmico.copy(alpha = 0.55f))
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            AzulNoturnoFundo.copy(alpha = 0.9f)
                        ),
                        startY = 600f
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        .width(56.dp)
                        .height(2.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color.Transparent, AzulGeada, Color.Transparent)
                            )
                        )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "T-SPACE",
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Black,
                    color = BrancoNeblina,
                    letterSpacing = 8.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Sua porta de entrada para o\nturismo e logística orbital",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = AzulGeada,
                    textAlign = TextAlign.Center,
                    lineHeight = 23.sp,
                    letterSpacing = 0.3.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .width(56.dp)
                        .height(2.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color.Transparent, AzulGeada, Color.Transparent)
                            )
                        )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 52.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "PRONTO PARA DECOLAR?",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulGeada.copy(alpha = 0.7f),
                    letterSpacing = 2.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        navController.navigate("menu") {
                            popUpTo("start") { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulSideralMedio,
                        contentColor = BrancoNeblina
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "COMEÇAR",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 3.sp
                    )
                }
            }
        }
    }
}