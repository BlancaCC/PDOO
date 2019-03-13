# coding: utf-8

#utilizamos requiere_relative, porque la localización del archivo se hará relativa a este fichero de prueba
require_relative 'CombatResult'
require_relative 'Dice'
require_relative 'GameCharacter'
require_relative 'Loot'
require_relative 'ShotResult'
require_relative 'SuppliesPackage'
require_relative 'ShieldBooster'
require_relative 'Weapon'
require_relative 'WeaponType'

module Pruebas

  #@file Fichero de prueba de las clases implementada en la práctica 1


  class TestP1

    def self.main
      ######## prueba de los tipo de datos enumerados ######

      cb = Deepspace::CombatResult::ENEMYWINS
      puts cb
      puts Deepspace::ShotResult::DONOTRESIST
      puts Deepspace::GameCharacter::ENEMYSTARSHIP

      #### prueba del módulo WeaponType ####

      tipo = Deepspace::WeaponType::Type.new(999)
      # visualizamos que se ha construido bien
      puts "Hemos creado un tipo de arma cuyo valor es ",tipo.power
      # probamos tipos creados
      puts "El poder del laser vale ",  Deepspace::WeaponType::LASER.power

      puts " _______ prueba clase Loot _________"
      l = Deepspace::Loot.new(2,3,5,7,11)
      puts "Sus atributos son: "
      puts "  nSupplies: #{l.nSupplies}"
      puts "  nWeapons: #{l.nWeapons}"
      puts "  nShields: #{l.nShields}"
      puts "  nHangars: #{l.nHangars}"
      puts "  nMedals: #{l.nMedals}"


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
      puts "Sus atributos son: "
      #print "  name: ", sb.name  #ERROR: no hay consultor publico
      puts "  boost: #{sb.boost}"
      puts "  uses: #{sb.uses}"

      puts "______ prueba clase Shield booster ____"
      sb2 = Deepspace::ShieldBooster.newCopy(sb)
      puts "Tras crear otro objeto con el contructor de copia su boost es #{sb2.boost}"
      puts "Usamos el metodo useIt: #{sb2.useIt}"
      puts "  boost: #{sb2.boost}"
      puts "  uses: #{sb2.uses}"

      puts "______ prueba clase Diseeeee ____"

      dado = Deepspace::Dice.new()
      3.times do
      #procedemos a probar las funciones aleatorias
      hagar = {0 => 0,1 => 0}
      shield = {0 => 0,1 => 0}
      arma = {1 => 0,2 => 0 , 3 => 0}
      empieza = {Deepspace::GameCharacter::ENEMYSTARSHIP =>0,
                 Deepspace::GameCharacter::SPACESTATION =>0}
      100.times do
      #puts "El resultado de lanzar el dado es #{ dado.initWithNHangar()}"
        hagar[dado.initWithNHangar()] += 1
        shield[dado.initWithNshields()]+= 1
        arma[dado.initWithWeapons()]+= 1
        empieza[dado.firstShot()]+=1
      end

      puts "Procedo a mostrar los resultado de ejecutar 100 veces las instancias de dices "
      puts " initsWithNhagars "
      print hagar

      puts "initsWithNshields"
      print shield

      puts "Weapons"
      print arma

      puts "empieza"
      print empieza
      end # bucle de tres tiempos
    end
  end
end

Pruebas::TestP1.main
