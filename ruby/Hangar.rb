module Deepspace

  class Hangar

    private def initialize(capacity, weapons, shieledBoosters)
      @maxElements = capacity
      @weapons = weapons
      @shieldBoosters = shieldBoosters
    end

    def newCapacity(capacity)
      new(capacity,Array.new,Array.new)
    end

    attr_reader :maxElements, :weapons, :shieldBoosters

    def newCopy(h)
      new(h.maxElements,h.weapons,h.shieldBoosters)
    end

  end

end
