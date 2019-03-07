module Deepspace

  class Weapon

    def initialize(name, type, uses)
      @name = name
      @type = type
      @uses = uses
    end

    attr_reader :name, :type, :uses   #no pide el consultor name pero no sé como acceder a él en el construcotr de copia si no  PREGUNTAR

    def self.newCopy(w)
      new(w.name,w.type,w.uses)
    end

    def power
      type.power
    end

    def useIt
      if @uses > 0
        @uses = @uses-1
        return power
      else
        return 1.0
      end
    end

  end
end
