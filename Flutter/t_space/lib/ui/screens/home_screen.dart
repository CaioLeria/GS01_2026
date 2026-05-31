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
  const HomeScreen({super.key});

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
      appBar: const Header(),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 0, 16, 0),
        child: SizedBox(
          width: double.infinity,
          height: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              SizedBox(
                height: 96,
                width: companiesState.length * 116.0,
                child: ListView.separated(
                  scrollDirection: Axis.horizontal,
                  padding: const EdgeInsets.symmetric(horizontal: 16),
                  itemCount: companiesState.length,
                  separatorBuilder: (_, _) => const SizedBox(width: 16),
                  itemBuilder: (context, index) {
                    final company = companiesState[index];
                    return CompanyCard(
                      company: company,
                      onClick: (company) => Navigator.pushNamed(
                        context,
                        AppRoutes.company,
                        arguments: company,
                      ),
                    );
                  },
                ),
              ),
              FilterDropdown(
                onChanged: _onFilterChanged,
              ),
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
