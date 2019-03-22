# coding: utf-8


#módulos ToUIgetVersion 
require_relative 'LootToUI'
require_relative 'EnemyToUI'
require_relative 'DamageToUI'
require_relative 'HangarToUI'
require_relative 'ShieldToUI'

## tipos de datos  y clase 
require_relative 'CombatResult'
require_relative 'Dice'
require_relative 'GameCharacter'
require_relative 'Loot'
require_relative 'ShotResult'
require_relative 'SuppliesPackage'
require_relative 'ShieldBooster'
require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'Damage'



module Pruebas

  class TestP2

    def self.main
      puts " _______ prueba clase Loot _________"
      l = Deepspace::Loot.new(2,3,5,7,11)
      puts l.to_s
      ## mótdulo toUigetVersion 
      lui = l.LootToUIgetVersion
      puts lui.to_s
      

      puts "__________ Prueb clase Damage _______"
      d_n = Deepspace::Damage.new_n 2,3
      puts d_n.to_s
      d_w = Deepspace::Damage.new_weapons [Deepspace::WeaponType::LASER,
                                          Deepspace::WeaponType::PLASMA] , 3

      puts d_w.to_s

      puts d_n.getUIVersion.to_s
      
      

      ### clase SupplesPackage
      puts " _______ prueba clase SuppliesPackages _________"
      sp = Deepspace::SuppliesPackage.new( 2,1,4)
      # procedemos a visualizar algunos de sus constructores

      puts "Sus atributos son: "
      puts "  ammoPower: #{sp.ammoPower}"
      puts "  fuelUnits: #{sp.fuelUnits}"
      puts "  shieldPower: #{sp.shieldPower}"
      # prueba cosntructor de copia
      sp2 = Deepspace::SuppliesPackage.newCopy(sp)
      puts "Tras crear otro objeto con el contructor de copia su fuel es #{sp2.fuelUnits} "

      puts " _______ prueba clase ShieldBooster _________"
      sb = Deepspace::ShieldBooster.new("escudo",3.1415,28)
      puts sb.to_s
      sb2 = Deepspace::ShieldBooster.newCopy(sb)
      puts "Tras crear otro objeto con el contructor de copia su boost es #{sb2.boost}"
      puts "Usamos el metodo useIt: #{sb2.useIt}"
      puts sb2.to_s
      sui = sb.ShieldToUIgetVersion
      puts  sui.to_s

      puts "______ prueba clase Diseeeee ____"

      dado = Deepspace::Dice.new()
      3.times do
      #procedemos a probar las funciones aleatorias
      hangar = {0 => 0,1 => 0}
      shield = {0 => 0,1 => 0}
      arma = {1 => 0,2 => 0 , 3 => 0}
      empieza = {Deepspace::GameCharacter::ENEMYSTARSHIP =>0,
                 Deepspace::GameCharacter::SPACESTATION =>0}
      100.times do
      #puts "El resultado de lanzar el dado es #{ dado.initWithNHangar()}"
        hangar[dado.initWithNHangar()] += 1
        shield[dado.initWithNshields()]+= 1
        arma[dado.initWithWeapons()]+= 1
        empieza[dado.firstShot()]+=1
      end

      puts "Procedo a mostrar los resultado de ejecutar 100 veces las instancias de dices "
      puts " initsWithNhangars "
      print hangar

      puts "initsWithNshields"
      print shield

      puts "Weapons"
      print arma

      puts "empieza"
      print empieza
      puts ""
      end # bucle de tres tiempos

    end

  end

end

Pruebas::TestP2.main
