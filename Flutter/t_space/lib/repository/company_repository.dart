import 'package:t_space/model/company.dart';

const spacex = Company(
  name: 'SpaceX',
  owner: 'Elon Musk',
  rating: '4.9',
  image: '',
);

const blueOrigin = Company(
  name: 'Blue Origin',
  owner: 'Jeff Bezos',
  rating: '4.5',
  image: '',
);

const virginGalactic = Company(
  name: 'Virgin Galactic',
  owner: 'Richard Branson',
  rating: '4.3',
  image: '',
);

const nasa = Company(
  name: 'NASA',
  owner: 'Bill Nelson',
  rating: '5.0',
  image: '',
);

const axiom = Company(
  name: 'Axiom Space',
  owner: 'Michael Suffredini',
  rating: '4.7',
  image: '',
);

List<Company> getAllCompanies() {
  return const [
    spacex,
    blueOrigin,
    virginGalactic,
    nasa,
    axiom,
  ];
}