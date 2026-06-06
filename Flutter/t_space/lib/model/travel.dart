import 'package:t_space/model/company.dart';

class Travel {
  final String title;
  final double price;
  final String destination; 
  final Company company;
  final String duration;
  final String image;

  const Travel ({
    required this.title, 
    required this.price, 
    required this.destination, 
    required this.duration,
    required this.company,
    required this.image,
    });

}