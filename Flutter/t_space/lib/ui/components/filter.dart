import 'package:flutter/material.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/repository/company_repository.dart'; // Import do seu modelo

class ComponenteFiltro extends StatefulWidget {
  // Callback atualizado para passar apenas o nome selecionado (ou null se for "Todas")
  final Function(String? nomeEmpresa) onFiltrar;

  const ComponenteFiltro({super.key, required this.onFiltrar});

  @override
  State<ComponenteFiltro> createState() => _ComponenteFiltroState();
}

class _ComponenteFiltroState extends State<ComponenteFiltro> {
  // Pegamos a lista original para extrair os nomes
  final List<Company> _companies = getAllCompanies();

  // Variável de estado que guarda apenas o nome da empresa selecionada
  String? _nomeEmpresaSelecionada;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Filtrar por Empresa',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),

          // O DROPDOWN (Baseado no DropdownButtonFormField do slide 72)
          // Agora tipado como String? para listar e selecionar apenas os nomes
          DropdownButtonFormField<String?>(
            value: _nomeEmpresaSelecionada,
            isExpanded: true,
            decoration: const InputDecoration(
              labelText: 'Selecione a Empresa',
              border: OutlineInputBorder(),
              prefixIcon: Icon(Icons.rocket_launch),
            ),
            // Opção inicial nula para resetar o filtro, seguida apenas pelos nomes das empresas
            items: [
              const DropdownMenuItem<String?>(
                value: null,
                child: Text('Todas as empresas'),
              ),
              ..._companies.map((company) {
                return DropdownMenuItem<String?>(
                  value: company
                      .name, // O valor interno do item agora é a String (nome)
                  child: Text(company.name), // O texto exibido também é o nome
                );
              }),
            ],
            onChanged: (String? value) {
              setState(() {
                _nomeEmpresaSelecionada = value;
              });
            },
          ),
          const SizedBox(height: 20),

          // Botão para disparar a ação (Baseado no slide 29)
          SizedBox(
            width: double.infinity,
            child: FilledButton(
              onPressed: () {
                // Task 2: Passa o nome selecionado para a lógica de filtro
                widget.onFiltrar(_nomeEmpresaSelecionada);
              },
              child: const Text('Filtrar'),
            ),
          ),
        ],
      ),
    );
  }
}
