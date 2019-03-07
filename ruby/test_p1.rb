# coding: utf-8

#utilizamos requiere_relative, porque la localización del archivo se hará relativa a este fichero de prueba
require_relative 'CombatResult'
require_relative 'Dice'
require_relative 'GameCharacter'
require_relative 'Loot'
require_relative 'ShotResult'
require_relative 'SuppliesPackage'
require_relative 'Weapon'
require_relative 'WeaponType'

module Pruebas

  #@file Fichero de prueba de las clases implementada en la práctica 1


  class TestP1

    def self.main
      ######## prueba de los tipo de datos enumerados ######

      cb = Deepspace::CombatResult::ENEMYWINS
      puts cb

      #### prueba del módulo WeaponType ####

      tipo = Deepspace::WeaponType::Type.new(999)
      # visualizamos que se ha construido bien
      puts "Hemos creado un tipo de arma cuyo valor es ",tipo.power
      # probamos tipos creados
      puts "El poder del laser vale ",  Deepspace::WeaponType::LASER.power

      ### clase SupplesPackage
      puts " _______ prueba clase suppliesPackages _________"
      sp = Deepspace::SuppliesPackage.new( 2,1,4)
      # procedemos a visualizar algunos de sus constructores

      puts "Sus unidades de armamento son ", sp.ammoPower
      # prueba cosntructor de copia
      #NO FUNCIONA EL CONSTRUCTOR DE COPIA
       sp2 = Deepspace::SuppliesPackage.newCopy(sp)
      puts "Tras crear otro objeto con el contructor su fuel es " , sp2.ammoPower

    end
  end
end

Pruebas::TestP1.main
