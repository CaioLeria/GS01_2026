import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:t_space/config/app_naviagation.dart';
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
      scrollBehavior: MouseScrollBehavior(),
      theme: ThemeData(
        useMaterial3: true,
        scaffoldBackgroundColor: Colors.transparent,
      ),
      initialRoute: AppRoutes.splash,
      routes: AppNavigation.routes,
      builder: (context, child) {
        return Stack(
          children: [
            Positioned.fill(
              child: Opacity(
                opacity: 0.95,
                child: Image.asset(
                  'assets/images/background2.jpg',
                  fit: BoxFit.cover,
                ),
              ),
            ),
            if (child != null) child,
          ],
        );
      },
    );
  }
}

class MouseScrollBehavior extends MaterialScrollBehavior {
  @override
  Set<PointerDeviceKind> get dragDevices => {
    PointerDeviceKind.touch,
    PointerDeviceKind.mouse,
    PointerDeviceKind.trackpad,
  };
}
