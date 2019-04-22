#coding: utf-8

require_relative "SpaceStationToUI"

module Deepspace
  require_relative 'ShotResult'

  # Contiento todo lo referente a una estación espacial
  class SpaceStation

    @@MAXFUEL=100 #declaraods como instancia de clase para poder ser consultados sin necesidad de construir consultores
    @@SHIELDLOSSPERUNITSHOT=0.1

    # los arguments que reciben es un string y SuppliesPackage
    def initialize n, supplies
      #nombre de la estación espacial
      @name = n

      #atributos de poder y otras propiedad
      @ammoPower = supplies.ammoPower # potencia del disparo
      assignFuelValue supplies.fuelUnits # aquí se declara en la primera vez @fuelUnits
      @shieldPower = supplies.shieldPower

      @nMedals = 0
      @pendingDamage = nil

      # suministros en la estación
      @weapons = Array.new
      @shieldBoosters = Array.new

      #hangar del que depende
      @hangar = nil


    end #initialize

		attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals
		attr_reader :pendingDamage, :shieldBoosters, :shieldPower, :weapons

    #___ métodos privado ___
    def assignFuelValue f
      if f <= @@MAXFUEL

        @fuelUnits = f # ¿sería necesario las comprobaciones de que es mayr que 0?
      else
        @fuelUnits = @@MAXFUEL
      end #if
    end #assignFuelValues

    def cleanPendingDamage
      # si PendingGame no tiene efecto fija la referecia a null
      @pendingDamage = nil# algúm metodo habrá para ajustarlo
    end #cleanPendingDamage

    private :assignFuelValue
    private :cleanPendingDamage

    #___ métodos públicos ___

    # si disponemos de Hangars devuelve el resultado de intentar añadir el arma al msimo, si no devuelve true
    def receiveWeapon w
      conseguido = false
      if @hangar
        #la hangar.addWeapon  devuelve si ha podido añadirla o no
        conseguido = @hangar.addWeapon w

      end # if
      conseguido
    end #receiveWeapn


    def receiveShieldBooster s
      conseguido = false
      if @hangar
        # addShieldBooster  devuelve si ha podido añadirla o no
        conseguido = @hangar.addShieldBooster s


      end # if
      conseguido
    end #receiveShieldBooster s

    def receiveHangar h
      if not @hangar
        @hangar = h
      end #if
    end # receiveHangar

    def discardHangar
      @hangar = nil
    end

    ## potencia las unidades de disparo, escuro  combustible con las del paquete recivido
    def receiveSupplies s
      @ammoPower += s.ammoPower
      assignFuelValue(@fuelUnits + s.fuelUnits)
      @shieldPower += s.shieldPower
    end #receiveSupplies s

    def receiveShot shot
      resultado = nil

      if protection() >= shot
        @shieldPower -= @@SHIELDLOSSPERUNITSHOT*shot
        @shieldPower = [0.0, @shieldPower].max

        resultado = ShotResult::RESIST
      else
        @shieldPower = 0.0
        resultado = ShotResult::DONOTRESIST
      end
      resultado
    end

    #Se calcula el parámetro adjust a la list ade armas y pontenciadores de al estaciín y se almacena el resutado en el al atributo correspondiente
    def setPendingDamage d
      @pendingDamage = d.adjust @weapons, @shieldPower

    end

		def setLoot loot
		end

    # __ suministrar métdos desde hangar __
    def mountWeapon i
      if @hangar
        weapon_aux = @hangar.removeWeapon i
        if weapon_aux
          weapons << weapon_aux
        end

      end
    end #mountWeapon
    # Se intenta montar el potenciador del escodo con el índice i dentro de hangar
    def mountShieldBooster i
      if @hangar
        # No se comprueba que el índice es el correcto
        # en caso de boorarse devuelve nil
        shieldBooster_aux = @hangar.removeShieldBooster i
        if shieldBooster_aux # no queremos añadir nil
          @shieldBoosters << shieldBooster_aux
        end
      end
    end #muntShieldBooster

    #___ métodos péridad de suministros en hangar
    def discardWeaponInHangar i
      if @hangar
        @hangar.removeWeapon i
      end
    end

    #si dispone de un arma se solicita al mismo descartar el potenciador de escodo de tal índice
    def discardShieldBoosterInHangar i
      if @hangar
        @hangar.removeShieldBooster i
      end
    end

		def discardWeapon i
		end

		def discardShieldBooster s
		end

    # velocida estación espacial
    def getSpeed
      @fuelUnits.to_f/@@MAXFUEL
    end

    # decremento de las unidades de combustible a causa de su movimiento
    def move
      ## realizo aquí la comprobación de que no puede ser 0
      #aunque lo que define la velocidad es una serie geométrica que converge a 0 por valores mayores,
      # de todas formas lo mantengo por si acaba modificándose en algún momento
      speed = getSpeed
      if @fuelUnits >= speed
        @fuelUnits -= speed
      else
        @fuelUnits = 0
      end
    end

    # estado valido: no daño o daño sin efecto
    def validState
      validState = true
      if @pendingDamage and not @pendingDamage.hasNoEffect
        validState = false
      end
      validState

    end


    # elimina todas lar armas y potenciadoroes de escudos montados a los que no les queden usos
    def cleanUpMountedItems
      # eliminamos armas
      @weapons.each do |arma|
        if arma.uses == 0
          @weapons.delete arma
        end
      end

      #eliminamso escudos
      @shieldBoosters.each do |escudo|
        if escudo.uses == 0
          @shieldBoosters.delete escudo
        end
      end
    end # cleanUpMountedItems


    def fire
      factor = 1
      @weapons.each do |w|
        factor *= w.useIt()
      end
      @ammoPower*factor
    end

    def protection

      factor = 1
      @shieldBoosters.each do |s|
        factor *= s.useIt
      end
      factor*shieldPower
    end

      def to_s

        """
Información de la estacion espacial:  #{@name}
 -- Recursos actuales montados --
        ammoPower #{@ammoPower}
        fuelUnits #{@fuelUnits}
        shieldPower #{@shieldPower}
        medallas #{@nMedals}
 -- otros --
   --- peding damage ---
       #{@pendingDamage.to_s}
   ---weapons---
     #{@weapons.each do |w|;w.to_s; end }
	 ---shieldBoosters---
		#{@shieldBoosters.each do |s|;s.to_s;end}
	---hangar---
#{@hangar}---
Información general de todas las estaciones espaciales:
     MAXFUEL:  #{@@MAXFUEL}
     SHIELDLOSSPERUNITSHOT: #{@@SHIELDLOSSPERUNITSHOT}
        """

      end # to stirng method

    def getUIversion
      SpaceStationToUI.new(self)
    end

  end # SpaceStation

end #module deepspace
