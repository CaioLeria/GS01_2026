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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cesarb98.com.github.t_space.components.MenuCardButton
import cesarb98.com.github.t_space.model.Empresa
import cesarb98.com.github.t_space.model.EmpresaViagemRepository
import cesarb98.com.github.t_space.navigation.Routes
import cesarb98.com.github.t_space.ui.theme.AzulGeada
import cesarb98.com.github.t_space.ui.theme.AzulNoturnoFundo
import cesarb98.com.github.t_space.ui.theme.AzulSideralMedio
import cesarb98.com.github.t_space.ui.theme.BrancoNeblina

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    val empresas = EmpresaViagemRepository.listaDeEmpresas
    var empresaSelecionada by remember { mutableStateOf<Empresa?>(null) }
    var dropdownExpandido by remember { mutableStateOf(false) }

    val viagensExibidas = remember(empresaSelecionada) {
        empresaSelecionada?.viagensDisponiveis
            ?: empresas.flatMap { it.viagensDisponiveis }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "T-SPACE",
                fontSize = 38.sp,
                fontWeight = FontWeight.ExtraBold,
                color = BrancoNeblina,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    onClick = { dropdownExpandido = true },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.2.dp,
                        if (dropdownExpandido) AzulGeada else AzulSideralMedio.copy(alpha = 0.7f)
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = AzulNoturnoFundo.copy(alpha = 0.85f),
                        contentColor = BrancoNeblina
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = empresaSelecionada?.nome ?: "Todas as Empresas",
                            fontSize = 18.sp,
                            color = BrancoNeblina,
                            fontWeight = FontWeight.Medium
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = AzulGeada
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
                text = if (empresaSelecionada == null) "PRÓXIMOS LANÇAMENTOS"
                else "ROTAS DISPONÍVEIS: ${empresaSelecionada?.nome?.uppercase()}",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AzulGeada,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            viagensExibidas.forEach { viagem ->
                val empresa = EmpresaViagemRepository.buscarEmpresaPorViagemId(viagem.id)

                MenuCardButton(
                    titulo = viagem.destino,
                    subtitulo = "Operado por: ${empresa?.nome ?: ""} | ${viagem.duracao}",
                    icone = Icons.Default.RocketLaunch,
                    textoBotaoPrincipal = "Ver Viagem",
                    onCliquePrincipal = {
                        navController.navigate(Routes.detalhesComId(viagem.id))
                    },
                    textoBotaoSecundario = "Ver Empresa",
                    onCliqueSecundario = {
                        empresa?.let { navController.navigate(Routes.empresaComId(it.id)) }
                    }
                )
            }
        }
    }
}