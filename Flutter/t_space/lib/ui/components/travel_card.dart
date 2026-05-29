import 'package:flutter/material.dart';
import 'package:t_space/model/travel.dart';

class TravelCard extends StatelessWidget {
  final Travel travel;
  final Function(Travel)? onClick;
  const TravelCard({super.key, required this.travel, this.onClick});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
       onTap: onClick != null ? ( ) => 
      onClick! (travel) : null,

      child: SizedBox(
            height: 200,
            width: 500,
            child: Row(
              children: [
                  Text ("Aqui sera uma imagem"),
                  Column(
                    children: [
                      Text(travel.title),
                      Text(travel.destination),
                      Text(travel.duration),
                      Text(travel.company.name),
                      Text('R\$ ${travel.price.toStringAsFixed(2)}')
                    ],
                  ),  

              ],
            ),
      ),
    ) ;
  }
}