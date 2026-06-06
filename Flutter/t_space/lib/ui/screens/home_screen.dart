import 'package:flutter/material.dart';
import 'package:t_space/config/app_routes.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/model/company_filter_enum.dart';
import 'package:t_space/model/travel.dart';
import 'package:t_space/repository/company_repository.dart';
import 'package:t_space/repository/travel_repository.dart';
import 'package:t_space/ui/components/company_card.dart';
import 'package:t_space/ui/components/filter_dropdown.dart';
import 'package:t_space/ui/components/header.dart';
import 'package:t_space/ui/components/travel_card.dart';

class HomeScreen extends StatefulWidget {
  final String? userName;
  const HomeScreen({super.key, this.userName});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late List<Company> companiesState;
  late List<Travel> allTravels;
  late List<Travel> travelListState;

  @override
  void initState() {
    super.initState();
    companiesState = getAllCompanies();
    allTravels = getAllTravels();
    travelListState = allTravels;
  }

  void _onFilterChanged(CompanyFilter filter) {
    setState(() {
      travelListState = allTravels
          .where((travel) => filter.matchesCompany(travel.company))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Header(showBackButton: false, userName: widget.userName),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 0, 16, 0),
        child: SizedBox(
          width: double.infinity,
          height: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              // Seção das Empresas Centralizada
              SizedBox(
                height: 140,
                child: SingleChildScrollView(
                  scrollDirection: Axis.horizontal,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: companiesState.asMap().entries.map((entry) {
                      final index = entry.key;
                      final company = entry.value;

                      return Padding(
                        padding: EdgeInsets.only(
                          left: index == 0 ? 0 : 8,
                          right: index == companiesState.length - 1 ? 0 : 8,
                        ),
                        child: CompanyCard(
                          company: company,
                          onClick: (company) => Navigator.pushNamed(
                            context,
                            AppRoutes.company,
                            arguments: company,
                          ),
                        ),
                      );
                    }).toList(),
                  ),
                ),
              ),
              FilterDropdown(onChanged: _onFilterChanged),
              const SizedBox(height: 16),
              Expanded(
                child: travelListState.isEmpty
                    ? const Center(child: Text('Nenhuma viagem encontrada'))
                    : ListView.builder(
                        itemCount: travelListState.length,
                        itemBuilder: (context, index) {
                          final travel = travelListState[index];
                          return TravelCard(
                            travel: travel,
                            onClick: (travel) => Navigator.pushNamed(
                              context,
                              AppRoutes.travel,
                              arguments: travel,
                            ),
                          );
                        },
                      ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}