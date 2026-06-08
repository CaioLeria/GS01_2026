package cesarb98.com.github.t_space.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cesarb98.com.github.t_space.ui.theme.AzulGeada
import cesarb98.com.github.t_space.ui.theme.AzulNoturnoFundo
import cesarb98.com.github.t_space.ui.theme.AzulSideralMedio
import cesarb98.com.github.t_space.ui.theme.BrancoNeblina

@Composable
fun MenuCardButton(
    titulo: String,
    subtitulo: String,
    textoBotaoPrincipal: String,
    onCliquePrincipal: () -> Unit,
    modifier: Modifier = Modifier,
    icone: ImageVector = Icons.Default.RocketLaunch,
    textoBotaoSecundario: String? = null,
    onCliqueSecundario: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(AzulNoturnoFundo.copy(alpha = 0.85f), RoundedCornerShape(16.dp))
            .border(1.dp, AzulSideralMedio.copy(alpha = 0.6f), RoundedCornerShape(16.dp))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(AzulSideralMedio.copy(alpha = 0.35f), CircleShape)
                    .border(1.dp, AzulGeada.copy(alpha = 0.4f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icone,
                    contentDescription = null,
                    tint = AzulGeada,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = titulo,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = BrancoNeblina
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitulo,
                    fontSize = 13.sp,
                    color = AzulGeada,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        HorizontalDivider(
            color = AzulSideralMedio.copy(alpha = 0.4f),
            thickness = 1.dp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (textoBotaoSecundario != null) {
                OutlinedButton(
                    onClick = onCliqueSecundario,
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.2.dp, AzulGeada),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = BrancoNeblina
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(
                        text = textoBotaoSecundario,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }

            Button(
                onClick = onCliquePrincipal,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AzulSideralMedio,
                    contentColor = BrancoNeblina
                ),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Text(
                    text = textoBotaoPrincipal,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}