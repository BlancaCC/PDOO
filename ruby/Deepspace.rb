# coding: utf-8
module Deepspace

  module CombatResult
    # representa todos los resultados posibles de un combate entre una espación espacial y una nave enemiga

    ENEMYWINS= :enemywins
    NOCOMBAT= :nocombat
    STATIONESCAPES= :estationescapes
    STATION= :estationwins
  end # enum CombatResult

  module GameCharacter
    # Representanta a los dos tipos de personajes del juego.

    ENEMYSTARSHIP = :enemystarship
    SPACESTATION = :spacestation
  end # enum GameCharacter

  module ShotResult
    # Representa el resultado a los dos tipos e personajes de juego
    ENEMYSTARSHIP= :enemystarShip
    SPACESTATION= :spaceEstation
  end

  # ---------- Weapon Type ----------

  module WeaponType

    class Type
      # consultor power
      attr_reader :power # equivalente a devolver @power
      
      def initialize ( _power)
        @power= _power
      end # initialize

    end # class Type

    LASER= Type.new(2.0)
    MISSSILE= Type.new(3.0)
    PLASMA= Type.new(4.0)
  end # module weapon

  ######## clases ############
  # incluir de los fichero sueltos
  #eso dijo Blanca del pasado, pero leyendo la práctica pone que todo se haga detro del paquete (módulo en ruby Deepspace)

  
=begin
@file SuppliesPackage.rb
@brief La clase SuppliesPackage epresenta a un paquete de suministros para una
 estación espacial. Puede contener armamento, combustible y/o energía para los escudos.
=end

class SuppliesPackage

=begin CONTRUCTOR CLÁSICO 
  def initialize(ammoPower, fuelUnits, shieldPower)
    @ammoPower = ammoPower
    @fuelUnits = fuelUnits
    @shieldPower = shieldPower
  end   # initialize

  # visualizadores rápidos
  attr_reader :ammoPower, :fuelUnits, :shieldPower

  def self.newCopy(otro)
    new(otro.ammoPower, otro.fuelUnits, otro.shieldPower)
  end   # self.newCopy

=end

  #como pide constructor por parámetros (3) y otro por copia,
  #pero Ruby sólo admite tres, voy a crear un array (de longitud variable)

  # Si se introduce un parámetro intenderá que será por copia,
  # si introduce 3 entendrá que es por los otros tres pasados

  def mi_inicializador(ammoPower, fuelUnits, shieldPower)
    # mi propio constructor
    @ammoPower = ammoPower
    @fuelUnits = fuelUnits
    @shieldPower = shieldPower
  end   # initialize

  private :mi_inicializador

  def initialize (*arg )
    #constructor por copia
    if( arg.size == 1)
      # ojito que podría no devolver números el attr_reader
      # aunque lo he comprobado con esta línea  puts arg[0].ammoPower.class
      mi_inicializador( arg[0].ammoPower, arg[0].fuelUnits, arg[0].shieldPower)
      puts "Supuesta mente debería hacerse construido por copia"
     
    #constructor por parámetros
      #ATENCIÓN, NO HAY CONTROL DE ERROR DE OTROS CONSTRUCTORES
    elsif (arg.size >= 3 )
      mi_inicializador( arg[0], arg[1], arg[2])
    end # constructor por copia y parámetros
  end #inizialize

  # visualizadores rápidos
  attr_reader :ammoPower, :fuelUnits, :shieldPower

end # class SupliesPackage 

  
end #module Deepspace
