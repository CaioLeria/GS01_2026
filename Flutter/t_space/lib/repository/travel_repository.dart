import 'package:t_space/model/travel.dart';
import 'package:t_space/repository/company_repository.dart';

const luaExpress = Travel(
  title: 'Lua Express',
  price: 250000.00,
  destination: 'Lua',
  duration: '7 dias',
  company: spacex,
);

const orbitaTerrestre = Travel(
  title: 'Órbita Terrestre',
  price: 85000.00,
  destination: 'Órbita Baixa',
  duration: '3 dias',
  company: blueOrigin,
);

const expedicaoMarte = Travel(
  title: 'Expedição Marte',
  price: 1500000.00,
  destination: 'Marte',
  duration: '180 dias',
  company: spacex,
);

const missaoISS = Travel(
  title: 'Missão ISS',
  price: 120000.00,
  destination: 'Estação ISS',
  duration: '14 dias',
  company: nasa,
);

const turismoSuborbital = Travel(
  title: 'Turismo Suborbital',
  price: 45000.00,
  destination: 'Espaço Suborbital',
  duration: '2 horas',
  company: virginGalactic,
);

List<Travel> getAllTravels() {
  return const [
    luaExpress,
    orbitaTerrestre,
    expedicaoMarte,
    missaoISS,
    turismoSuborbital,
  ];
}