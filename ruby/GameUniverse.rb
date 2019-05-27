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
      @dice = Dice.new 
      @gameState = GameStateController.new  


      @currentStationIndex = -1 #int
      @turns = 0 #int
      @currentStation = nil# referencia a un objeto SpaceStation
      @currentEnemy = nil# objeto de la clase EnemyStartShip, sólo una instancia
      @spaceStations = Array.new # objeto de la clase SpaceStation
      @haveSpaceCity=false
      # puedo tener entre 1..*
      
    end # initialize

   

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
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
	return @currentStation.mountShieldBooster(i)
      end
    end

    def mountWeapon(i)
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
	return @currentStation.mountWeapon(i)
      end
    end

    def discardHangar
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
	return @currentStation.discardHangar
      end
    end

    def discardShieldBooster(i)
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
	return @currentStation.discardShieldBooster(i)
      end
    end

    def discardWeapon(i)
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
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
    ### _________ MÉTODOS DE LA PRÁCTICA

    #Este método inicia una partida. Recibe una colección con los
    #nombres de los jugadores. Para cada jugador, se crea una estación espacial y se equipa con
    #suministros, hangares, armas y potenciadores de escudos tomados de los mazos de cartas
    #correspondientes. Se sortea qué jugador comienza la partida, se establece el primer enemigo y
    #comienza el primer turno.
    
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


    
    ## vuelve a la estaciín espacial eficiente
    ## copmuena con el ddado si es beta o no
    def makeStationEfficient
      if dice.extraEfficiency
        @currentStation=BetaPowerEfficientSpaceStation.new @currentStation
        puts "Se acaba de transformar en una estación espacial de efiencia beta"
      else
        currentStation = PowerEfficientSpaceStation.new currentStation
        puts "___Se ha transformado en una PowerEfficientSpaceStation___"
      end
    end

    ## creamos una ciudad espacial 
    def createSpaceCity
      if @haveSpaceCity == false
        @haveSpaceCity=true
        collaborators=[]

        @spaceStation.each do |s| 
          if s != @currentStation
            collaborators << s
          end
        end
        
        @currentStation= SpaceCity.new( @currentStation,collaborators)
        @spaceStation[@currentStationIndex]=@currentStation
        puts "____Se acaba de transformar en una estación espacial____"
      end
    end

    
    # Se comprueba que el jugador actual no tiene ningún daño pendiente de cumplir,
    #  en cuyo caso se realiza un cambio de turno al siguiente jugador con un nuevo enemigo con quien
    #combatir, devolviendo true. Se devuelve false en otro caso.
    
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


    #       Si la aplicación se encuentra en un estado en donde el combatir está
    #       permitido, se realiza un combate entre la estación espacial que tiene el turno y el enemigo actual. Se
    #       devuelve el resultado del combate.

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
        fire = enemy.fire
        result = station.receiveShot(fire) #ShotResult
        if(result == ShotResult::RESIST)
          fire = station.fire
          result = enemy.receiveShot(fire) #ShotResult
          enemyWins=(result==ShotResult::RESIST)
        else
          enemyWins=true
        end
      else
        fire = station.fire
        result = enemy.receiveShot(fire)
        enemyWins=(result==ShotResult::RESIST)
      end #if

      if(enemyWins)
        s = station.getSpeed
        moves = @dice.spaceStationMoves(s) #bool
        if(!moves)
          damage = enemy.damage
          station.setPendingDamage(damage)
          combatResult=CombatResult::ENEMYWINS
        else
          station.move
          combatResult=CombatResult::STATIONESCAPES
        end
      else # si hemos ganado el combate 
        aLoot = enemy.loot
        t=station.setLoot(aLoot) # te almacena si el estado de transformación
        
        if t==Transformation::GETEFFICIENT
          makeStationEfficient()
          combatResult=CombatResult::STATIONWINANDCONVERTS
        elsif t==Transformation::SPACECITY
          createSpaceCity()
          combatResult = CombatResult::STATIONWINSANDCONVERTS
        else 
          combatResult=CombatResult::STATIONWINS
        end
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
