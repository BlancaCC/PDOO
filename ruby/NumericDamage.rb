# coding: utf-8

require_relative 'Damage'
require_relative 'NumericDamageToUI'

module Deepspace

  class NumericDamage < Damage

    def initialize(w,s)
      super(s)
      @nWeapons = w
    end

    public_class_method :new

    attr_reader :nWeapons

    def self.newCopy(d)
      NumericDamage.new(d.w,d.s)
    end

    def getUIversion
      NumericDamageToUI.new(self)
    end

    def adjust(w,s)
      newNShields = adjustShields(s)
      newNWeapons = [@nWeapons,w.size].min
      return NumericDamage.new(newNWeapons,newNShields)
    end


    def discardWeapon i # arreglo esto chapuceramente pasándelo un argumento que no utiliza, para que así haya compatibilidad con ambos discard weapons
      if @nWeapons > 0
        @nWeapons -= 1
      end
    end

    def hasNoEffect
      return super && @nWeapons == 0
    end

    def to_s
      return  "nWeapons:#{@nWeapons}\n" + super
    end

  end #NumericDamage

end # module
