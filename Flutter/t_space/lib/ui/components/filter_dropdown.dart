import 'package:flutter/material.dart';
import 'package:t_space/model/company_filter_enum.dart';

class FilterDropdown extends StatefulWidget {
  final ValueChanged<CompanyFilter>? onChanged;

  const FilterDropdown({
    super.key,
    this.onChanged,
  });

  @override
  State<FilterDropdown> createState() => _FilterDropdownState();
}

class _FilterDropdownState extends State<FilterDropdown> {
  CompanyFilter selectedFilter = CompanyFilter.clear;

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 200,
      padding: const EdgeInsets.symmetric(horizontal: 12),
      decoration: BoxDecoration(
        border: Border.all(color: Colors.grey),
        borderRadius: BorderRadius.circular(8),
      ),
      child: DropdownButton<CompanyFilter>(
        value: selectedFilter,
        isExpanded: true,
        underline: const SizedBox(),
        items: CompanyFilter.values
            .map(
              (item) => DropdownMenuItem(
                value: item,
                child: Text(item.displayName),
              ),
            )
            .toList(),
        onChanged: (value) {
          if (value == null) return;
          setState(() {
            selectedFilter = value;
          });
          widget.onChanged?.call(value);
        },
      ),
    );
  }
}
