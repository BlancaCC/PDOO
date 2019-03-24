# coding: utf-8

module Deepspace
=begin 
@brief Representación del daño producido por una nave espacial enemiga a una estación espacial cuando se pierde un combate. 

Cada intacia indicca la pérdida: 
- potenciadore de escudo 
- una cantida de tipos indetermina de armas
- un conjunto de armas concretas a eliminar 
=end
  class Damage

    #### _____ constructores _____
    
    def initialize s, w, wl
      @nShields = s # pontenciades de escudo perdio
      @nWeapons = w #perdida armas tipo indeterminado
      @weapons = wl # tipos de armas concretos que se pierden 
    end # initialize

    private_class_method :new

    # por número de escudos y armas indeterminada
    # array con el tipo de armas indeterminado vacío
    def self.newNumericWeapons s, w
      new s,w,Array.new 
    end

    #constructor armas concretas a eliminar y cantidad de escudos a eliminar
    def self.newSpecificWeapons wl, s
      new s, 0, wl
    end

    # constructor por copia
    def self.newCopy d
      new d.getNShields, d.getNWeapons, d.getWeapons
    end

     ### ________ métodos de la clase ______

    # método de copia de 
    def  getUIversion
      Deepspace::DamageToUI.new self
    end

    ## weapons, WeaponType
    def arrayContainsType w, s
    end
    private :arrayContainsType

    # weapons s ShieldBooster -> Damage
    def adjust w, s
    end

    #weapon 
    def discardWeapon w
    end

    def discardShieldBooster
    end

    def hasNoEffect
    end
    
 
    ## _________ consultores ______
    # QUITO ALGUNO DE ESTOS?
    attr_reader :nWeapons, :weapons, :nShields
=begin
    def getNshield
      @nShields
    end

    def getNWeapons
      @nWeapons
    end

    def getWeapons
      @weapons
    end
=end         
   
    

    # _____ método de prueba
    def to_s
      "nShields: #{@nShield} \nnWeapons:#{@nWeapons}\n#{@weapons}\n"
    end 
  end # class
end # module Deespace 
