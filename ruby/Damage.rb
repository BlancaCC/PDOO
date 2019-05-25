# coding: utf-8

require_relative 'DamageToUI'
require_relative 'WeaponType'
require_relative 'Weapon'

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

    def initialize s
      @nShields = s # pontenciades de escudo perdio
    end # initialize

    attr_reader :nShields
    private_class_method :new 


     ### ________ métodos de la clase ______


    ## ArrayList<weapons>, WeaponType
    ## devuelve índice de la primera arma del array que coincida con el tipo, en su defecto -1



   private def adjustShields(s)
     return [s.size,@nShields].min
   end




    # descarta un escudo, reducirá si el contador es mayor que 0
    def discardShieldBooster
      if @nShields > 0
        @nShields -= 1
      end
    end

    # duevuelve true si el daño representado tiene algún efecto
    def hasNoEffect
      @nShields == 0
    end


    # _____ método de visualización
    def to_s
      return "nShields: #{@nShields}\n"
    end #to_s


  end # class

end # module Deespace
