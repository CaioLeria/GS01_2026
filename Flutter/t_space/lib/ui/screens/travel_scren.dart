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
          child: Card(
            color: Colors.white.withOpacity(0.60),
            elevation: 4,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(16),
            ),
            child: Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text(
                    travel.title,
                    style: const TextStyle(
                      fontSize: 24,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  const SizedBox(height: 16),
                  ClipRRect(
                    borderRadius: BorderRadius.circular(16),
                    child: Image.asset(
                      travel.image,
                      width: 400,
                      height: 380,
                      fit: BoxFit.cover,
                    ),
                  ),
                  const SizedBox(height: 16),
                  const Text(
                    'Travel Details',
                    style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 16),
                  Text('Destination: ${travel.destination}'),
                  const SizedBox(height: 8),
                  Text('Duration: ${travel.duration}'),
                  const SizedBox(height: 8),
                  Text('Price: \$${travel.price.toStringAsFixed(2)}'),
                  const SizedBox(height: 8),
                  Text('Company: ${travel.company.name}'),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
