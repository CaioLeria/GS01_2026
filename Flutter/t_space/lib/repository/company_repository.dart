import 'package:t_space/model/company.dart';

const spacex = Company(
  name: 'SpaceX',
  owner: 'Elon Musk',
  rating: '4.9',
  image: 'assets/images/spacex-logo-1.svg',
);

const blueOrigin = Company(
  name: 'Blue Origin',
  owner: 'Jeff Bezos',
  rating: '4.5',
  image: 'assets/images/blue-origin.svg',
);

const virginGalactic = Company(
  name: 'Virgin Galactic',
  owner: 'Richard Branson',
  rating: '4.3',
  image: 'assets/images/virgin-galactic.svg',
);

const nasa = Company(
  name: 'NASA',
  owner: 'Bill Nelson',
  rating: '5.0',
  image: 'assets/images/nasa-6.svg',
);

const axiom = Company(
  name: 'Axiom Space',
  owner: 'Michael Suffredini',
  rating: '4.7',
  image: 'assets/images/Axiom_Space_logo.svg',
);

List<Company> getAllCompanies() {
  return const [spacex, blueOrigin, virginGalactic, nasa, axiom];
}
