import 'package:flutter/material.dart';
import 'package:t_space/model/travel.dart';

class TravelCard extends StatelessWidget {
  final Travel travel;
  final Function(Travel)? onClick;
  const TravelCard({super.key, required this.travel, this.onClick});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: GestureDetector(
        onTap: onClick != null ? () => onClick!(travel) : null,
        child: SizedBox(
          height: 200,
          width: 500,
          child: Card(
            color: Colors.white.withOpacity(0.60),
            elevation: 4,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(16),
            ),
            clipBehavior: Clip.antiAlias,
            child: Row(
              children: [
                Image.asset(
                  travel.image,
                  width: 200,
                  height: 200,
                  fit: BoxFit.cover,
                ),
                const SizedBox(width: 24),
                Expanded(
                  child: Padding(
                    padding: const EdgeInsets.symmetric(vertical: 16),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Container(
                          width: double.infinity,
                          alignment: Alignment.center,
                          child: Text(
                            travel.title,
                            textAlign: TextAlign.center,
                            style: const TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 18,
                            ),
                          ),
                        ),
                        const SizedBox(height: 12),
                        Text('Destino: ${travel.destination}'),
                        Text('Duração: ${travel.duration}'),
                        Text('Empresa: ${travel.company.name}'),
                        Text('R\$ ${travel.price.toStringAsFixed(2)}'),
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
