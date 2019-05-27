require_relative 'SpaceStation.rb'

module Deepspace

  class PowerEfficientSpaceStation < SpaceStation

    @@EFFICIENCYFACTOR = 1.1

    def initialize(station)
      self.class.newCopy(station)
      puts self.inspect
    end

    def fire
      super*@@EFFICIENCYFACTOR
    end

    def protection
      super*@@EFFICIENCYFACTOR
    end

    def setLoot loot
      t = super loot
      if(t == Transformation::SPACECITY)
        return Transformation::NOTRANSFORM
      end
      return t
    end

    def setLoot loot
      super
      return Transformation::NOTRANSFORM
    end

    def getUIversion
      PowerEfficientSpaceStationToUI.new(self)
    end

  end #class PowerEfficientSpaceStation

end #module
