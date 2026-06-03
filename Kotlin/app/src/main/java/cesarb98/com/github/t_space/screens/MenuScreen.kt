package cesarb98.com.github.t_space.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.model.EmpresaViagemRepository
import cesarb98.com.github.t_space.model.Empresa

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    val corAzulClaro = Color(0xFF00BFFF)

    val empresas = EmpresaViagemRepository.listaDeEmpresas
    var empresaSelecionada by remember { mutableStateOf<Empresa?>(null) }
    var dropdownExpandido by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "T-SPACE",
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    onClick = { dropdownExpandido = true },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.2.dp,
                        if (dropdownExpandido) corAzulClaro else Color.White.copy(alpha = 0.4f)
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White.copy(alpha = 0.65f),
                        contentColor = Color.Black
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = empresaSelecionada?.nome ?: "Todas as Empresas",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }

                DropdownMenu(
                    expanded = dropdownExpandido,
                    onDismissRequest = { dropdownExpandido = false },
                    modifier = Modifier.fillMaxWidth(0.88f)
                ) {
                    DropdownMenuItem(
                        text = { Text("Todas as Empresas", fontWeight = FontWeight.Bold) },
                        onClick = {
                            empresaSelecionada = null
                            dropdownExpandido = false
                        }
                    )

                    empresas.forEach { empresa ->
                        DropdownMenuItem(
                            text = { Text(empresa.nome) },
                            onClick = {
                                empresaSelecionada = empresa
                                dropdownExpandido = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = if (empresaSelecionada == null) "PRÓXIMOS LANÇAMENTOS" else "ROTAS DISPONÍVEIS: ${empresaSelecionada?.nome?.uppercase()}",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            if (empresaSelecionada == null) {
                empresas.forEach { empresa ->
                    empresa.viagensDisponiveis.forEach { viagem ->
                        MenuCardButton(
                            titulo = viagem.destino,
                            subtitulo = "Operado por: ${empresa.nome} | ${viagem.duracao}",
                            icone = Icons.Default.RocketLaunch,
                            corAzulClaro = corAzulClaro,
                            textoBotaoPrincipal = "Ver Viagem",
                            onCliquePrincipal = { navController.navigate("detalhes/${viagem.id}") },
                            textoBotaoSecundario = "Ver Empresa",
                            onCliqueSecundario = { navController.navigate("empresa/${empresa.id}") }
                        )
                    }
                }
            } else {
                empresaSelecionada?.viagensDisponiveis?.forEach { viagem ->
                    MenuCardButton(
                        titulo = viagem.destino,
                        subtitulo = "Operado por: ${empresaSelecionada?.nome} | ${viagem.duracao}",
                        icone = Icons.Default.RocketLaunch,
                        corAzulClaro = corAzulClaro,
                        textoBotaoPrincipal = "Ver Viagem",
                        onCliquePrincipal = { navController.navigate("detalhes/${viagem.id}") },
                        textoBotaoSecundario = "Ver Empresa",
                        onCliqueSecundario = { navController.navigate("empresa/${empresaSelecionada?.id}") }
                    )
                }
            }
        }
    }
}