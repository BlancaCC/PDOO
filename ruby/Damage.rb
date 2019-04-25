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

    def initialize  w,s, wl
      @nShields = s # pontenciades de escudo perdio
      @nWeapons = w # perdida armas tipo indeterminado
      @weapons = wl # list tipos de armas concretos que se pierde
    end # initialize

    attr_reader :nShields, :nWeapons, :weapons
    private_class_method :new

    # por número de escudos y armas indeterminada
    # array con el tipo de armas indeterminado vacío
    def self.newNumericWeapons w,s
      new w,s,nil
    end

    #constructor armas concretas a eliminar y cantidad de escudos a eliminar
    def self.newSpecificWeapons wl, s
      new -1,s,wl
    end

    # constructor por copia
    def self.newCopy d
      new  d.nWeapons, d.nShields, d.weapons
    end

     ### ________ métodos de la clase ______

    # método de copia de
    def  getUIversion
      DamageToUI.new self
    end

    ## ArrayList<weapons>, WeaponType
    ## devuelve índice de la primera arma del array que coincida con el tipo, en su defecto -1
    def arrayContainsType w, t
      indice= -1

      indice_aux = 0
      len = w.length

      while indice == -1 and indice_aux < len
        if w[indice_aux].type == t
          indice = indice_aux
        else
          indice_aux += 1
        end #if
      end #while

      indice
    end
   private :arrayContainsType

   # weapons s ShieldBooster -> Damage
   # le quitamos las armas y el número de escudos que esté en el paquete
   def adjust w, s

    newNShields = [s.size,@nShields].min
    if(@nWeapons == -1)
      auxWeap = w.clone
      newWeapons = Array.new
      @weapons.each { |weapon|
        ind = arrayContainsType(auxWeap,weapon)
        if(ind != -1)
          newWeapons << weapon
          auxWeap.delete_at(ind)
        end
      }
      return self.class.newSpecificWeapons(newWeapons,newNShields)
    else
      newNWeapons = [@nWeapons,w.size].min

      return self.class.newNumericWeapons(newNWeapons,newNShields)
    end

   end #adjust



    #intenta eliminar el tipo concreto de arma
    # decrementa el contador de armas montadas, nunca es menor que 0
    def discardWeapon w
      # si hay armas disponibles
      if @weapons != nil
        @weapons.size.times do |i|
          if(@weapons[i]==w.type)
            puts @weapons.delete_at(i)
            return
          end
        end
      elsif @nWeapons > 0
        @nWeapons -= 1
      end #elsif

    end # discardWeapon

    # descarta un escudo, reducirá si el contador es mayor que 0
    def discardShieldBooster
      if @nShields > 0
        @nShields -= 1
      end
    end

    # duevuelve true si el daño representado tiene algún efecto
    def hasNoEffect
      if(@nWeapons == -1)
        return @weapons.size==0 && @nShields==0
      else
        return @nWeapons == 0 && @nShields == 0
      end
    end





    # _____ método de visualización
    def to_s
      s1 = "nShields: #{@nShields} \nnWeapons:#{@nWeapons}\nWeapons"
      if @weapons == nil
        s1 += ": nil\n"
      else
        
        weapons.each do |w| s1 += w.to_s end

        s1+= "\n"
      end

      s1
    end #to_s


  end # class

end # module Deespace
