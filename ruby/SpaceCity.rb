require_relative 'SpaceStation'

module Deepspace

  class SpaceCiy < SpaceStation

    def initialize(base, rest)
      super base
      @base = base
      @collaborators = rest
    end

    attr_reader :collaborators

    def fire
      res = super
      @collaboratos.each{ |s|
        res += s.fire
      }
      return res
    end

    def protection
      res = super
      @collaboratos.each{ |s|
        res += s.protection
      }
      return res
    end

    def setLoot(loot)
      super
     # return Transformation::NOTRANSFORM
    end

  end #SpaceCity

end #Module
