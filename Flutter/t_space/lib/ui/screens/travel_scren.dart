import 'package:flutter/material.dart';
import 'package:t_space/model/travel.dart';
import 'package:t_space/ui/components/header.dart';

class TravelScreen extends StatelessWidget {
  final Travel travel;
  const TravelScreen({super.key, required this.travel});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Header(),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text(
                'Travel Details',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
               SizedBox(height: 16),
              Text('Destination: ${travel.destination}'),
               SizedBox(height: 8),
              Text('Duration: ${travel.duration} days'),
               SizedBox(height: 8),
              Text('Price: \$${travel.price.toStringAsFixed(2)}'),
              SizedBox(height: 8),
              Text('Company: ${travel.company.name}'),
            ],
          ),
        ),
      ),
    );
  }
}
