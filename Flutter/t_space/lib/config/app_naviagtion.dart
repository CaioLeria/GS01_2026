import 'package:flutter/material.dart';
import 'package:t_space/config/app_routes.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/model/travel.dart';
import 'package:t_space/ui/screens/company_screen.dart';
import 'package:t_space/ui/screens/home_screen.dart';
import 'package:t_space/ui/screens/splash_screen.dart';
import 'package:t_space/ui/screens/travel_screnn.dart';

class AppNavigation {
  static Map<String, WidgetBuilder> get routes => {
    AppRoutes.splash: (context) => SplashScreen(
      onNavigateToLogin: () {
        Navigator.pushReplacementNamed(context, AppRoutes.home);
      },
    ),
    AppRoutes.home: (context) => const HomeScreen(),
    AppRoutes.company: (context) {
      final company = ModalRoute.of(context)?.settings.arguments as Company?;
      if (company == null) {
        return const HomeScreen();
      }
      return CompanyScreen(company: company);
    },
    AppRoutes.travel: (context) {
      final travel = ModalRoute.of(context)?.settings.arguments as Travel?;
      if (travel == null) {
        return const HomeScreen();
      }
      return TravelScreen(travel: travel);
    },
  };
}
