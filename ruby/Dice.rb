# coding: utf-8

module Deepspace
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

      if rand <= @NHANGARPROB # supongo que rand va [0,1]
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
    def initWithWeapons
      aleatorio = rand

      if aleatorio <= @NWEAPONSPROB
        narmas = 1
      elsif aleatorio <= 2*@NWEAPONSPROB
        narmas = 2
      else
        narmas = 3
      end #if probabilidad número de armas

      return narmas

    end # initWhithWeapons
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=begin
          @brief Determian número de potenciadores de escudo
          al ser creada

          @return 0 o 1
=end
    def initWithNshields

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

    def firstShot
      if rand <= @FIRSTSHOTPROB
        primero = GameCharacter::SPACESTATION
      else
        primero = GameCharacter::ENEMYSTARSHIP
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

end
