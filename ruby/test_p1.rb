# coding: utf-8
=begin 
@file Fichero de prueba de las clases implementada en la práctica 1

=end

#utilizamos requiere_relative, porque la localización del archivo se hará relativa a este fichero de prueba

require_relative 'Deepspace'
#include 'Deepspace'
######## prueba de los tipo de datos enumerados ######

cb = Deepspace::CombatResult::ENEMYWINS
puts cb

#### prueba del módulo WeaponType ####

tipo = Deepspace::WeaponType::Type.new( 999)
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
 #sp2 = Deepspace::SuppliesPackage.new(sp)
print "Tras crear otro objeto con el contructor su fuel es " ,# ps2




