# coding: utf-8

# SIN ACABAR 

module Deepspace
  class GameUniverse

    @WIN = 10
    def initilize
      @dice = #Deepspace::Dice.new # creamos el dado
      @gameState = Deepspace::GameStateController.new  # objeto de la clase GameStateController
      # (supongo que deberá estar a INIT)
      ## (No necesitaríamso saber antes el número de jugadores )

      @currentStationIndex = dice #int 
      @turn=0 #int
      @spac
      @currentEnemy # objeto de la clase EnemyStartShip, sólo una instancia
      @spaceStations # objeto de la clase SpaceStation
      # puedo tener entre 1..*
      

      
      
    end # initialize

    ### ______ métodos _____

    # Devuelve true si algún jugador ha llegado al númerdo de medallas necesarias para ganar
    def haveAWinner

    end # haveAWinner


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
  end # GameUniverse 
end # Deepspace 
