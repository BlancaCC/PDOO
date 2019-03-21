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
      @nShield = s # pontenciades de escudo perdio
      @nWeapons = w #perdida armas tipo indeterminado
      @weapons = wl # tipos de armas concretos que se pierden 
    end # initialize

    private_class_method :new

    # por número de escudos y armas indeterminada
    # array con el tipo de armas indeterminado vacío
    def self.new_n s, w
      new s,w,Array.new 
    end

  end # class
end # module Deespace 
