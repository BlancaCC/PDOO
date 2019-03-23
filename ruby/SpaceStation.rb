#coding: utf-8

module Deepspace

  @@MAXFUEL=100 #declaraods como isntancia de clase para poder ser consultados sin necesidad de construir consultores 
  @@SHIELDLOSSPERUNTSHOT=0.2

  
  # Contiento todo lo referente a una estación espacial 
  class SpaceStation

    # los arguments que reciben es un string y SuppliesPackage 
    def initialize n, supplies
      #nombre de la estación espacial 
      @name = n

      #atributos de poder y otras propiedad
      @ammoPower = 0 # potencia de disparo 
      @fuelUnits = 0
      @shieldPower = 0
      @nMedals = 0    
      @pendingDamage = nil 

      # suministros en la estación 
      @weapons = Array.new
      @shieldBooster = Array.new

      #hagar del que depende 
      @hagar = nil
      
    end #initialize


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

    def SpaceStation n, supplies
      # yo diría que lo que hace es añadri esta estación espacial a la lista
    end


    # si disponemos de Hangars devuelve el resultado de intentar añadir el arma al msimo, si no devuelve true
    def receiveWeapon w
      if @hangar
        #la hangar.addWeapon  devuelve si ha modido añadirla o no 
        @hangar.addWeapon w

      end # if
      false 
    end #receiveWeapn

    def receiveShieldBooster s
      if @hangar 
        # addChieldBooster  devuelve si ha modido añadirla o no 
        @hangar.addShieldBooster s

      end # if
      false 
    end #receiveShieldBooster s

    def receiveHangar h
      if not @hangar
        @hangar = h
      end #if 
    end # receiveHangar

    def discarHangar
      @hangar = nil
    end

    ## potencia las unidades de disparo, escuro  combustible con las del paquete recivido
    def receiveSupplies s
      @ammoPower += s.ammoPower
      @fuelUnits += s.fuelUnits
      @shieldPower += s.shieldPower 
    end #receiveSupplies s

    #Se calcula el parámetro adjust a la list ade armas y pontenciadores de al estaciín y se almacena el resutado en el al atributo correspondiente
    def setPendingDamage d
      @pendingDamage = d.adjust @weapons @shieldPower
      
    end

    # __ suministrar métdos desde hangar __
    def mountWeapon i
      if @hangar
        weapon_aux = @hangar.removeweapon i
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
          @shieldBooster << shieldBooster_aux
        end
      end 
    end #muntShieldBooster 

    #___ métodos péridad de suministros en hangar 
    def discardWeaponInHangar i
      @hangar.removeShieldBooster i
    end

    def discardShield 

    
    

    
    
  end # SpaceStation 
end #moduel deepspace
