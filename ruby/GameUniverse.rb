# coding: utf-8

# SIN ACABAR 

module Deepspace
  class GameUniverse

    @@WIN = 10
    def initialize
      @dice = Dice.new # creamos el dado
      @gameState = GameStateController.new  # objeto de la clase GameStateController
      # (supongo que deberá estar a INIT)
      ## (No necesitaríamso saber antes el número de jugadores )

      @currentStationIndex #int 
      @turns = 0 #int
      @currentStation # referencia a un objeto SpaceStation
      @currentEnemy # objeto de la clase EnemyStartShip, sólo una instancia
      @spaceStations # objeto de la clase SpaceStation
      # puedo tener entre 1..*
    end # initialize

    ### ______ métodos _____

		attr_reader :gameState

    # Devuelve true si algún jugador ha llegado al númerdo de medallas necesarias para ganar
    def haveAWinner
			if(@currentStation.nMedals >= @@WIN)
				return true
			else
				return false
			end
    end # haveAWinner

		def mountShieldBooster(i)
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT
				return @currentStation.mountShieldBooster(i)
			end
		end

		def mountWeapon(i)
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT 
				return @currentStation.mountWeapon(i)
			end
		end

		def discardHangar
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT
				return @currentStation.discardHangar
			end
		end			

		def discardShieldBooster(i)
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT
				return @currentStation.discardShieldBooster(i)
			end
		end

		def discardWeapon(i)
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT
				return @currentStation.discarWeapon(i)
			end
		end

		def discardWeaponInHangar(i)		
			if @gameState==GameState::INIT ||@gameState==GameState::AFTERCOMBAT
				return @currentStation.discardWeaponInHangar(i)
			end
		end

    ## Los métodos mount* discard* delegan en el método homoínimo de la estación espacial que tenga el turno, siempre que se cumpla que el juego se INIT o AFTERCOMBAt. En caso contrario no tiene ningún efecto
    ### _________ MÉTODOS DE LA PRÁCTICA 3 ________

    def init names
      
    end #init

    def nextTurn
    end

    def combat
    end

    def combatGo station,enemy
    end 

		
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
