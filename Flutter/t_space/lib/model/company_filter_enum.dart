import 'package:t_space/model/company.dart';

enum CompanyFilter {clear, spacex, blueOrigin, virginGalactic, nasa, axiom }

extension CompanyFilterExtension on CompanyFilter {
  String get displayName {
    switch (this) {
      case CompanyFilter.spacex:
        return 'SpaceX';
      case CompanyFilter.blueOrigin:
        return 'Blue Origin';
      case CompanyFilter.virginGalactic:
        return 'Virgin Galactic';
      case CompanyFilter.nasa:
        return 'NASA';
      case CompanyFilter.axiom:
        return 'Axiom Space';
      case CompanyFilter.clear:
        return 'All Companies';
      
    }
  }

  String? get companyName {
    switch (this) {
      case CompanyFilter.spacex:
        return 'SpaceX';
      case CompanyFilter.blueOrigin:
        return 'Blue Origin';
      case CompanyFilter.virginGalactic:
        return 'Virgin Galactic';
      case CompanyFilter.nasa:
        return 'NASA';
      case CompanyFilter.axiom:
        return 'Axiom Space';
      case CompanyFilter.clear:
        return null;

    }
  }

  bool matchesCompany(Company company) {
    final name = companyName;
    if (name == null) {
      return true;
    }
    return company.name == name;
  }
}
