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


class Weapon

  def initialize(name, type, uses)
    @name = name
    @type = type
    @uses = uses
  end

  attr_reader :name, :type, :uses   #no pide el consultor name pero no sé como acceder a él en el construcotr de copia si no  PREGUNTAR

  def self.newCopy(w)
    new(w.name,w.type,w.uses)
  end

  def power
    type.power
  end

  def useIt
    if @uses > 0
      @uses = @uses-1
      return power
    else
      return 1.0
    end
  end

end


#____________________ Clase Dice _____________

=begin
        @brief determian las decisiones que dependen del azar de la clase
=end
class Dice

  def initialize

    @NHANGARPROB = 0.25  # probabilidad número de hagares
    @NSHIELDSPROB = 0.25 # potenciadore escudos
    @NWEAPONSPROB = 0.33 # número armas que recibirá estación espaci
    @FIRSTSHOTPROB = 0.5 # quien empieza la partida

    Random.new_seed # semilla del aleatorio
    # HE DECIDIO PONERLA AQUÍ PREGUNTAR DÓNDE ES MÁS CORRECTO

  end #initialize

  # --- métodos ---
=begin
        @brief Función aleatorio determinar número de hagares
        @return función que varía entre 0 o 1
=end
  def initWithNHangar

    if rand <= @NHANGARPRON # supongo que rand va [0,1]
      nhagar = 0
    else
      nhagar = 1
    end #if random

    return nhagar
  end # initWithNHangar
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=begin
    @brief Determinará númer de armas que recibirá una estación esàcial al ser creada
    @return 0,1,2
=end
  def initWhithWeapons
    aleatorio = rand

    if aleatorio <= @NWEAPONSPROB
      narmas = 0
    elsif aleatorio <= 2*@NWEAPONSPROB
      narmas = 1
    else
      narmas = 2
    end #if probabilidad número de armas

    return narmas

  end # initWhithWeapons
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=begin
        @brief Determian número de potenciadores de escudo
        al ser creada

        @return 0 o 1
=end
  def WithNshields

    if rand <= @NSHIELDSPROB
      nshields = 0
    else
      nshields = 1
    end # if probabilidad shield

    return nshields
  end #WithNshields
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=begin
   @brief Determina el número de jugador que empieza a jugar
   @param nPlayers: Número de jugadores totales
   @return índice del jugador que iniciará la partida
=end

  def whoStarts( nPlayers)

    return rand( nPlayers)

  end #whoStarts( nPlayers)

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=begin
@brief Determian quien empieza a disparar
@return devuelve elemento del tipo del dato Enumerado GameCharacter
=end

  def GameCharacter
    if rand <= @FIRSTSHOTPROB
      primero = GameCharacter::SPACESTATION
    else
      primero = GameCharacter::ENEMYSTARTSHIP
    end # if quién empieza
    return primero
  end #GameCharacter
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


=begin
        @brief Determian si la estación espacial se moverá para esquivar un disparo
@param speed float [0,1], cuando mayor sea mayor probabilidad tendrá de esquivarlo
@return true si la esquiva, false en caso contrario
=end

  def spaceStationMoves( speed)
    if rand(1.0) <= speed
      esquiva = true
    else
      esquiva = false
    end # rando si esquiva
    return esquiva

  end #  spaceStationMoves( speed)

   # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
end # clase Dice




end #module Deepspace
