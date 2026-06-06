import 'package:flutter/material.dart';
import 'package:t_space/config/app_routes.dart';
import 'package:t_space/model/company.dart';
import 'package:t_space/model/travel.dart';
import 'package:t_space/ui/screens/company_screen.dart';
import 'package:t_space/ui/screens/home_screen.dart';
import 'package:t_space/ui/screens/identification_screen.dart';
import 'package:t_space/ui/screens/introduction_screen.dart';
import 'package:t_space/ui/screens/splash_screen.dart';
import 'package:t_space/ui/screens/travel_scren.dart';

class AppNavigation {
  static Map<String, WidgetBuilder> get routes => {
    AppRoutes.splash: (context) => const SplashScreen(),
    AppRoutes.introduction: (context) => const IntroductionScreen(),
    AppRoutes.identification: (context) => const IdentificationScreen(),
    AppRoutes.home: (context) {
      final name = ModalRoute.of(context)?.settings.arguments as String?;
      return HomeScreen(userName: name);
    },
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
