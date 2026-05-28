import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:t_space/model/company.dart';

class CompanyCard extends StatelessWidget {
  final Company company;
  final Function(Company)? onClick;
  const CompanyCard({super.key, required this.company, this.onClick});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onClick != null ? ( ) => 
      onClick! (company) : null,

      child: SizedBox(
        width: 100,
        height: 100,
        child: Column(
          children: [
            Card(
              shape: const CircleBorder(),
              elevation: 4,
              child: Center(
                child: Padding (padding: EdgeInsets.all(8), child: SvgPicture.asset('assets/icons/rocket_launch.svg', width: 24, height: 24, colorFilter: const ColorFilter.mode(Colors.deepPurple, BlendMode.srcIn)),),
              ),
            ),
            Text(company.name)
          ],
        ),
        
      ),
    );
  }
}