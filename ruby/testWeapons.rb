require_relative 'Weapon'
require_relative 'WeaponType'

w = []
w << Deepspace::Weapon.new("laser1",Deepspace::WeaponType::LASER,3)
w << Deepspace::Weapon.new("misil",Deepspace::WeaponType::MISSILE,2)

s = "armas \n"

w.each { |w|
  s += w.to_s
}

puts s
