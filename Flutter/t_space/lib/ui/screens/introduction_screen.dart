import 'package:flutter/material.dart';
import 'package:t_space/config/app_routes.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/repository/company_repository.dart';
import 'package:t_space/ui/components/company_card.dart';
import 'package:t_space/ui/components/header.dart';

class IntroductionScreen extends StatefulWidget {
  const IntroductionScreen({super.key});

  @override
  State<IntroductionScreen> createState() => _IntroductionScreenState();
}

class _IntroductionScreenState extends State<IntroductionScreen> {
  int _currentPage = 0;
  late List<Company> companies;

  @override
  void initState() {
    super.initState();
    companies = getAllCompanies();
  }

  void _goToNextPage() {
    if (_currentPage == 0) {
      setState(() {
        _currentPage = 1;
      });
    } else if (_currentPage == 1) {
      Navigator.pushNamed(context, AppRoutes.identification);
    }
  }

  void _goBackPage() {
    if (_currentPage == 1) {
      setState(() {
        _currentPage = 0;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: const Header(showBackButton: false),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Expanded(
              child: _currentPage == 0 ? _buildFirstPage() : _buildSecondPage(),
            ),
            SizedBox(
              height: 60,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  if (_currentPage == 1)
                    ElevatedButton(
                      onPressed: _goBackPage,
                      child: const Text('Voltar'),
                    )
                  else
                    const SizedBox(width: 80),
                  ElevatedButton(
                    onPressed: _goToNextPage,
                    child: const Text('Continuar'),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildFirstPage() {
    return SingleChildScrollView(
      child: Opacity(
        opacity: 0.85,
        child: Card(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(12),
          ),
          elevation: 4,
          child: Padding(
            padding: const EdgeInsets.all(24.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const SizedBox(height: 24),
                const Text(
                  'Bem-vindo ao T-Space',
                  style: TextStyle(fontSize: 32, fontWeight: FontWeight.bold),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 32),
                const Text(
                  'Descubra uma nova forma de explorar o universo com nossos pacotes de turismo espacial de classe mundial.',
                  style: TextStyle(fontSize: 18),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 24),
                const Text(
                  'Oferecemos experiências incríveis em:',
                  style: TextStyle(fontSize: 16),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 16),
                const Column(
                  children: [
                    Text('🌙 Viagens à Lua', style: TextStyle(fontSize: 16)),
                    SizedBox(height: 8),
                    Text(
                      '🔴 Expedições a Marte',
                      style: TextStyle(fontSize: 16),
                    ),
                    SizedBox(height: 8),
                    Text(
                      '🛸 Órbita Terrestre Baixa',
                      style: TextStyle(fontSize: 16),
                    ),
                  ],
                ),
                const SizedBox(height: 24),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildSecondPage() {
    return SingleChildScrollView(
      child: Opacity(
        opacity: 0.85,
        child: SizedBox(
          width: 600,
          child: Card(
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            elevation: 4,
            child: Padding(
              padding: const EdgeInsets.all(24.0),
              child: Column(
                children: [
                  SizedBox(height: 16),
                  Text(
                    'Nossos Parceiros',
                    style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold),
                    textAlign: TextAlign.center,
                  ),
                  SizedBox(height: 16),
                  Text(
                    'Trabalhamos com as maiores empresas de turismo espacial do mundo.',
                    style: TextStyle(fontSize: 16),
                    textAlign: TextAlign.center,
                  ),
                  SizedBox(height: 24),
                  ListView.builder(
                    shrinkWrap: true,
                    itemCount: companies.length,
                    itemBuilder: (context, index) {
                      final company = companies[index];
                      return Padding(
                        padding: const EdgeInsets.only(bottom: 16.0),
                        child: Text(
                          ' - ${company.name}',
                          style: TextStyle(fontSize: 16),
                          textAlign: TextAlign.center,
                        ),
                      );
                    },
                  ),
                  SizedBox(height: 16),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
