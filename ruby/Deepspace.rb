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


end #module Deepspace
