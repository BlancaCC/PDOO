# coding: utf-8

require_relative "GameUniverseToUI"
require_relative "GameStateController"
require_relative "Dice"
require_relative "CombatResult"
require_relative "GameCharacter"
require_relative "ShotResult"
require_relative "SpaceStation"
require_relative "CardDealer"
require_relative "EnemyStarShip"
require_relative "GameState"


module Deepspace
  class GameUniverse

    @@WIN = 10
    def initialize
      @dice = Dice.new # creamos el dado
      @gameState = GameStateController.new  # objeto de la clase GameStateController
      # (supongo que deberá estar a INIT)
      ## (No necesitaríamso saber antes el número de jugadores )

      @currentStationIndex = -1 #int
      @turns = 0 #int
      @currentStation = nil# referencia a un objeto SpaceStation
      @currentEnemy = nil# objeto de la clase EnemyStartShip, sólo una instancia
      @spaceStations = Array.new # objeto de la clase SpaceStation
      # puedo tener entre 1..*
    end # initialize

    ### ______ métodos _____

		def state
      @gameState.state
    end

    # Devuelve true si algún jugador ha llegado al númerdo de medallas necesarias para ganar
    def haveAWinner
			if(@currentStation.nMedals >= @@WIN)
				return true
			else
				return false
			end
    end # haveAWinner

		def mountShieldBooster(i)
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.mountShieldBooster(i)
			end
		end

		def mountWeapon(i)
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.mountWeapon(i)
			end
		end

		def discardHangar
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.discardHangar
			end
		end

		def discardShieldBooster(i)
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.discardShieldBooster(i)
			end
		end

		def discardWeapon(i)
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.discardWeapon(i)
			end
		end

    def discardShieldBoosterInHangar(i)
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        return @currentStation.discardShieldBoosterInHangar(i)
      end
    end

		def discardWeaponInHangar(i)
			if @gameState.state==GameState::INIT ||@gameState.state==GameState::AFTERCOMBAT
				return @currentStation.discardWeaponInHangar(i)
			end
		end

    ## Los métodos mount* discard* delegan en el método homoínimo de la estación espacial que tenga el turno, siempre que se cumpla que el juego se INIT o AFTERCOMBAt. En caso contrario no tiene ningún efecto
    ### _________ MÉTODOS DE LA PRÁCTICA 3 ________

=begin
Este método inicia una partida. Recibe una colección con los
nombres de los jugadores. Para cada jugador, se crea una estación espacial y se equipa con
suministros, hangares, armas y potenciadores de escudos tomados de los mazos de cartas
correspondientes. Se sortea qué jugador comienza la partida, se establece el primer enemigo y
comienza el primer turno.
=end
    def init names
      st = @gameState.state
      if(st == GameState::CANNOTPLAY)
        dealer = CardDealer.instance
        names.each { |name|
          supplies = dealer.nextSuppliesPackage
          station = SpaceStation.new(name,supplies)
          nh = @dice.initWithNHangars #int
          nw = @dice.initWithNWeapons
          ns = @dice.initWithNShields
          lo = Loot.new(0,nw,ns,nh,0) # Loot
          station.setLoot(lo)
          @spaceStations << station
        }
        @currentStationIndex = @dice.whoStarts(names.size)
        @currentStation = @spaceStations[@currentStationIndex]
        @currentEnemy = dealer.nextEnemy # EnemyStartShip
        @gameState.next(@turns,@spaceStations.size)
      end # if
    end #init


=begin
Se comprueba que el jugador actual no tiene ningún daño pendiente de cumplir,
en cuyo caso se realiza un cambio de turno al siguiente jugador con un nuevo enemigo con quien
combatir, devolviendo true. Se devuelve false en otro caso.
=end
    def nextTurn
      st = @gameState.state
      if(st == GameState::AFTERCOMBAT)
        stationState = @currentStation.validState

        if(stationState)
          @currentStationIndex = (@currentStationIndex+1)%@spaceStations.size
          @turns += 1
          @currentStation = @spaceStations[@currentStationIndex]
          @currentStation.cleanUpMountedItems
          dealer = CardDealer.instance
          @currentEnemy = dealer.nextEnemy
          @gameState.next(@turns,@spaceStations.size)
          return true
        end #if

      end #if

      return false
    end #nextTurn

=begin
Si la aplicación se encuentra en un estado en donde el combatir está
permitido, se realiza un combate entre la estación espacial que tiene el turno y el enemigo actual. Se
devuelve el resultado del combate.
=end
    def combat
      st = @gameState.state
      if(st == GameState::BEFORECOMBAT || st == GameState::INIT)
        return combatGo(@currentStation,@currentEnemy)
      else
        return CombatResult::NOCOMBAT
      end
    end

    def combatGo station,enemy
      ch = @dice.firstShot

      if(ch == GameCharacter::ENEMYSTARSHIP)
        fire = @currentEnemy.fire
        result = @currentStation.receiveShot(fire) #ShotResult
        if(result == ShotResult::RESIST)
          fire = @currentStation.fire
          result = @currentEnemy.receiveShot(fire) #ShotResult
          enemyWins=(result==ShotResult::RESIST)
        else
          enemyWins=true
        end
      else
        fire = @currentStation.fire
        result = @currentEnemy.receiveShot(fire)
        enemyWins=(result==ShotResult::RESIST)
      end #if

      if(enemyWins)
        s = @currentStation.getSpeed
        moves = @dice.spaceStationMoves(s) #bool
        if(!moves)
          damage = @currentEnemy.damage
          @currentStation.setPendingDamage(damage)
          combatResult=CombatResult::ENEMYWINS
        else
          @currentStation.move
          combatResult=CombatResult::STATIONESCAPES
        end
      else
        aLoot = @currentEnemy.loot
        @currentStation.setLoot(aLoot)
        combatResult=CombatResult::STATIONWINS
      end
      @gameState.next(@turns,@spaceStations.size)

      return combatResult

  end #combatGo


		def getUIversion
			GameUniverseToUI.new(@currentStation,@currentEnemy)
		end

		def to_s
			s = "Objeto GameUniverse\n"
			s += "@@WIN: #{@@WIN}\n"
			s += "@dice: #{@dice}\t @gameState: #{@gameState}\t @turns: #{@turns}\n"
			s += "@currentStationIndex: #{@currentStationIndex}\t @currentStation: #{@currentStation}\t @currentEnemy: #{@currentEnemy}\n"
			s += "@spaceStations: #{@spaceStations}"
			return s
		end

  end # GameUniverse
end # Deepspace
