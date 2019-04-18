#coding: utf-8

require_relative 'Damage'
require_relative 'Hangar'
require_relative 'WeaponType'
require_relative 'SuppliesPackage'
require_relative 'SpaceStation'
require_relative 'ShieldBooster'
require_relative 'Weapon'

module Pruebas

  ## Añado suministros necesarios para poder hacer la prueba 
  supplies = Deepspace::SuppliesPackage.new 10, 32, 12
  
  # constructor
  
  ss = Deepspace::SpaceStation.new "La armada invencible", supplies
  ss.receiveHangar Deepspace::Hangar.new 9
  ss.receiveShieldBooster Deepspace::ShieldBooster.new "Escudillo", 2.1, 3
  ss.receiveWeapon Deepspace::Weapon.new "Pistolilla",Deepspace::WeaponType::LASER, 3
  ss.mountWeapon 0
  ss.mountShieldBooster 0
  puts ss.to_s

  ## ________ comienzo real de la práctica _______
  puts "Fire #{ss.fire}"
  puts "Le mando disparo de 10 #{ss.receiveShot(10) }"
  puts "Le mando disparo de 100 #{ss.receiveShot 100}"
  
end #Pruebas
