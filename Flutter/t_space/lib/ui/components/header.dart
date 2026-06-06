import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';

class Header extends StatelessWidget implements PreferredSizeWidget {
  final bool showBackButton;
  final String? userName;

  const Header({super.key, this.showBackButton = true, this.userName});

  @override
  Widget build(BuildContext context) {
    return AppBar(

      automaticallyImplyLeading: showBackButton,
      title: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: Row(
          children: [
            Expanded(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  SvgPicture.asset(
                    'assets/icons/rocket_launch.svg',
                    width: 24,
                    height: 24,
                    colorFilter: const ColorFilter.mode(
                      Colors.deepPurple,
                      BlendMode.srcIn,
                    ),
                  ),
                  const SizedBox(width: 8),
                  const Text(
                    "T-Space",
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            ),

            if (userName != null) ...[
              Text(
                ' Bem vindo, $userName!',
                style: const TextStyle(fontSize: 16),
              ),
              const SizedBox(width: 16),
            ],
          ],
        ),
      ),
    );
  }

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);
}
