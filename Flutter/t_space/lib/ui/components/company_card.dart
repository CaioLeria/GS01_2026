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
      onTap: onClick != null ? () => onClick!(company) : null,

      child: Padding(
        padding: const EdgeInsets.symmetric(vertical: 8.0),
        child: SizedBox(
          width: 100,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Card(
                shape: const CircleBorder(),
                elevation: 4,
                clipBehavior: Clip.antiAlias,
                child: SizedBox(
                  width: 80,
                  height: 80,
                  child: Padding(
                    padding: const EdgeInsets.all(12),
                    child: SvgPicture.asset(company.image, fit: BoxFit.contain),
                  ),
                ),
              ),
              const SizedBox(height: 8),
              Text(
                company.name,
                textAlign: TextAlign.center,
                maxLines: 2,
                overflow: TextOverflow.ellipsis,
                style: const TextStyle(fontSize: 14, color: Colors.white),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
