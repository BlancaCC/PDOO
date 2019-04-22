#coding: utf-8

require_relative 'Damage'
require_relative 'Hangar'
require_relative 'ShieldBooster'
require_relative 'SuppliesPackage'
require_relative 'SpaceStation'

require_relative 'Weapon'


module Pruebas
  class SpaceStation
    def self.test
      supplies = Deepspace::SuppliesPackage.new 10, 32, 12
      
      # constructor
      ss = Deepspace::SpaceStation.new "La armada invencible", supplies
      puts ss.to_s

      #Suminitros basicso de hangar

      ss.receiveHangar Deepspace::Hangar.new 9
      ss.discardHangar
      if not  ss.receiveShieldBooster Deepspace::ShieldBooster.new "Escudillo", 2.1, 3
        puts "No se ha podido almacenar"
      else
        puts "se ha podido almacenas
"
      end
      
      ss.receiveHangar Deepspace::Hangar.new 7
      if not  ss.receiveShieldBooster Deepspace::ShieldBooster.new "Escudillo", 2.1, 3
        puts "No se ha podido almacenar"
      else
        puts "se ha podido almacenas"
      end

      if not  ss.receiveWeapon Deepspace::Weapon.new "Pistolilla",Deepspace::WeaponType::LASER, 3
        puts "No se ha podido almacenar el arma"
      else
        puts "se ha podido almacenas el arma"
      end


      ss.receiveSupplies Deepspace::SuppliesPackage.new 112,12,12
        
      ss.setPendingDamage Deepspace::Damage.newNumericWeapons 2,1

      ss.mountShieldBooster 0
      ss.discardWeaponInHangar 0
      ss.discardShieldBoosterInHangar 0

      puts " la velocidad es #{ss.getSpeed}"

      puts ss.to_s
      ss.move

      puts "¿Es mi estado válido? #{ss.validState}"

			puts ss.hangar.inspect
			puts ss.name
			puts ss.shieldPower.inspect
			puts "a:#{ss.ammoPower} fu:#{ss.fuelUnits} h:#{ss.hangar} n:#{ss.name} nM:#{ss.nMedals}"
			puts "pD:#{ss.pendingDamage} sB:#{ss.shieldBoosters} sP:#{ss.shieldPower} w:#{ss.weapons}"
      
      ss.cleanUpMountedItems

     	
      
      
      
    end  #self test 
  end # class SpaceStation
  
end # module 

Pruebas::SpaceStation.test
