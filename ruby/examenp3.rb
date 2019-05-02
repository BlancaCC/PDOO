# coding: utf-8
require_relative 'SpaceStation'
require_relative 'SuppliesPackage'
require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'ShieldBooster'
require_relative 'Hangar'
require_relative 'Loot'
require_relative 'EnemyStarShip'
require_relative 'Damage'
require_relative 'GameUniverse'

module ModuloExamen
  class ExamenP3
    def self.main
      ## 4

      supplies = Deepspace::SuppliesPackage.new(1,10,10)
      ss = Deepspace::SpaceStation.new("Mi estación", supplies )
      hangar = Deepspace::Hangar.new(10)

      #cargamos armas
      hangar.addWeapon(Deepspace::Weapon.new("espada",
                                             Deepspace::WeaponType::MISSILE,1) )
      2.times {
        hangar.addWeapon(Deepspace::Weapon.new("tirachina",
                                             Deepspace::WeaponType::PLASMA,1))
      }
      5.times{
        hangar.addWeapon(Deepspace::Weapon.new("Piedra",
                                             Deepspace::WeaponType::PLASMA,1))
      }

      #escudos
      2.times{
        hangar.addShieldBooster(Deepspace::ShieldBooster.new("shield",1,2))
      }
      
      ss.receiveHangar(hangar)
      8.times {
        ss.mountWeapon(0)
      }
      2.times{
        ss.mountShieldBooster(0)
      }

      puts ss.to_s

      ### jercicio 5

      loot = Deepspace::Loot.new(0,0,0,0,0)
      armas = []
      armas << Deepspace::WeaponType::LASER
      armas << Deepspace::WeaponType::MISSILE
      armas << Deepspace::WeaponType::LASER
  
              
      damage = Deepspace::Damage.newSpecificWeapons(armas, 5)
      enemy = Deepspace::EnemyStarShip.new("El bueno", 500, 500, loot, damage)

      puts enemy.to_s

      ## ejercicio 6

      game = Deepspace::GameUniverse.new
      
      game.init(["jugador1", "jugardor2"])
      puts game.combatGo(ss,enemy)

      puts ss.to_s
      
      
    end
    
  end
end

ModuloExamen::ExamenP3.main
