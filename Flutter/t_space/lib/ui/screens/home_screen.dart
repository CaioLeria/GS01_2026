import 'package:flutter/material.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/model/travel.dart';
import 'package:t_space/repository/company_repository.dart';
import 'package:t_space/repository/travel_reposritory.dart';
import 'package:t_space/ui/components/company_card.dart';
import 'package:t_space/ui/components/header.dart';
import 'package:t_space/ui/components/travel_card.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late List<Company> companiesState;
  late List<Travel> travelListState;

  @override
  void initState() {
    super.initState();
    companiesState = getAllCompanies();
    travelListState = getAllTravels();
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
            children: [
              
              SizedBox(
                height: 96,
                width: double.infinity,
                child: ListView.separated(
                  scrollDirection: Axis.horizontal,
                  padding: const EdgeInsets.symmetric(horizontal: 16),
                  itemCount: companiesState.length,
                  separatorBuilder: (_, _) => const SizedBox(width: 16),
                  itemBuilder: (context, index) {
                    final company = companiesState[index];
                    return CompanyCard(company: company);
                  },
                ),
              ),
              Expanded(
                child: travelListState.isEmpty
                    ? const Center(child: Text('Nenhuma viagem encontrada'))
                    : ListView.builder(
                        itemCount: travelListState.length,
                        itemBuilder: (context, index) {
                          final travel = travelListState[index];
                          return TravelCard(travel: travel);
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
