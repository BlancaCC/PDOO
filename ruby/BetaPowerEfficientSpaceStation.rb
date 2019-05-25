require_relative 'PowerEfficientSpaceStation'
require_relative 'Dice'

module Deepspace

  class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation

    @@EXTRAEFFICIENCY = 1.2

    def initialize(station)
      super
      @dice = Dice.new
    end

    def fire
      f = super
      if(dice.extraEfficiency == true)
        return f*@@EXTRAEFFICIENCY
      end
      return f
    end

    def getUIversion
      BetaPowerEfficientSpaceStationToUI.new(self)
    end

  end # class BetaPowerEfficientStation

end #module
