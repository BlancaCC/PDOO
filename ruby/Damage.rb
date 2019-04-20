# coding: utf-8

require_relative 'DamageToUI'

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
      @nWeapons = w # perdida armas tipo indeterminado
      @weapons = wl # list tipos de armas concretos que se pierde
    end # initialize

    attr_reader :nShield, :nWeapons, :weapons
    private_class_method :new

    # por número de escudos y armas indeterminada
    # array con el tipo de armas indeterminado vacío
    def self.newNumericWeapons s, w
      new s,w,nil
    end

    #constructor armas concretas a eliminar y cantidad de escudos a eliminar
    def self.newSpecificWeapons wl, s
      #eliminamos tipos repetidos repetidos
      wl = wl.uniq
      new s,-1,wl
    end

    # constructor por copia
    def self.newCopy d
      new d.nShields, d.nWeapons, d.weapons
    end

     ### ________ métodos de la clase ______

    # método de copia de
    def  getUIversion
      Deepspace::DamageToUI.new self
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

     # ajustamos escudos
     len = s.length()
     if @nShields > len
       s = Array.new
       @nShields = len # ajustamos el tamaño que quitamos
     else
       s = s.drop @nShields
     end # ajuste de escudos

     # ajustamos armas
     # si se especifica tipo
     if @nWeapons == -1
       @weapons.each  do |t|
         # si no está lo eliminamos del daño
         if arrayContainsType(w,t) == -1
           @weapons.delete t
         else
           w = w.reject { |weapon| weapon.type == t}
         end #if
       end #do weapons
     else # si se va a eliminar por número
       len = w.length()
       if @nWeapons > len
         @nWeapons = len
         w = Array.new
       else
         w = w.drop @nWeapons
       end # if
     end #if cantidad vs tipo
     # devuelvo el propio objeto damage
     return Damage.newCopy self
   end #adjust



    #intenta eliminar el tipo concreto de arma
    # decrementa el contador de armas montadas, nunca es menor que 0
    def discardWeapon w
      # si hay armas disponibles
      if @weapons != nil

        @weapons.each do |weapon|
          if weapon == w then
            @weapons.delete(weapon)
            #reducimos contador
          end #if
        end #do
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
      @nShields <= 0 and not (@nWeapons > 0 or @weapons != nil )
    end


    ## _________ consultores ______

    attr_reader :nWeapons, :weapons, :nShields



    # _____ método de prueba
    def to_s
      s1 = "nShields: #{@nShields} \nnWeapons:#{@nWeapons}\nWeapons"
      if @weapons == nil
        s1 += ": nil\n"
      else
        s1 += " power: "
        @weapons.each do |w|
          s1 += "#{w.power} "
        end
        s1+= "\n"
      end

      s1
    end #to_s


  end # class
end # module Deespace
