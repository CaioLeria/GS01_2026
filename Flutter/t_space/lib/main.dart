import 'package:flutter/material.dart';
import 'package:t_space/config/app_naviagtion.dart';
import 'package:t_space/config/app_routes.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(useMaterial3: true),
      initialRoute: AppRoutes.splash,
      routes: AppNavigation.routes,
    );
  }
}
