# coding: utf-8

require_relative 'Damage'
require_relative 'SpecificDamageToUI'

module Deepspace

  class SpecificDamage < Damage

    def initialize(wl,s)
      super(s)
      @weapons = wl
    end

    public_class_method :new

    attr_reader :weapons

    def self.newCopy(d)
      SpecificDamage.new(d.weapons,d.nShields)
    end

    def getUIversion
      SpecificDamageToUI.new(self)
    end

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

   def adjust(w,s)
     newNShields = adjustShields(s)

     auxWeap = w.clone
     newWeapons = Array.new
     @weapons.each { |weapon|
       ind = arrayContainsType(auxWeap,weapon)
       if(ind != -1)
         newWeapons << weapon
         auxWeap.delete_at(ind)
       end
     }

     return SpecificDamage.new(newWeapons,newNShields)
   end

   def discardWeapon(w)
     @weapons.size.times do |i|
       if(@weapons[i]==w.type)
         @weapons.delete_at(i)
         return
       end
     end
   end

   def hasNoEffect
     super && @weapons.size == 0
   end

   def to_s
     s="Weapons:\n"
     weapons.each do |w| s += w.to_s end
     s+= "\n"
     s+=super
     return s
   end

 end # SpecificDamage

end #module
