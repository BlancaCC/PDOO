# coding: utf-8

require_relative 'Damage'

module Deepspace

  class NumericDamage < Damage

    def initialize(w,s)
      super(s)
      @nWeapons = w
    end

    public_class_method :new

    attr_reader :nWeapons

    def self.newCopy(d)
      new(d.w,d.s)
    end

    def getUIversion
      NumericDamageToUI.new(self)
    end

    def adjust(w,s)
      newNShields = adjustShields(s)
      newNWeapons = [@nWeapons,w.size].min
      return new(newNWeapons,newNShields)
    end


    def discardWeapon
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
